package src.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReaders {
    public static List<String> readingInformationsForTransform() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(new FileReader("src/inputCSV/listings.csv"))) {
            return readingInfo.lines().toList();
        }
    }

    public static List<String> readingInformationsForSortMediumCase() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(new FileReader("src/inputCSV/listings_mediumCase.csv"))) {
            return readingInfo.lines().toList();
        }
    }

    public static List<String> readingInformationsLastReviewForSortBestCase()
            throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/last_review/listings_lastReview_BestCase.csv"))) {
            return readingInfo.lines().toList();
        }
    }

    public static List<String> readingInformationsLastReviewForSortWorstCase()
            throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/last_review/listings_lastReview_WorstCase.csv"))) {
            return readingInfo.lines().toList();
        }
    }

    public static List<String> readingInformationsNameForSortBestCase() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/name/listings_name_bestCase.csv"))) {
            return readingInfo.lines().toList();
        }
    }

    public static List<String> readingInformationsNameForSortWorstCase() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/name/listings_name_worstCase.csv"))) {
            return readingInfo.lines().toList();
        }
    }

    public static List<String> readingInformationsReviewNumberForSortBestCase()
            throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/number_of_reviews/listings_numReviews_BestCase.csv"))) {
            return readingInfo.lines().toList();
        }
    }

    public static List<String> readingInformationsReviewNumberForSortWorstCase()
            throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/number_of_reviews/listings_numReviews_WorstCase.csv"))) {
            return readingInfo.lines().toList();
        }
    }

    public static List<String> readingInformationsPriceForSortBestCase() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/price/listings_price_BestCase.csv"))) {
            return readingInfo.lines().toList();
        }
    }

    public static List<String> readingInformationsPriceForSortWorstCase() throws FileNotFoundException, IOException {
        try (BufferedReader readingInfo = new BufferedReader(
                new FileReader("src/inputCSV/price/listings_price_WorstCase.csv"))) {
            return readingInfo.lines().toList();
        }
    }
}
