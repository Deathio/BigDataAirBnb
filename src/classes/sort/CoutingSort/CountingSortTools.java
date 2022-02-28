package src.classes.sort.CoutingSort;

import java.util.Comparator;

import src.classes.ApartmentAirBnb;

public class CountingSortTools {
    public static Comparator<ApartmentAirBnb> comparePrice = (entry1, entry2) -> {
        if(entry1.price > entry2.price) return 1;
        else if(entry1.price < entry2.price) return -1;
        return 0;
    };

    public static Comparator<ApartmentAirBnb> compareNames = (entry1, entry2) -> {
        return entry1.CompareNames(entry2);
    };

    public static Comparator<ApartmentAirBnb> compareNumReviews = (entry1, entry2) -> {
        if(entry1.number_of_reviews > entry2.number_of_reviews) return 1;
        else if(entry1.number_of_reviews < entry2.number_of_reviews) return -1;
        return 0;
    };

    public static Comparator<ApartmentAirBnb> compareNumbers = (entry1, entry2) -> {
        return entry1.compareDates(entry2);
    };
}
