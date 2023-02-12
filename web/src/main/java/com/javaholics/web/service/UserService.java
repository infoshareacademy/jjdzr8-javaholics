package com.javaholics.web.service;

import com.javaholics.web.repository.*;

public class UserService implements IdNumbers {

    @Override
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
    }

}
