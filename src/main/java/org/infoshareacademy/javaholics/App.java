package org.infoshareacademy.javaholics;


import org.infoshareacademy.javaholics.utils.FileUtils;
import org.infoshareacademy.javaholics.utils.IpsNumbers;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        IpsNumbers ipsNumbers = FileUtils.readUsersJsonFile();
        ipsNumbers.setIpUser(2);
        ipsNumbers.setIpRoute(2);
        ipsNumbers.setIpEvent(3);
        FileUtils.saveUsersToJsonFile(ipsNumbers);
    }
}
