package Activities;

import java.util.Arrays;

public class Activity4 {
    static void ascendingSort(int ar[]){
        int size = ar.length,i;
        for(i=1;i<size; i++){
            int key = ar[i];
            int j=i-1;
            while(j>=0 && key <ar[j]){
                ar[j+1] = ar[j];
                --j;
            }
            ar[j+1]=key;
        }
    }
    public static  void main(String args[]){
        int[] data = {10,33, 12, 11,5, 1};
        ascendingSort(data);
        System.out.println("ASC sorted array:");
        System.out.println(Arrays.toString(data));
    }
}
