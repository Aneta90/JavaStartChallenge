package Main;

import java.io.IOException;
import java.util.List;

import Input.ReadFromFile;
import Logic.Analyzer;
import Model.Names;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Names> namesList = ReadFromFile.readTextFromCsv();
        System.out.println("The most popular names are" + Analyzer.theMostPopularNames(namesList));
        System.out.println("The most popular female name is" + Analyzer.theMostPopularWomenName(namesList));
        System.out.println("The most popular first letters of names are" + Analyzer.namesStartedAtTheMostPopularLetters(namesList));

    }
}