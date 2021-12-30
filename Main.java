import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

import src.classes.ApartmentAirBnb;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader testing = new BufferedReader(new FileReader("src/inputCSV/listings.csv"));
        FileWriter testing2 = new FileWriter("src/outPutCSV/listings_review_date.csv");
        Stream<String> ok = testing.lines();
        boolean passingValue = true;

        for (Object string : ok.toArray()) {
            if (passingValue) {
                testing2.append(string.toString() + "\n");
                passingValue = !passingValue;
                continue;
            }
            String[] getter = formatingString(string.toString());
            ApartmentAirBnb testingFor = new ApartmentAirBnb(getter[0], getter[1], getter[2], getter[3],
                    getter[4], getter[5], getter[6], getter[7], getter[8], getter[9], getter[10], 
                    getter[11], getter[12], getter[13], getter[14], getter[15]);

            testing2.append(testingFor.toString());
        }

        testing.close();
        testing2.close();
    }
    public static String[] formatingString(String entry) {
        // " => Não permitidas
        // ,\s => Não considerado critério de separação
        String[] returnValue = new String[16];
        String forFormat = entry.replace("\"", "");
        int puttingIndex = 0, commaPos = -1, initialIndex = -1;

        while ((commaPos = forFormat.indexOf(",", commaPos + 1)) != -1) {
            if(forFormat.charAt(commaPos + 1) == '\s' || forFormat.charAt(commaPos + 1) == ',') {
                continue;
            }

            returnValue[puttingIndex] = forFormat.substring(initialIndex + 1, commaPos);
            initialIndex = commaPos;
            puttingIndex++;
        }

        returnValue[puttingIndex] = forFormat.substring(initialIndex + 1, forFormat.length() - 1);
        
        return returnValue;
    }
}