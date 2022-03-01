package src.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReaders {
    public static String[] readingInformations() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(new FileReader("src/inputCSV/listings.csv"))) {
            return transformToString(readingInfo.lines().toArray());
        }
    }

    public static String[] readingInformationsLastReviewForSortBestCase()
            throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/last_review/listings_lastReview_BestCase.csv"))) {
            return transformToString(readingInfo.lines().toArray());

        }
    }

    public static String[] readingInformationsLastReviewForSortWorstCase()
            throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/last_review/listings_lastReview_WorstCase.csv"))) {
            return transformToString(readingInfo.lines().toArray());
        }
    }

    public static String[] readingInformationsNameForSortBestCase() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/name/listings_name_bestCase.csv"))) {
            return transformToString(readingInfo.lines().toArray());
        }
    }

    public static String[] readingInformationsNameForSortWorstCase() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/name/listings_name_worstCase.csv"))) {
            return transformToString(readingInfo.lines().toArray());
        }
    }

    public static String[] readingInformationsReviewNumberForSortBestCase()
            throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/number_of_reviews/listings_numReviews_BestCase.csv"))) {
            return transformToString(readingInfo.lines().toArray());
        }
    }

    public static String[] readingInformationsReviewNumberForSortWorstCase()
            throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/number_of_reviews/listings_numReviews_WorstCase.csv"))) {
            return transformToString(readingInfo.lines().toArray());
        }
    }

    public static String[] readingInformationsPriceForSortBestCase() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/price/listings_price_BestCase.csv"))) {
            return transformToString(readingInfo.lines().toArray());
        }
    }

    public static String[] readingInformationsPriceForSortWorstCase() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/price/listings_price_WorstCase.csv"))) {
            return transformToString(readingInfo.lines().toArray());
        }
    }

    public static String[] transformToString(Object[] objectList) {
        String[] newList = new String[objectList.length];

        for (int i = 0; i < newList.length; i++) {
            newList[i] = objectList[i].toString();
        }

        return newList;
    }
}
