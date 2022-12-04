package org.infoshareacademy.javaholics;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello Javaholics");

        Menu menu = new Menu();

        System.out.println("1. Dodaj nową trasę");
        System.out.println("2. Wyszukaj trasę");
        System.out.println("3. Edytuj trasę");
        System.out.println("4. Usuń trasę");
        System.out.println("5. Dodaj Event");
        System.out.println("6. Wyszukaj Event");

        menu.printMenu();
    }
}
