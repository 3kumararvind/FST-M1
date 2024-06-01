package Activities;

import java.sql.SQLOutput;
import java.util.HashMap;

public class Activity11 {
    public static void main(String args){
        HashMap<Integer, String> colours = new HashMap<Integer, String>();
        colours.put(1, "Red");
        colours.put(2, "Yellow");
        colours.put(3, "Green");
        colours.put(4, "Pink");
        colours.put(5, "Blue");
        System.out.println("Original Map: " + colours);
        colours.remove(2);
        if (colours.containsValue("Green")){
            System.out.println("Green is present.");
        }else{
            System.out.println("Green is not present");
        }
        System.out.println("Size of Map: " + colours.size());
    }
}
