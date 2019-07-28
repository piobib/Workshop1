package pl.coderslab.game5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1 {


    public static void main(String[] args) {

        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {

            Document document = connect.get();

            Elements links = document.select("span.title");

            writeToFile("popular_words.txt", links);

            deleteExceptionWords("popular_words.txt", "filtered_popular_words.txt");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public static void writeToFile(String newFileName, Elements sourceElements) {

        String token = "";

        try {

            FileWriter writeToFile = new FileWriter(newFileName);

            for (Element elem : sourceElements) {

                StringTokenizer tokens = new StringTokenizer(elem.text(), " !@#$%^&*(),./:;'?<>|{}[]-=_+\"");

                while (tokens.hasMoreTokens()) {

                    token = tokens.nextToken().toLowerCase();

                    if (token.length() >= 3) {

                        writeToFile.append(token + "\n");

                    }

                }


            }

            writeToFile.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void deleteExceptionWords(String sourceFileName, String newFileName) {

        String[] wordsOutOfException = {"oraz", "ponieważ", "lub", "także", "już"};

        File readFile = new File(sourceFileName);

        try {
            FileWriter writeToFile = new FileWriter(newFileName);

            Scanner scan = new Scanner(readFile);

            String word = "";

            while (scan.hasNextLine()) {

                word = scan.nextLine();
                int isWord = 0;

                for (int i = 0; i < wordsOutOfException.length; i++) {

                    if (word.equals(wordsOutOfException[i])) {
                        isWord = 1;
                        break;

                    }

                }

                if (isWord == 0) {

                    writeToFile.append(word + "\n");

                }


            }

            writeToFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
