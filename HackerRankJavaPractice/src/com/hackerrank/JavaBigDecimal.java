//https://www.hackerrank.com/challenges/java-bigdecimal/problem

package com.hackerrank;

import java.math.BigDecimal;
import java.util.*;
class JavaBigDecimal{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();
        class BigDecimalComparator implements Comparator<String> {
            @Override
            public int compare(String string1, String string2) {
                BigDecimal bd1 = new BigDecimal(string1);
                BigDecimal bd2 = new BigDecimal(string2);
                return bd2.compareTo(bd1);
                }
        }
        String []strings = new String[n];
        for(int i = 0; i < n;i++){
            strings[i] = s[i];
        }
          Arrays.sort(strings, new BigDecimalComparator());
          s = strings;

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}