import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
       BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

        int q = Integer.parseInt(inp.readLine());
        Stack<String> stack = new Stack<String>();
        String str = "";
        while(q > 0){
            String sin = inp.readLine();
            String[] sinArr = sin.split(" ");
            int t = Integer.parseInt(sinArr[0]);
            if(t == 1){
                String s = sinArr[1];
                stack.push(str);
                str = str + s;                
            }else if(t == 2){
                int n = Integer.parseInt(sinArr[1]);
                stack.push(str);
                str = str.substring(0,str.length() - n);
            }else if(t == 3){
                int n = Integer.parseInt(sinArr[1]);
                printNthChar(str, n);
            }else if( t == 4 && !stack.isEmpty()){
                String s = stack.pop();
                str = s;
            }
            q--;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void printNthChar(String str, int n){
        System.out.println(str.toCharArray()[n-1]);
    }
}