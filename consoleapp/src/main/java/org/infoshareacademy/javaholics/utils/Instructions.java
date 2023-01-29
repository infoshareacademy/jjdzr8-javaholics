package org.infoshareacademy.javaholics.utils;

public class Instructions {

    private static String separator = "_____________________________________________";
    private static String logo = """
                                 _   ____            _   _              \s
             _ __ ___   ___  ___| |_|___ \\ __ _  ___| |_| |__   ___ _ __\s
            | '_ ` _ \\ / _ \\/ _ \\ __| __) / _` |/ _ \\ __| '_ \\ / _ \\ '__|
            | | | | | |  __/  __/ |_ / __/ (_| |  __/ |_| | | |  __/ |  \s
            |_| |_| |_|\\___|\\___|\\__|_____\\__, |\\___|\\__|_| |_|\\___|_|  \s
                                          |___/                         \s                                                              
            """;
    public static String getSeparator() {
        return separator;
    }
    public static String getLogo() { return logo; }
}
