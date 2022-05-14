package jaca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Array Challenge
 * Have the function ArrayChallenge(arr) take the array of numbers stored in arr which will contain integers that represent
 * the amount in dollars that a single stock is worth, and return the maximum profit that could have been made by buying
 * stock on day x and selling stock on day y where y > x. For example: if arr is [44, 30, 24, 32, 35, 30, 40, 38, 15]
 * then your program should return 16 because at index 2 the stock was worth $24 and at index 6 the stock was then worth $40,
 * so if you bought the stock at 24 and sold it at 40, you would have made a profit of $16, which is the maximum profit that
 * could have been made with this list of stock prices.
 * <p>
 * If there is not profit that could have been made with the stock prices, then your program should return -1.
 * For example: arr is [10, 9, 8, 2] then your program should return -1.
 * Examples
 * Input: new int[] {10,12,4,5,9}
 * Output: 5
 * Input: new int[] {14,20,4,12,5,11}
 * Output: 8
 * Input: new int[] {44,30,24,32,35,30,40,38,15}
 * Output: 16
 * Input: new int[] {10,9,8,2}
 * Output: -1
 */

public class Main {
    public static String ArrayChallenge(String str) {

        str = str.substring(11, str.length() - 1);
        ArrayList<Integer> values = new ArrayList();
        Arrays.stream(str.split(",")).forEach(e -> values.add(Integer.parseInt(e)));

        int profit = 0;
        for (int st = 0; st < values.size(); st++) {
            for (int i = 0; i < values.size(); i++) {
                if (st < i) {
                    int currentProfit = values.get(i) - values.get(st);
                    if (currentProfit > profit) {
                        profit = currentProfit;
                    }
                }
            }
        }
        if (profit <= 0) str = String.valueOf(-1);
        else str = String.valueOf(profit);

        return str;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(ArrayChallenge(s.nextLine()));
    }
}
