package src.classes.sort.CoutingSort;

import java.util.ArrayList;
import java.util.List;

import src.classes.ApartmentAirBnb;

public class CountingSortMethod {
    public static List<ApartmentAirBnb> sortNumbers(List<ApartmentAirBnb> entrada) {
        ApartmentAirBnb maxValue = entrada.stream().max(CountingSortTools.compareNumReviews).get();

        List<List<ApartmentAirBnb>> newList = new ArrayList<>();

        for (int indexEntrada = 0; indexEntrada <= maxValue.number_of_reviews; indexEntrada++)
            newList.add(new ArrayList<>());

        for (ApartmentAirBnb valores : entrada) {
            newList.get(valores.number_of_reviews).add(valores);
        }

        List<ApartmentAirBnb> returnList = new ArrayList<>();

        for (List<ApartmentAirBnb> listaApartamentos : newList) {
            for (ApartmentAirBnb apartmentAirBnb : listaApartamentos) {
                returnList.add(apartmentAirBnb);
            }
        }

        return returnList;
    }
}
