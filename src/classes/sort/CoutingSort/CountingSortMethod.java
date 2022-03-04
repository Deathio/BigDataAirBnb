package src.classes.sort.CoutingSort;

import java.util.Comparator;

import src.classes.ApartmentAirBnb;

public class CountingSortMethod {
    public static ApartmentAirBnb[] sortNumReviews(ApartmentAirBnb[] entrada) {
        ApartmentAirBnb maxValue = getMaxvalue(entrada, CountingSortTools.compareNumReviews);
        int size2 = 10000;

        ApartmentAirBnb[][] newList = new ApartmentAirBnb[maxValue.number_of_reviews + 1][size2 + 1];
        int[] indexs = new int[maxValue.number_of_reviews + 1];

        for (ApartmentAirBnb valores : entrada) {
            newList[valores.number_of_reviews][indexs[valores.number_of_reviews]] = valores;
            indexs[valores.number_of_reviews]++;
        }

        ApartmentAirBnb[] returnList = new ApartmentAirBnb[entrada.length];

        int toGetIndex = 0, toPutInList = 0;
        for (ApartmentAirBnb[] listaApartamentos : newList) {
            int indexFind = 0;
            for (ApartmentAirBnb apartmentAirBnb : listaApartamentos) {
                if (indexFind >= indexs[toGetIndex])
                    break;
                returnList[toPutInList] = apartmentAirBnb;
                toPutInList++;
                indexFind++;
            }
            toGetIndex++;
        }

        return returnList;
    }

    public static ApartmentAirBnb[] sortPrice(ApartmentAirBnb[] entrada) {
        ApartmentAirBnb maxValue = getMaxvalue(entrada, CountingSortTools.comparePrice);
        int size2 = 10000;

        ApartmentAirBnb[][] newList = new ApartmentAirBnb[maxValue.price + 1][size2 + 1];
        int[] indexs = new int[maxValue.price + 1];

        for (ApartmentAirBnb valores : entrada) {
            newList[valores.price][indexs[valores.price]] = valores;
            indexs[valores.price]++;
        }

        ApartmentAirBnb[] returnList = new ApartmentAirBnb[entrada.length];

        int toGetIndex = 0, toPutInList = 0;
        for (ApartmentAirBnb[] listaApartamentos : newList) {
            int indexFind = 0;
            for (ApartmentAirBnb apartmentAirBnb : listaApartamentos) {
                if (indexFind >= indexs[toGetIndex])
                    break;
                returnList[toPutInList] = apartmentAirBnb;
                toPutInList++;
                indexFind++;
            }
            toGetIndex++;
        }

        return returnList;
    }

    public static ApartmentAirBnb getMaxvalue(ApartmentAirBnb[] entrada, Comparator<ApartmentAirBnb> compare) {
        ApartmentAirBnb returnApartment = entrada[0];

        for (int index = 1; index < entrada.length; index++) {
            if (compare.compare(returnApartment, entrada[index]) < 1) {
                returnApartment = entrada[index];
            }
        }

        return returnApartment;
    }

    public static ApartmentAirBnb getMinvalue(ApartmentAirBnb[] entrada, Comparator<ApartmentAirBnb> compare) {
        ApartmentAirBnb returnApartment = entrada[0];

        for (int index = 1; index < entrada.length; index++) {
            if (compare.compare(returnApartment, entrada[index]) == 1) {
                returnApartment = entrada[index];
            }
        }

        return returnApartment;
    }
}
