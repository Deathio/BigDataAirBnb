package src.classes.sort.CoutingSort;

import java.util.ArrayList;
import java.util.List;

import src.classes.ApartmentAirBnb;

public class CoutingSortMain {
    public static void main(String[] args) {
        List<ApartmentAirBnb> listaTeste = new ArrayList<>();
        listaTeste.add(new ApartmentAirBnb("", "A", "", "", "", "", "", "", "", "1", "1", "4", "", "1", "1", "1"));
        listaTeste.add(new ApartmentAirBnb("", "B", "", "", "", "", "", "", "", "1", "1", "3", "", "1", "1", "1"));
        listaTeste.add(new ApartmentAirBnb("", "C", "", "", "", "", "", "", "", "1", "1", "2", "", "1", "1", "1"));
        listaTeste.add(new ApartmentAirBnb("", "D", "", "", "", "", "", "", "", "1", "1", "1", "", "1", "1", "1"));
        
        listaTeste = CountingSortMethod.sortNumbers(listaTeste);
        
     }    
}
