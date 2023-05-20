package com.javaholics.web.service;

import com.javaholics.web.domain.*;
import com.javaholics.web.dto.UserDto;
import com.javaholics.web.mapper.UserMapper;
import com.javaholics.web.repository.UserRepository;
import com.javaholics.web.utilities.PassEncoderBinding;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    private PassEncoderBinding passEncoderBinding;

    public List<UserDto> getUsers() {
        log.info("Pokaż wszystkich Userów");
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
    public String useridName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            return username = ((UserDetails) principal).getUsername();
        } else {
            return username = principal.toString();
        }
    }
    public Long userId(){
        Long userId = userRepository.findByEmail(useridName()).get().getId();
        return userId;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {

        final Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
        }
    }

    public void addUser(UserDto userDto) {
        if (emailExists(userDto.getEmail())) {
            throw new IllegalArgumentException("Istnieja konto z tym adresem email: " + userDto.getEmail());
        }
        else {
            userRepository.save(userMapper.fromDto(userDto));
        }
    }
    @PostConstruct
    public void addAdminIfNotPresent(){

        if(userRepository.findFirstByRole(UserRoles.ADMIN).isEmpty()){
            userRepository.save(
                    User.builder()
                            .login("admin")
                            .sex(SexChoice.OTHER)
                            .loginProvider(UserProvider.LOCAL)
                            .name("Administrator")
                            .location("Polska")
                            .prefferedRegionEvents(Region.SLASKIE)
                            .lastName("Administrator")
                            .email("admin@admin.pl")
                            .password(passEncoderBinding.encoder().encode("admin1234"))
                            .role(UserRoles.ADMIN)
                            .build()
            );
        }


    }
    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public void deleteUserById(long id) {
        log.debug("Usuwanie usera: {}", id);
        userRepository.deleteById(id);
        log.info("User usunięty z sukcesem!");
    }
}
