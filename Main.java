import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import src.classes.ApartmentAirBnb;
import src.classes.CsvReaders;
import src.classes.FormatDocument;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        boolean isHeadline = true;

        // ------------------------------------------------ Transform part ------------------------------------------------------- //
        FileWriter formatingDate = new FileWriter("src/outPutCSV/transform/listings_review_date.csv");
        FileWriter filteringAboveAverage = new FileWriter("src/outPutCSV/transform/listings_gt_avg_prices.csv");
        FileWriter filteringBellowAverage = new FileWriter("src/outPutCSV/transform/listings_lt_avg_prices.csv");

        String[] reformatingStrings = FormatDocument.reformatingInfo(CsvReaders.readingInformationsForTransform());
        double averageNeighbourhood = FormatDocument.calculingTheAverage(reformatingStrings);

        for (String string : reformatingStrings) {

            if (isHeadline) {
                formatingDate.append(string + "\n");
                filteringAboveAverage.append(string + "\n");
                filteringBellowAverage.append(string + "\n");
                isHeadline = !isHeadline;
                continue;
            }
            String[] getter = FormatDocument.formatingString(string);
            ApartmentAirBnb instantiatedInfo = new ApartmentAirBnb(getter);

            formatingDate.append(instantiatedInfo.toString());

            if (instantiatedInfo.getReviews_per_month() >= averageNeighbourhood) {
                filteringAboveAverage.append(instantiatedInfo.toString());
            }
            if (instantiatedInfo.getReviews_per_month() <= averageNeighbourhood) {
                filteringBellowAverage.append(instantiatedInfo.toString());
            }
        }

        isHeadline = !isHeadline;

        formatingDate.close();
        filteringAboveAverage.close();
        filteringBellowAverage.close();
        

        // ------------------------------------------------ Selection sort ------------------------------------------------------- //
        // ------------------------------------------------ Insertion sort ------------------------------------------------------- //
        // -------------------------------------------------- Merge sort --------------------------------------------------------- //
        // -------------------------------------------------- Quick sort --------------------------------------------------------- //
        // FileWriter Write = new FileWriter("src/outPutCSV/transform/listings_gt_avg_prices.csv");
        // FileWriter filteringBellowAverage = new FileWriter("src/outPutCSV/transform/listings_lt_avg_prices.csv");

        // String[] reformatingStrings = FormatDocument.reformatingInfo(CsvReaders.readingInformationsForSortMediumCase());
        // double averageNeighbourhood = FormatDocument.calculingTheAverage(reformatingStrings);

        // for (String string : reformatingStrings) {

        //     if (isHeadline) {
        //         formatingDate.append(string + "\n");
        //         filteringAboveAverage.append(string + "\n");
        //         filteringBellowAverage.append(string + "\n");
        //         isHeadline = !isHeadline;
        //         continue;
        //     }
        //     String[] getter = FormatDocument.formatingString(string);
        //     ApartmentAirBnb instantiatedInfo = new ApartmentAirBnb(getter);

        //     formatingDate.append(instantiatedInfo.toString());

        //     if (instantiatedInfo.getReviews_per_month() >= averageNeighbourhood) {
        //         filteringAboveAverage.append(instantiatedInfo.toString());
        //     }
        //     if (instantiatedInfo.getReviews_per_month() <= averageNeighbourhood) {
        //         filteringBellowAverage.append(instantiatedInfo.toString());
        //     }
        // }


        // ----------------------------------------- QuickSort with a Median of 3 ------------------------------------------------ //
        // ------------------------------------------------ counting sort ------------------------------------------------------- //
        



        // -------------------------------------------------- heap sort --------------------------------------------------------- //
    }
}