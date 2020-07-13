import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        while(n>0){
            int q = sc.nextInt();
            if(q == 1){
                int v = sc.nextInt();
                stack.push(v);  
                if(maxStack.isEmpty()){
                    maxStack.push(v);
                }else{
                    int max = maxStack.peek();
                    if(v > max){
                        maxStack.push(v);
                    }else{
                        //maintaing same size for both stack
                        maxStack.push(max);
                    }
                }
            }else if(q==2){
                int v = stack.pop();
                //since both are of same size, popping from max stack won't affect
                maxStack.pop();                
            }else if (q==3){
                System.out.println(maxStack.peek());
            }
            n--;
        }
    }
}