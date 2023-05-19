package com.javaholics.web.controller;

import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.repository.UserRepository;
import com.javaholics.web.service.RouteService;
import com.javaholics.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/public")
public class RouteController {

    private final RouteService routeService;
    private final UserRepository userRepository;
    UserService userService;

    public RouteController(RouteService routeService, UserRepository userRepository) {
        this.routeService = routeService;
        this.userRepository = userRepository;
    }

    @GetMapping("/routes")
    public String showRoutes(Model model) {
        List<RouteDto> routeList = routeService.getRoutes();
        model.addAttribute("routes", routeList);
        return "routes/routes";
    }
    @GetMapping("/routes/myroutes")
    public String showMyRoutes(Model model) {
        Long id;
        String email = routeService.useridName();
        id = userRepository.findByEmail(email).get().getId();
        List<RouteDto> routeList = routeService.findRouteByUserId(id);
        model.addAttribute("routes", routeList);
        return "routes/myroutes";
    }
    @GetMapping("/routes/mysearch")
    public String showMyRoutesFilter(@RequestParam(required = false) String locality, @RequestParam(required = false) String typeWord, @RequestParam(required = false) String difficulty, Model model) {
        Long id;
        String email = routeService.useridName();
        id = userRepository.findByEmail(email).get().getId();
        List<RouteDto> routeList = routeService.getMyRoutesSearch(locality, typeWord, difficulty, 1l);
        model.addAttribute("routes", routeList);
        model.addAttribute("keyword", locality);
        model.addAttribute("typeWord", typeWord);
        model.addAttribute("difficulty", difficulty);
        return "routes/myroutes";
    }
    @GetMapping("/routes/test")
    public String test(){
        Long id;
        String email = routeService.useridName();
        id = userRepository.findByEmail(email).get().getId();
        return email;
    }

    @GetMapping("/routes/create")
    public String addRoute(Model model) {
        model.addAttribute("route", new RouteDto());
        return "routes/addroute";
    }

    @PostMapping("/routes")
    public String createRoute(@Valid @ModelAttribute RouteDto routeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/routes";
        }
        routeService.addRoute(routeDto);
        return "redirect:/public/routes/myroutes";
    }


    @GetMapping("/routes/{routeId}")
    public String getRouteById(@PathVariable("routeId") Long routeId, Model model) {
        RouteDto route = routeService.findRouteById(routeId);
        model.addAttribute("route", route);
        return "routes/modifyroute";
    }

    @PostMapping("/routes/edit")
    public String editRoute(@ModelAttribute RouteDto route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "routes/modifyroute";
        }
        routeService.updateRoute(route);
        return "redirect:/public/routes/myroutes";
    }

    @GetMapping("routes/delete-route/{id}")
    public String deleteRoute(@PathVariable long id) {
        routeService.deleteRouteById(id);
        return "redirect:/public/routes/myroutes";
    }

    @GetMapping("/routes/get-error")
    public String getRouteWithWrongIdAndThrowError() {
        routeService.findRouteById(-1L);
        return "routes/routes";
    }

    @GetMapping("/routes/search")
    public String showRoutes(@RequestParam(required = false) String locality, @RequestParam(required = false) String typeWord, @RequestParam(required = false) String difficulty, Model model) {
        List<RouteDto> routeList = routeService.getRoutesSearch(locality, typeWord, difficulty);
        model.addAttribute("routes", routeList);
        model.addAttribute("keyword", locality);
        model.addAttribute("typeWord", typeWord);
        model.addAttribute("difficulty", difficulty);
        return "routes/routes";
    }
    @GetMapping("/routes/details/{routeId}")
    public String getRouteByIdDetils(@PathVariable("routeId") Long routeId, Model model) {
        RouteDto route = routeService.findRouteById(routeId);
        model.addAttribute("route", route);
        return "routes/routesdetails";
    }@GetMapping("/routes/detailsmain/{routeId}")
    public String getRouteByIdDetilsMain(@PathVariable("routeId") Long routeId, Model model) {
        RouteDto route = routeService.findRouteById(routeId);
        model.addAttribute("route", route);
        return "routes/routesdetailsmain";
    }


}



