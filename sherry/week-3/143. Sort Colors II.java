// 143. Sort Colors II
//
// Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
//
// Example
//
// Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
//
// Challenge
//
// A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        // edgeCase
        if(colors == null ) {
            return;
        }
       // rainbowSort(colors, 0, colors.length - 1, 1, k);
      int count = 0;
        int left = 0;
        int right = colors.length - 1;
        while (count < k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = left; i <= right; i++) {
                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }
            int cur = left;
            while(cur <= right) {
                if (colors[cur] == min) {
                    swap(left, cur, colors);
                    cur++;
                    left++;
                } else if (colors[cur] > min && colors[cur] < max) {
                    cur++;
                } else {
                    swap(cur, right, colors);
                    right--;
                }
            }
            count += 2;

        }
    }

    void swap(int left, int right, int[] colors) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }

    private void rainbowSort(int [] colors, int left, int right, int colorFrom, int colorTo) {
        //end condition
        if(colorFrom == colorTo) {
            return;
        }
        if(left >= right){
            return;
        }
        int midColor = (colorFrom + colorTo) / 2;
        int start = left;
        int end = right;
        while(start <= end) {
            while(start <= end && colors[start] <= midColor) {
                start++;
            }
            while(start <= end && colors[end] > midColor) {
                end--;
            }
            if(start <= end) {
                int temp = colors[start];
                colors[start] = colors[end];
                colors[end] = temp;
                start++;
                end--;
            }
        }

        rainbowSort(colors, left, end, colorFrom, midColor);
        rainbowSort(colors, start, right, midColor + 1, colorTo);
    }
}
