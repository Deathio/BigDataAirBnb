package src.classes;

import java.util.List;

public class FormatDocument {
    public static double calculingTheAverage(String[] entryValue) {
        double averageReturn = 0;
        int qutd = 0;
        boolean firstIgnore = true;

        for (String string : entryValue) {
            if (firstIgnore) {
                firstIgnore = !firstIgnore;
                continue;
            }
            String[] getter = formatingString(string);

            if (!getter[13].equals("")) {
                averageReturn += Double.parseDouble(getter[13]);
                qutd++;
            }
        }

        return averageReturn / qutd;
    }

    public static String[] formatingString(String entry) {
        String[] returnValue = new String[16];
        String forFormat = entry;
        int puttingIndex = 0, commaPos = -1, initialIndex = -1;

        while ((commaPos = forFormat.indexOf(",", commaPos + 1)) != -1) {
            if (forFormat.charAt(commaPos + 1) == '"') {
                returnValue[puttingIndex] = forFormat.substring(initialIndex + 1, commaPos);
                puttingIndex++;

                int InitbracketPos = commaPos + 1, finalBracketPos = 0, bracketPos = 0;
                while ((bracketPos = forFormat.indexOf("\"", bracketPos + 1)) != -1) {
                    finalBracketPos = bracketPos;
                }

                returnValue[puttingIndex] = forFormat.substring(InitbracketPos, finalBracketPos + 1);
                initialIndex = forFormat.indexOf(",", finalBracketPos);
                commaPos = initialIndex;
                puttingIndex++;
            } else {
                returnValue[puttingIndex] = forFormat.substring(initialIndex + 1, commaPos);
                initialIndex = commaPos;
                puttingIndex++;
            }
        }

        returnValue[puttingIndex] = forFormat.substring(initialIndex + 1, forFormat.length());

        return returnValue;
    }

    public static String[] reformatingInfo(List<String> entryInfo) {
        String[] returningString = new String[22553];
        String actualString = "";
        boolean isOkay;
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

        if (entryString.equals("\n")) {
            return false;
        } else {
            while ((commaPos = entryString.indexOf(",", commaPos + 1)) != -1) {

                numCommas++;
            }

            return numCommas >= 15;
        }
    }
}
