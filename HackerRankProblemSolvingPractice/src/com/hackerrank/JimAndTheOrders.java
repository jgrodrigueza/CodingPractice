//https://www.hackerrank.com/challenges/jim-and-the-orders/problem

package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JimAndTheOrders {

    static class Order {
        
        public int customer;
        public int prepTime;
        
        public Order(int customer, int prepTime) {
            this.customer = customer;
            this.prepTime = prepTime;
        }
        
    }
    
    static class PrepTimeSort implements Comparator<Order> {

        @Override
        public int compare(Order o1, Order o2) {
            return Integer.compare(o1.prepTime, o2.prepTime);
        }

    }

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        List<Order> orderL = new ArrayList<Order>();
        for (int cust = 0; cust < orders.length; cust++) {
            orderL.add(new Order(cust + 1, orders[cust][0] + orders[cust][1]));
        }
        Collections.sort(orderL, new PrepTimeSort());
        int[] result = new int[orderL.size()];
        for (int pos = 0; pos < orderL.size(); pos++) {
            result[pos] = orderL.get(pos).customer;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

