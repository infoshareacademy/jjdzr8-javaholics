package org.infoshareacademy.javaholics.user;

import java.util.ArrayList;
import java.util.List;

public class Users {

        private static List<User> userArrayList = new ArrayList<>();

        public List<User> getUsers() {
            return userArrayList;
        }

        public static List<User> getUserArrayList() {
            return userArrayList;
        }

        public void setUserArrayList(List<User> userArrayList) {
            this.userArrayList = userArrayList;
        }

        public static void add(User user) {
            userArrayList.add(user);
            System.out.println("Nowy użytkownik dodany: " + user.toString());
        }

}
