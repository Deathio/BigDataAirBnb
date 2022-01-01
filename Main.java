import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

import src.classes.ApartmentAirBnb;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader readingInfo = new BufferedReader(new FileReader("src/inputCSV/listings.csv"));
        FileWriter formatingDate = new FileWriter("src/outPutCSV/listings_review_date.csv");
        FileWriter filteringAboveAverage = new FileWriter("src/outPutCSV/listings_gt_avg_prices.csv");
        FileWriter filteringBellowAverage = new FileWriter("src/outPutCSV/listings_lt_avg_prices.csv");
        Stream<String> readInfo = readingInfo.lines();
        String[] reformatingStrings = reformatingInfo(readInfo);
        double averageNeighbourhood = calculingTheAverage(reformatingStrings);

        boolean passingValue = true;
        int okayInfos = 0, ErrorInfos = 0;

        for (String string : reformatingStrings) {
            try {
                if (passingValue) {
                    formatingDate.append(string + "\n");
                    filteringAboveAverage.append(string + "\n");
                    filteringBellowAverage.append(string + "\n");
                    passingValue = !passingValue;
                    continue;
                }
                String[] getter = formatingString(string);
                ApartmentAirBnb instantiatedInfo = new ApartmentAirBnb(getter[0], getter[1], getter[2], getter[3],
                        getter[4], getter[5], getter[6], getter[7], getter[8], getter[9], getter[10],
                        getter[11], getter[12], getter[13], getter[14], getter[15]);

                formatingDate.append(instantiatedInfo.toString());

                if(instantiatedInfo.getReviews_per_month() >= averageNeighbourhood) {
                    filteringAboveAverage.append(instantiatedInfo.toString());
                }
                if(instantiatedInfo.getReviews_per_month() <= averageNeighbourhood) {
                    filteringBellowAverage.append(instantiatedInfo.toString());
                }
                
                okayInfos++;
            } catch (Exception e) {
                ErrorInfos++;
            }
        }
        System.out.println(averageNeighbourhood);
        System.out.printf("Número de colunas passadas: %d\nNúmero de erros: %d", okayInfos, ErrorInfos);

        readingInfo.close();
        formatingDate.close();
        filteringAboveAverage.close();
        filteringBellowAverage.close();
    }
    
    public static double calculingTheAverage(String[] entryValue) {
        double averageReturn = 0;
        boolean firstIgnore = true;

        for (String string : entryValue) {
            if(firstIgnore) {
                firstIgnore = !firstIgnore;
                continue;
            }
            String[] getter = formatingString(string.toString());
            
            if(getter[13] != "") {
                averageReturn += Double.parseDouble(getter[13]);
            }
        }
        
        return averageReturn/22552;
    }

    public static String[] formatingString(String entry) {
        String[] returnValue = new String[16];
        String forFormat = entry;
        int puttingIndex = 0, commaPos = -1, initialIndex = -1;

        while ((commaPos = forFormat.indexOf(",", commaPos + 1)) != -1) {
            if (forFormat.charAt(commaPos + 1) == '"') {
                returnValue[puttingIndex] = forFormat.substring(initialIndex + 1, commaPos);
                initialIndex = commaPos;
                puttingIndex++;

                int InitbracketPos = commaPos + 1, finalBracketPos = 0, bracketPos = 0;
                while ((bracketPos = forFormat.indexOf("\"", bracketPos + 1)) != -1) {
                    finalBracketPos = bracketPos;
                }

                returnValue[puttingIndex] = forFormat.substring(InitbracketPos, finalBracketPos+1);
                initialIndex = forFormat.indexOf(",", finalBracketPos);
                commaPos = initialIndex;
                puttingIndex++;
            } else {
                returnValue[puttingIndex] = forFormat.substring(initialIndex + 1, commaPos);
                initialIndex = commaPos;
                puttingIndex++;
            }
        }

        returnValue[puttingIndex] = forFormat.substring(initialIndex + 1, forFormat.length() - 1);

        return returnValue;
    }

    public static String[] reformatingInfo(Stream<String> entryInfo) {
        String[] returningString = new String[22553];
        String actualString = "";
        boolean isOkay = true;
        int puttingIndex = 0;
        for (Object string : entryInfo.toArray()) {

            actualString += string.toString();

            isOkay = vallidatingString(actualString);

            if (isOkay) {
                returningString[puttingIndex] = actualString;
                puttingIndex++;
                actualString = "";
            }

        }

        return returningString;
    }

    public static boolean vallidatingString(String entryString) {
        int commaPos = -1, numCommas = 0;
        if (entryString == "\n") {
            return false;
        }

        while ((commaPos = entryString.indexOf(",", commaPos + 1)) != -1) {

            numCommas++;
        }

        if (numCommas >= 15) {
            return true;
        } else {
            return false;
        }
    }
}