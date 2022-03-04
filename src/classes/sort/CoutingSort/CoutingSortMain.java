package src.classes.sort.CoutingSort;

import src.classes.ApartmentAirBnb;

public class CoutingSortMain {
    public static void main(String[] args) {
        ApartmentAirBnb[] listaTeste = new ApartmentAirBnb[6];
        listaTeste[0] = new ApartmentAirBnb("", "A", "", "", "", "", "", "", "", "1", "1", "4", "", "1", "1", "1");
        listaTeste[1] = new ApartmentAirBnb("", "B", "", "", "", "", "", "", "", "1", "1", "3", "", "1", "1", "1");
        listaTeste[2] = new ApartmentAirBnb("", "C", "", "", "", "", "", "", "", "1", "1", "2", "", "1", "1", "1");
        listaTeste[3] = new ApartmentAirBnb("", "D", "", "", "", "", "", "", "", "1", "1", "1", "", "1", "1", "1");
        listaTeste[4] = new ApartmentAirBnb("", "E", "", "", "", "", "", "", "", "1", "1", "2", "", "1", "1", "1");
        listaTeste[5] = new ApartmentAirBnb("", "F", "", "", "", "", "", "", "", "1", "1", "1", "", "1", "1", "1");
        
        listaTeste = CountingSortMethod.sortNumReviews(listaTeste);
        
        for (ApartmentAirBnb apartmentAirBnb : listaTeste) {
            System.out.print(apartmentAirBnb);
        }
     }    
}
