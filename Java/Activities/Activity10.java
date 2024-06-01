package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<String>();
        hs.add("Object 1");
        hs.add("Object 2");
        hs.add("Object 3");
        hs.add("Object 4");
        hs.add("Object 5");
        hs.add("Object 6");

        System.out.println("Size: " + hs.size());
        hs.remove("Object 1");
        if (hs.remove("Object 10")){
            System.out.println("Object 10 is removed");
        }else {
            System.out.println("Object 10 is not removed");
        }
        hs.contains("Object 3");

        System.out.println("Updated Set: " + hs);
    }

}
