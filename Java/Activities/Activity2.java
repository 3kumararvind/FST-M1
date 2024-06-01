package Activities;

public class Activity2 {
    public static  void  main(String [] args){
        int[] arr = {10, 77, 10, 54, -11, 10};
        int tmpSum=0;
        for (int num: arr){
            if(num==10){
                tmpSum+=10;
            }
        }
        if(tmpSum==30){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

    }
}
