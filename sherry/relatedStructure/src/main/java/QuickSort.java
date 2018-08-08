import java.lang.reflect.Array;
import java.util.*;

public class QuickSort {

    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    /**
     * @param k:    An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        // to get Kth smallest  -> [1,2,3,4,5,6], kth smallest is length - k + 1 lar number
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    public int median(int[] nums) {
        // write your code here
        if (nums == null) {
            return -1;
        }
        //if(nums.length % )
        //how to determin mid of an array?
        int mid = nums.length - nums.length / 2 + (nums.length % 2 == 1 ? 0 : 1);
        System.out.println(mid);
        return quickSelect(nums, 0, nums.length - 1, mid);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        // get the pivot
        int pivot = nums[start + (end - start) / 2];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        //quick a interval to continue
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }

    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k:      An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        // quick select
        //edge cases
        if (points == null) {
            return null;
        }

        //quickSort using diff
        // K number -> K's smallest -> points.length - k largest
        //[1,2,3,4,5,6] 3th smallest, => length - k +1 largest
        int index = quickSelect(points, origin, 0, points.length - 1, k - 1);
        //System.out.println(k);
        List<Point> resultArray = Arrays.asList(Arrays.copyOf(points, k));
        //System.out.println(resultArray);
        Collections.sort(resultArray, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int temp = getDiff(o1, origin) - getDiff(o2, origin);
                if (temp == 0) {
                    temp = o2.x - o1.x;
                    if (temp == 0) {
                        return o2.y - o1.y;
                    }
                    return temp;
                }
                return temp;
            }
        });

        return (Point[]) resultArray.toArray();
    }

    private int getDiff(Point point, Point orgin) {
        return Math.abs(point.x - orgin.x) + Math.abs(point.y - orgin.y);
    }

    private int quickSelect(Point[] points, Point origin, int start, int end, int k) {
        if (start == end) {
            return start;
        }
        int diff = getDiff(points[(end + start) / 2], origin);

        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= j && getDiff(points[i], origin) <= diff) {
                i++;
            }
            while (i <= j && getDiff(points[j], origin) >= diff) {
                j--;
            }
            if (i <= j) {
                Point temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
                j--;
            }
        }
        //[1,2,3,4,5] start = 0, k = 2, j = 3
        if (start + k < j) {
            System.out.println(start + " " + j + " " + k);
            return quickSelect(points, origin, start, j, k);
        }
        if (start + k > i) {
            System.out.println(start + " " + i + " " + end + " " + k);
            return quickSelect(points, origin, i, end, k - (i - start));
        }

        return j + 1;
    }


    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

}
