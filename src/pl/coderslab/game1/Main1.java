package pl.coderslab.game1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        int randNumber = randomNumber();

        quessNumber(randNumber);

    }

    public static void quessNumber(int randNumber) {

        int quessNumber = 0;
        int numberOfTry = 0;
        while (quessNumber != randNumber) {

            try {
                Scanner scan = new Scanner(System.in);

                System.out.println("Podaj dowolną liczbę o 1 do 100, a powiem Ci czy zgadłeś:");

                int userQuess = scan.nextInt();

                if (userQuess > 100 || userQuess < 1) {

                    System.out.println("Podałeś liczbę spoza przedziału");

                } else if (userQuess == randNumber) {

                    ++numberOfTry;
                    System.out.println("Zgadłeś!\nLiczba prób: " + numberOfTry);
                    break;

                } else if (userQuess > randNumber) {

                    ++numberOfTry;
                    System.out.println("Za dużo!");

                } else {

                    ++numberOfTry;
                    System.out.println("Za mało!");
                }

            } catch (Exception e) {

                System.out.println("To nie jest liczba. Musisz podać liczbę i tylko liczbę!");

            }


        }

    }

    //metoda losująca liczbę

    public static int randomNumber() {

        Random random = new Random();

        int newRandomNumber = random.nextInt(100) + 1;

        return newRandomNumber;

    }

}
