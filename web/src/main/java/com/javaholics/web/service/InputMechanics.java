package com.javaholics.web.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMechanics {
    Scanner scanner;
    int shortInputLength = 50;
    int longInputLength = 500;

    // pobiera z klawiatury String do X znaków (krótki tekst)
    public String getInputShort(){

        String input = null;

        Scanner reader = new Scanner(System.in);
        boolean flagAnswer;

        do{
            flagAnswer = false;

            try{
                input = reader.next();

                if (input.length()>shortInputLength){
                    throw new InputMismatchException("   Wprowadź tekst do " + shortInputLength + " znaków.");
                }

            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
                flagAnswer = true;
            }
        }
        while (flagAnswer);

        return input;
    }

    // pobiera z klawiatury String do X znaków (dlugi tekst) - np do opisów
    public String getInputLong(){

        String input = null;

        Scanner reader = new Scanner(System.in);
        boolean flagAnswer;

        do{
            flagAnswer = false;

            try{
                input = reader.next();

                if (input.length()>longInputLength){
                    throw new InputMismatchException("   Wprowadź tekst do " + longInputLength + " znaków.");
                }

            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
                flagAnswer = true;
            }
        }
        while (flagAnswer);

        return input;
    }

    // pobiera z klawiatury liczbę double wiekszą od zera
    public Double getInputNumber(){

        Double input = null;
        Scanner reader = new Scanner(System.in);
        boolean flagAnswer;

        do{
            flagAnswer = false;
            try {
                input = reader.nextDouble();

                while (input < 0 || input == 0) {
                    System.out.println("Podaj poprawną wartość");
                    input = reader.nextDouble();
                }
                // do poprawy wyjatek dla podania stringa zamiast liczby i ewentualne rzutowanie na double integera
            } catch (InputMismatchException e){
                System.out.println("Podaj poprawną wartość");
                flagAnswer = true;
                reader.nextLine();
            }
        }
        while (flagAnswer);
        return input;
    }
    // pobiera z klawiatury liczbę do pol wyboru kontekstowego 1, 2, 3...-  od 1 do zadanego zakresu (range)
    public int getInputSwitch(int range){

        int input = 0;
        Scanner reader = new Scanner(System.in);
        boolean flagAnswer;

        do{
            flagAnswer = false;
            try {
                input = reader.nextInt();

                while (input <= 0 || input > range) {
                    System.out.println("Podaj poprawną wartość z zakresu 0-" + range);
                    input = reader.nextInt();
                }
            } catch (InputMismatchException e){
                System.out.println("Podaj poprawną wartość z zakresu 0-" + range);
                flagAnswer = true;
                reader.nextLine();
            }
        }
        while (flagAnswer);
        return input;
    }
}
