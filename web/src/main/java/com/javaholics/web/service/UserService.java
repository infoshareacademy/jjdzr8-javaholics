package com.javaholics.web.service;

import com.javaholics.web.dto.UserDto;
import com.javaholics.web.mapper.UserMapper;
import com.javaholics.web.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public void addUser(UserDto userDto) {
        userRepository.save(userMapper.fromDto(userDto));
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
