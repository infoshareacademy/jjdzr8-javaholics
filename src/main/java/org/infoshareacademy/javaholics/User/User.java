package org.infoshareacademy.javaholics.User;

import java.awt.image.BufferedImage;

public class User {

    private Long userId;
    private String userName;
    private String userLastName;
    private String userNickname;
    // tu odniesienie do enum SexChoice
    private SexChoice userSex;
    private BufferedImage image;
    private String userCity;
    private String userPrefRegion;
    private String userDescr;

    // getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public SexChoice getUserSex() {
        return userSex;
    }

    public void setUserSex(SexChoice userSex) {
        this.userSex = userSex;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPrefRegion() {
        return userPrefRegion;
    }

    public void setUserPrefRegion(String userPrefRegion) {
        this.userPrefRegion = userPrefRegion;
    }

    public String getUserDescr() {
        return userDescr;
    }

    public void setUserDescr(String userDescr) {
        this.userDescr = userDescr;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
