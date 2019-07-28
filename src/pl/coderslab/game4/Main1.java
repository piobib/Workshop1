package pl.coderslab.game4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Wprowadź parametry rzutu w formacie xDy+z\n(dopuszczalne typy kostek: D3, D4, D6, D8, D10, D12, D20, D100)");

        String type = scan.nextLine();

        //wywołuję metodę, która sprawdzi, czy taka kostka istnieje

        int[] throwDetails = decoder(type);

        if (throwDetails[3] == 1) {

            throwOfCube(throwDetails);

        } else {

            System.out.println("Niestety, ale nie jestem w stanie wykonać rzutu kostką o błędnym formacie!");

        }

    }

    public static void throwOfCube(int[] throwDetails) {

        int sum = 0;


        Random getRandom = new Random();

        for (int i = 0; i < throwDetails[0]; i++) {

            int newRandomNumber = getRandom.nextInt(throwDetails[1]) + 1;
            sum += newRandomNumber;

        }

        sum += throwDetails[2];

        System.out.println("Wynik rzutu to: " + sum);
    }

    public static int[] decoder(String type) {

        String[] possibleCubesTypes = {"D3", "D4", "D6", "D8", "D10", "D12", "D20", "D100"};

        int[] decoderArray = new int[4];
        decoderArray[3] = 1;

        String[] tempArray = type.split("D");

        //określam liczbę rzutów
        if (type.indexOf("D") > 0) {
            try {
                decoderArray[0] = Integer.parseInt(tempArray[0]);

            } catch (Exception e) {
                decoderArray[0] = 1;
            }
            //System.out.println(String[0]);

            //określam typ kostki
            if (tempArray[1].indexOf("+") > 0) {

                tempArray = tempArray[1].split("\\+");
                decoderArray[1] = Integer.parseInt(tempArray[0]);
                decoderArray[2] = Integer.parseInt(tempArray[1]);

            } else if (tempArray[1].indexOf("-") > 0) {

                tempArray = tempArray[1].split("\\-");
                decoderArray[1] = Integer.parseInt(tempArray[0]);
                decoderArray[2] = Integer.parseInt(tempArray[1]) * -1;

            } else {

                decoderArray[1] = Integer.parseInt(tempArray[1]);

            }
            int issetType = 0;
            for (int i = 0; i < possibleCubesTypes.length; i++) {
                if (possibleCubesTypes[i].equals("D" + decoderArray[1])) {

                    issetType = 1;

                }
            }
            if (issetType == 0) {

                System.out.println("Kostka o typie D" + decoderArray[1] + " nie istnieje!");
                decoderArray[3] = 0;
            }

        } else {

            System.out.println("Wprowadzono nieprawidłowy format danych!");
            decoderArray[3] = 0;

        }
        return decoderArray;
    }

}
