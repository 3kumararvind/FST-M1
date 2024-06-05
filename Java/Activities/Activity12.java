package Activities;
interface Adable{
    int add(int a, int b);
}
public class Activity12 {
    public static void main(String[] args) {
        Adable ad = (a,b)->(a+b);
        System.out.println(ad.add(40,50));

        Adable ad2 = (int a, int b)->{
            return (a+b);
        };
        System.out.println(ad2.add(100, 200));
    }
}
