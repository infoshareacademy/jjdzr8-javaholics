package org.infoshareacademy.javaholics.user;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void add(User user) {
        users.add(user);
        System.out.println("Nowy użytkownik dodany: " + user.toString());
    }

}
