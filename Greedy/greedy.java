import java.util.*;

public class greedy {
    public static void main(String args[])  // O(n)
    {

        // Activity Selection // O(n)
        /*
            You are given n activities with their start and end times.
            Select the maximum number of activities that can be performed
            by a single person, assuming that a person can only work on a 
            single activity at a time.
        */

        /*
        // Case 1: Activities are sorted to end time.

        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for(int i = 1; i < end.length; i++)
        {
            if(start[i] >= lastEnd)
            {
                // activity select
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Activity Selection without end time sorting");
        System.out.println("Max activities = " + maxAct);
        for(int i = 0; i < ans.size(); i++)
        {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
        */

        /*
        // Case 2: Activities are not sorted by end time. Need to store in a
        // 2D matrix (index, start time, end time) and then sort by end time

        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // sorting
        int activities[][] = new int[start.length][3];
        for(int i = 0; i < start.length; i++)
        {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i = 1; i < end.length; i++)
        {
            if(activities[i][1] >= lastEnd)
            {
                // activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Activity Selection after sorting by end time");
        System.out.println("Max activities = " + maxAct);
        for(int i = 0; i < ans.size(); i++)
        {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
        */

        // Fractional Knapsack
        /*
            Given the weights and values of N items, put these items in a knapsack
            of capacity W to get the maximum total value in the knapsack.
        */
        /*
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        double ratio[][] = new double[val.length][2];
        // 0th col => idx; 1st col => ratio

        for(int i = 0; i < val.length; i++)
        {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // ascending
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalVal = 0;

        for(int i = ratio.length-1; i >= 0; i--)
        {
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]) // include full item
            {
                finalVal += val[idx];
                capacity -=weight[idx];
            }
            else
            {
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        
        System.out.println("Fractional Knapsack");
        System.out.println("Final value = " + finalVal);
        */

        // Min Absolute Difference Pairs
        /*
            Given two arrays A and B of equal length n. Pair each element
            of array A to an element in array B, such that sum S of absolute
            differences of all the pairs is minimum.
        */

        /*
        // int A[] = {1, 2, 3};
        // int B[] = {2, 1, 3};

        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for(int i = 0; i < A.length; i++)
        {
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println("Min Absolute Difference Pairs");
        System.out.println("Min absolute diff of pairs = " + minDiff);
        */


        // Max Length Chain of Pairs    // O(n log n)
        /*
            You are given n pairs of numbers. In every pair, the first number
            is always smaller than the second number. A pair (c , d) can come
            after pair (a , b) if b < c. Find the longest chain which can be
            formed from a given set of pairs.
        */

        /*
        // Similar to activity selection
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pairs[0][1]; // Last selected pair end // chain end

        for(int i = 1; i < pairs.length; i++)
        {
            if(pairs[i][0] > chainEnd)
            {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Max Length Chain of Pairs");
        System.out.println("Max length of chain = " + chainLen);
        */


        // Indian Coins
        /*
            We are given an infinite supply of denominations
            [1, 2, 5, 10, 20, 50, 100, 500, 2000]. Find minimum number
            of coins/ notes to make change for a value V.
        */

        /*
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoins = 0;
        // int amount = 590;
        int amount = 1059;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < coins.length; i++)
        {
            if(coins[i] <= amount)
            {
                while(coins[i] <= amount)
                {
                    countOfCoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Indian Coins Change Problem");
        System.out.println("Total (min) coins used = " + countOfCoins);

        for(int i = 0; i < ans.size(); i++)
        {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
        */

        // Chocola Problem
        /*
            We are given a bar of chocolate composed of m x n square pieces.
            One should break the chocolate into single squares. Each break
            of a part of the chocolate is charged a cost expressed by a
            positive integer. This cost does not depend on the size of the
            part that is being broken but only depends on the line the break
            goes along. Let us denote the costs of breaking along consecutive
            vertical lines with x1, x2, ...., xm-1 and along horizontal lines
            with y1, y2, ...., yn-1.
            Compute the minimal cost of breaking the whole chocolate into
            single squares.
        */

        /*
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4};    // m-1
        Integer costHor[] = {4, 1, 2};  // n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;
        
        while(h < costHor.length && v < costVer.length)
        {
            if(costVer[v] <= costHor[h])    // horizontal cut
            {
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }
            else    // vertical cut
            {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while(h < costHor.length)
        {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while(v < costVer.length)
        {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Chocola Problem");
        System.out.println("Min cost of cuts = " + cost);
        */

    }
    
}
