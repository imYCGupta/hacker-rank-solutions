import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {     

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int operations = 0;
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        
        for(int i = 0; i < n; i++) {
            que.add(sc.nextInt());
        }
        
        
        while(que.size() > 1 && que.peek() < k) {
            int leastSweet = que.poll();
            int secondLeast = que.poll();
            
            que.add(leastSweet + 2*secondLeast);
            operations++;
        }
        
       
        if(que.peek() < k) {
            System.out.print(-1);
        } else {
            System.out.print(operations);
        }
    }
}
