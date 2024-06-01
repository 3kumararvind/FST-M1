package Activities;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {

        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Apple");
        myList.add("Mango");
        myList.add("Orange");
        myList.add(3, "Grapes");
        myList.add(1, "Papaya");

        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }

        System.out.println("3rd element: " + myList.get(2));
        System.out.println( myList.contains("Chicku"));
        System.out.println("Size: " + myList.size());

        myList.remove("Papaya");

        System.out.println("New Size: " + myList.size());
    }
}