import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.UnaryOperator;

import src.classes.ApartmentAirBnb;
import src.classes.CsvReaders;
import src.classes.FormatDocument;
import src.classes.sort.CoutingSort.CountingSortMethod;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        boolean isHeadline = true;

        // ------------------------------------------------ Transform part
        // ------------------------------------------------------- //
        FileWriter formatingDate = new FileWriter("src/outPutCSV/transform/listings_review_date.csv");
        FileWriter filteringAboveAverage = new FileWriter("src/outPutCSV/transform/listings_gt_avg_prices.csv");
        FileWriter filteringBellowAverage = new FileWriter("src/outPutCSV/transform/listings_lt_avg_prices.csv");

        String[] reformatingStrings = FormatDocument.reformatingInfo(CsvReaders.readingInformations());
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

        // ------------------------------------------------ Selection sort
        // ------------------------------------------------------- //
        // ------------------------------------------------ Insertion sort
        // ------------------------------------------------------- //
        // -------------------------------------------------- Merge sort
        // --------------------------------------------------------- //
        // -------------------------------------------------- Quick sort
        // --------------------------------------------------------- //
        FileWriter[] sortingWriters = new FileWriter[3];
        sortingWriters[0] = new FileWriter(
                "src/outPutCSV/sort/CoutingSort/lastReview/listings_lastReview_CoutingSort_medioCaso.csv");
        sortingWriters[1] = new FileWriter(
                "src/outPutCSV/sort/CoutingSort/lastReview/listings_lastReview_CoutingSort_melhorCaso.csv");
        sortingWriters[2] = new FileWriter(
                "src/outPutCSV/sort/CoutingSort/lastReview/listings_lastReview_CoutingSort_piorCaso.csv");

        UnaryOperator<ApartmentAirBnb[]> sortLastReview = entrada -> {
            return CountingSortMethod.sortNumReviews(entrada);
        };

        String[][] sortingInputs = new String[3][22553];
        sortingInputs[0] = CsvReaders.readingInformations();
        sortingInputs[1] = CsvReaders.readingInformationsLastReviewForSortBestCase();
        sortingInputs[2] = CsvReaders.readingInformationsLastReviewForSortWorstCase();

        writeCSVForSort(sortingWriters, sortingInputs, sortLastReview);

        // // // ----------------------------------------- QuickSort with a Median of 3
        // ------------------------------------------------ //
        // // // ------------------------------------------------ counting sort
        // ------------------------------------------------------- //

        // // // -------------------------------------------------- heap sort
        // --------------------------------------------------------- //
    }

    public static void writeCSVForSort(FileWriter[] writers, String[][] readers,
            UnaryOperator<ApartmentAirBnb[]> sort) throws IOException {
        for (int index = 0; index < 3; index++) {
            boolean isHeadline = true;

            ApartmentAirBnb[] valor = new ApartmentAirBnb[22552];

            String[] reformatingcase = FormatDocument
                    .reformatingInfo(readers[index]);
            int indexForValor = 0;
            for (String string : reformatingcase) {
                if (isHeadline) {
                    writers[index].append(string + "\n");
                    isHeadline = !isHeadline;
                    continue;
                }

                String[] getter = FormatDocument.formatingString(string);
                valor[indexForValor] = new ApartmentAirBnb(getter);
                indexForValor++;
            }

            valor = sort.apply(valor);

            for (ApartmentAirBnb apartmentAirBnb : valor) {
                writers[index].append(apartmentAirBnb.toString());
            }
        }
    }
}