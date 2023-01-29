package org.infoshareacademy.javaholics.utils;

public class IpsNumbers {

    private long ipUser=0;
    private long ipRoute=0;
    private long ipEvent=0;


    public long getIpUser() {
        return ipUser;
    }

    public void setIpUser(long ipUser) {
        this.ipUser = ipUser;
    }

    public long getIpRoute() {
        return ipRoute;
    }

    public void setIpRoute(long ipRoute) {
        this.ipRoute = ipRoute;
    }

    public long getIpEvent() {
        return ipEvent;
    }

    public void setIpEvent(long ipEvent) {
        this.ipEvent = ipEvent;
    }

    @Override
    public String toString() {
        return "IpsNumbers{" +
                "ipUser=" + ipUser +
                ", ipRoute=" + ipRoute +
                ", ipEvent=" + ipEvent +
                '}';
    }
}
