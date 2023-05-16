package com.javaholics.web.service;

import com.javaholics.web.domain.User;
import com.javaholics.web.domain.UserRoles;
import com.javaholics.web.dto.UserDto;
import com.javaholics.web.mapper.UserMapper;
import com.javaholics.web.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public void addUser(UserDto userDto) {
        userRepository.save(userMapper.fromDto(userDto));
    }

    public void addAdminIfNotPresent(){

        if(userRepository.findFirstByRole(UserRoles.ADMIN).isEmpty()){
            userRepository.save(
                    User.builder()
                            .login("admin")
                            .email("admin@admin.pl")
                            .password("admin1234")
                            .role(UserRoles.ADMIN)
                            .build();
        }

        )
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.;
    }



/*    @Override
    public long getCurrentIdNoSaveToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIdsFromJsonFile();
        return iDsNumbers.getIpUser();
    }

    @Override
    public long getCurrentIdWithSaveNextIdToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIdsFromJsonFile();
        long idUser = iDsNumbers.getIpUser();
        iDsNumbers.setIpUser(idUser+1);
        fileUtils.saveIdsToJsonFile(iDsNumbers);
        return idUser;
    }*/

}
