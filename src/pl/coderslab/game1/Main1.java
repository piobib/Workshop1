package pl.coderslab.game1;

import java.util.Random;

public class Main1 {

    public static void main(String[] args) {

        System.out.println(randomNumber());

    }

    public static int randomNumber(){

        Random random = new Random();

        int newRandomNumber = random.nextInt(2);

        return newRandomNumber;

    }

}
