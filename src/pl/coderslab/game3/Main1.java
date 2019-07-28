package pl.coderslab.game3;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        System.out.println("Pomyśl liczbę 0 do 1000, a ja ją zgadnę w max. 10 próbach");

        int min = 0;

        int max = 1000;

        int numbersOfTry = 0;

        while (true) {

            int newRandom = randomNumber(min, max);
            Scanner scan = new Scanner(System.in);

            String tekst = scan.nextLine();

            if (tekst.equals("zgadłeś")) {

                ++numbersOfTry;
                System.out.println("Wygrałem! Udało mi się odgadnąć w " + numbersOfTry + " próbach :-)");
                break;

            } else if (tekst.equals("za mało")) {

                ++numbersOfTry;
                min = newRandom + 1;

            } else if (tekst.equals("za dużo")) {

                ++numbersOfTry;
                max = newRandom - 1;

            } else {

                System.out.println("nie rozpoznałem słowa, więc losuję ponownie");

            }

        }
    }

    public static int randomNumber(int min, int max) {

        Random random = new Random();

        int newRandomNumber = random.nextInt(max + 1 - min) + min;

        System.out.println("Zgaduję: " + newRandomNumber + ". Czy trafiłem? (odpowiedz: \"za dużo\", \"za mało\", \"zgadłeś\")");

        return newRandomNumber;

    }

}
