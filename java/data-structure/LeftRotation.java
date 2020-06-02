import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int x = n-d;
        if(x != 0){
            for(int i=0;i<d;i++){
                a = rotateByOne(a);
            }
        }

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        scanner.close();
    }

    private static int[] rotateByOne(int[] arr){
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
        return arr;
    }
}
