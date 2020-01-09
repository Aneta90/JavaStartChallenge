package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import Model.Names;

public class ReadFromFile {

    public static List<Names> readTextFromCsv() throws FileNotFoundException {

        String fileName = "/resources/Popular_Baby_Names.csv";
        File inputFile = new File((fileName));
        InputStream inputStream = new FileInputStream(inputFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        return bufferedReader.lines().skip(1).map(x -> {
            String[] split = x.split(",");
            Names names = new Names();
            names.setYear(Integer.valueOf(split[0]));
            names.setGender(split[1]);
            names.setEthnicity(split[2]);
            names.setFirstName(split[3]);
            names.setCount(Integer.valueOf(split[4]));
            names.setRank(Integer.valueOf(split[5]));

            return names;
        }).collect(Collectors.toList());
    }
}