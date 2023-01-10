package org.infoshareacademy.javaholics.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMechanics {
    Scanner scanner;
    int shortInputLength = 50;
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
}
