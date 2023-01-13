package org.infoshareacademy.javaholics.user;

import org.infoshareacademy.javaholics.IdNumbers;
import org.infoshareacademy.javaholics.utils.FileUtils;
import org.infoshareacademy.javaholics.utils.IDsNumbers;

public class UserService implements IdNumbers {

    @Override
    public long getCurrentIpNoSaveToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIpsFromJsonFile();
        return iDsNumbers.getIpUser();
    }

    @Override
    public long getCurrentIpWithSaveNextIpToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIpsFromJsonFile();
        long idUser = iDsNumbers.getIpUser();
        iDsNumbers.setIpUser(idUser+1);
        fileUtils.saveIpsToJsonFile(iDsNumbers);
        return idUser;
    }

}
