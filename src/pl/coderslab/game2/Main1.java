package pl.coderslab.game2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        int[] enteredNumbers = enterNumbers();

        Integer[] randomNumbers = randomNumbers();

        yourScore(randomNumbers, enteredNumbers);

        System.out.println("Czy chciałbyś zobaczyć po ilu losowaniach trafiłbyś szóstkę? \nJeśli tak to wpisz T, jeśli nie to wciśnij enter lub wpisz cokolwiek innego :-)");

        Scanner scan = new Scanner(System.in);

        String decision = scan.nextLine();
        if (decision.equals("T")) {

            whenYouWillWin(enteredNumbers); // dodatkowa metoda sprawdzająca po jakim czasie trafiłby szóstkę :)

        }

    }

    public static void whenYouWillWin(int[] enteredNumbers) {

        Integer[] randomNumbers = {9};

        int howMuchGood = 0;
        int iterator = 0;

        while (howMuchGood < 6 && iterator < 1000000000) {

            howMuchGood = 0;
            randomNumbers = randomNumbers();

            for (int i = 0; i < enteredNumbers.length; i++) {

                for (int j = 0; j < randomNumbers.length; j++) {

                    if (enteredNumbers[i] == randomNumbers[j]) {

                        ++howMuchGood;

                    }

                }
            }

            ++iterator;
        }
        if (iterator < 1000000000) {

            System.out.println("Musiałbyś grać " + iterator + " razy;");

        } else {

            System.out.println("Niestety, ale podczas 1 000 000 000 losowań nie wygrałbyś ani razu :-(");

        }
    }

    public static void yourScore(Integer[] randomNumbers, int[] enteredNumbers) {

        int howMuchGood = 0;

        for (int i = 0; i < enteredNumbers.length; i++) {

            for (int j = 0; j < randomNumbers.length; j++) {

                if (enteredNumbers[i] == randomNumbers[j]) {

                    ++howMuchGood;

                }

            }

        }

        System.out.println("Wylosowane liczby: " + Arrays.toString(randomNumbers));

        System.out.println("Twoje liczby to: " + Arrays.toString(enteredNumbers));

        System.out.println("Liczba trafień: " + howMuchGood);

        if (howMuchGood >= 3) {

            System.out.println("Brawo, trafiłeś więcej niż 2 liczby");

        }

    }

    public static Integer[] randomNumbers() {

        Integer[] arr = new Integer[49];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = i + 1;

        }

        Collections.shuffle(Arrays.asList(arr));

        arr = Arrays.copyOf(arr, 6);

        Arrays.sort(arr);

        return arr;

    }

    public static int[] enterNumbers() {

        int enteredNumbers = 0;

        int[] arraysOfEnteredNumbers = new int[6];

        while (enteredNumbers < 6) {

            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Podaj liczbę, którą obstawiasz z przedziału od 1 do 49");

                int enteredNumber = scan.nextInt();

                if (enteredNumber < 1 || enteredNumber > 49) {

                    System.out.println("Podałeś liczbę spoza zakresu od 1 do 49");

                } else {

                    //sprawdzam czy takiej liczby nie ma juz przypadkiem w tablicy

                    int isNumber = 0;

                    for (int i = 0; i < enteredNumbers; i++) {

                        if (arraysOfEnteredNumbers[i] == enteredNumber) {

                            isNumber = 1;

                        }

                    }

                    if (isNumber == 0) {

                        arraysOfEnteredNumbers[enteredNumbers] = enteredNumber;
                        ++enteredNumbers;

                    } else {

                        System.out.println("Taka liczba już jest wśród tych, które podałeś, musisz podać inną.");

                    }

                }
            } catch (Exception e) {

                System.out.println("Podałeś coś, co nie jest liczbą. Podaj liczbę.");

            }

        }

        Arrays.sort(arraysOfEnteredNumbers);

        return arraysOfEnteredNumbers;
    }

}
