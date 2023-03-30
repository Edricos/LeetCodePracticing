import DataStructure.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


//    贪心法实现两个数组田忌赛马
//    const int N = 1010;
//int n;
//int a[N], b[N];
//
//int main() {
//    while (cin >> n, n) {
//        for (int i = 0; i < n; i++) cin >> a[i];
//        sort(a, a + n);
//        for (int i = 0; i < n; i++) cin >> b[i];
//        sort(b, b + n);
//
//        int res = 0;
//        for (int la = 0, ra = n - 1, lb = 0, rb = n - 1; la <= ra;) {
//        	// 国王最快马比田忌最快马快，则田忌派出最慢马；
//        	// 国王最快马比田忌最快马慢，则田忌派出最快马；
//            if (b[rb] > a[ra]) {
//                res -= 200;
//                la++, rb--;
//            } else if (b[rb] < a[ra]) {
//                res += 200;
//                ra--, rb--;
//            } else {
//            	// 国王最快马和田忌最快马一样快，如果国王最慢马比田忌最慢马慢，
//            	// 则田忌派出最慢马与国王最慢马比；否则派最慢马与国王最快马比
//                if (b[lb] < a[la]) {
//                    res += 200;
//                    la++, lb++;
//                } else {
//                    if (a[la] < b[rb]) res -= 200;
//                    la++, rb--;
//                }
//            }
//        }
//
//        cout << res << endl;
//    }
//
//    return 0;
//}



    @Test
    public void test() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(new long[]{multiply(a, b)}));
    }

//    n位大数相乘 分治法
    public long multiply(int[] a, int[] b) {
        int n = a.length;
        if (n == 1)
            return a[0] * b[0];
        int[] a1 = Arrays.copyOfRange(a, 0, n / 2);
        int[] a2 = Arrays.copyOfRange(a, n / 2, n);
        int[] b1 = Arrays.copyOfRange(b, 0, n / 2);
        int[] b2 = Arrays.copyOfRange(b, n / 2, n);
        long c1 = multiply(a1, b1);
        long c2 = multiply(a2, b2);
        long c3 = multiply(add(a1, a2), add(b1, b2));
        return (long) (c1 * pow(10, n) + (c3 - c1 - c2) * pow(10, n / 2) + c2);
    }
    public int[] add(int[] a, int[] b) {
        int n = a.length;
        int[] c = new int[n + 1];
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[i] + b[i] + carry;
            c[i + 1] = temp % 10;
            carry = temp / 10;
        }
        c[0] = carry;
        return c;
    }




    @Test
    public void MaxsSubSumTest() {
        int[] a = {4, -3, 5, -2, -1, 2, 6, -2};
        System.out.println(MaxSubSum(a, 0, a.length - 1));
    }
//    分治法求最大子序列
    public int MaxSubSum(int[] a, int left, int right) {
        if (left == right) {
            if (a[left] > 0)
                return a[left];
            else
                return 0;
        }
        int center = (left + right) / 2;
        int maxLeftSum = MaxSubSum(a, left, center);
        int maxRightSum = MaxSubSum(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }
        return max(max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
    }

// n皇后问题
    @Test
    public void nQueen() {
        FnQueen nq = new FnQueen();
        nq.start();
    }


    // 判断素数
    @Test
    public void FifS() {
        Scanner input = new Scanner(System.in);
//        int num = input.nextInt();
        int num = 16;
        int k = (int) sqrt((double) num);
        int i;
        for (i = 2; i <= k; i++)
            if (num % i == 0)
                break;
        // 如果完成所有循环，那么m为素数
        // 注意最后一次循环，会执行i++，此时 i=k+1，所以有i>k
        if (i > k)
            System.out.println(num + " 是素数");
        else
            System.out.println(num + " 不是素数");
    }


    //最大公约数
    @Test
    public void measure() {
        int x = 35;
        int y = 28;
        int z = y;
        while (x % y != 0) {
            z = x % y;
            x = y;
            y = z;
        }
        System.out.println(z);
    }

    //动态规划01背包
    @Test
    public void Fbag01() {
        int[] w = {0, 2, 3, 4, 5};            //商品的体积2、3、4、5
        int[] v = {0, 3, 4, 5, 6};            //商品的价值3、4、5、6
        int bagV = 8;                            //背包大小
        int[][] dp = new int[5][9];
//        Arrays.fill(dp, 0);//动态规划表

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= bagV; j++) {
                if (j < w[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }
        }
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


    @Test
    public void missionAlocationTest() {
        int[][] matrix = {{9, 2, 7, 8},
                {6, 4, 3, 7},
                {5, 8, 1, 8},
                {7, 6, 9, 4}};
//    for (int[] ints : matrix) {
//        for (int anInt : ints) {
//            System.out.print(anInt+" ");
//        }
//        System.out.println();
//    }


    }

    public void missionAlocation(int[][] matrix, int h) {
        int[] mission = new int[matrix[0].length];
        for (int i = 0; i < mission.length; i++) {
            mission[i] = 0;
        }
        if (h >= matrix[0].length) {

        }

    }


    public class Bag {
        int maxw;
        int maxp;
        int[] choised;

        public Bag(int maxw, int maxp, int[] choised) {
            this.maxw = maxw;
            this.maxp = maxp;
            this.choised = choised;
        }

        public Bag() {
        }

        public Bag(int maxw, int maxp) {
            this.maxw = maxw;
            this.maxp = maxp;
        }

        @Override
        public String toString() {
            return "Bag{" +
                    "maxw=" + maxw +
                    ", maxp=" + maxp +
                    ", choised=" + Arrays.toString(choised) +
                    '}';
        }
    }


    @Test
    public void Bag01ForceTest() {
        int[] weight = {5, 3, 2, 1};
        int[] prices = {4, 4, 3, 1};
        int max = 6;
//        for (int i : Bag01Force(weight, prices, max)) {
//            System.out.print(i);
//            System.out.print(" ");
//        }

        int[] chiose = new int[weight.length];
        for (int i = 0; i < chiose.length; i++) {
            chiose[i] = 0;
        }
        Bag best = new Bag(0, 0);
        B01F(best, chiose, weight, prices, max, 0, 0);
        B01F(best, chiose, weight, prices, max, 0, 1);
        System.out.println(best);
    }

    public void B01F(Bag best, int[] choise, int[] weight, int[] prices, int max, int h, int c) {
        if (h >= choise.length) {
            int sumw = 0;
            int sump = 0;
            for (int i = 0; i < choise.length; i++) {
                System.out.print(" " + choise[i]);
                if (choise[i] == 1) {
                    sumw += weight[i];
                    sump += prices[i];
                }
            }
            System.out.print("  重量：" + sumw + "  价值：" + sump);
            if (sumw > max) {
                System.out.print("  超重");
            } else {
                if (best.maxp < sump) {
                    best.maxp = sump;
                    best.maxw = sumw;
                    best.choised = choise.clone();
                }
                System.out.print("  合适");
            }
            System.out.println();
            return;
        }
//        System.out.print("层数：");
//        System.out.print(c+" ");
        choise[h] = c;
        B01F(best, choise, weight, prices, max, h + 1, 0);
//        B01F(choise, weight, prices, max, h+1, 1);
        if (h + 1 != choise.length) {
            B01F(best, choise, weight, prices, max, h + 1, 1);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        boolean flag = true;
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }
        int[] re = new int[2];
        re[0] = i;
        re[1] = j;
        return re;
    }


    /**
     * Definition for singly-linked list.
     * public class DataStructure.ListNode {
     * int val;
     * DataStructure.ListNode next;
     * DataStructure.ListNode() {}
     * DataStructure.ListNode(int val) { this.val = val; }
     * DataStructure.ListNode(int val, DataStructure.ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0, j = 0, d1, d2;
        ListNode h = new ListNode(0, null), p;
        p = h;
        while (l1 != null || l2 != null) {
            d1 = l1 == null ? 0 : l1.val;
            d2 = l2 == null ? 0 : l2.val;
            i = d1 + d2 + j;
            // l1.val = i % 10;
            ListNode a = new ListNode(i % 10, null);
            p.next = a;
            p = p.next;
            j = i / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            // l1 = l1==null? null:l1.next;
            // l2 = l2==null? null:l2.next;
        }
        if (j != 0) {
            p = h;
            while (p.next != null) p = p.next;
            p.next = new ListNode(j, null);
        }
        return h.next;
    }


    //    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    public int lengthOfLongestSubstring(String s) {
        return 0;
    }


    // 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] comb = new int[(nums1.length + nums2.length) / 2 + 1];
        int i = 0, j = 0, k = 0;
        while ((j < nums1.length || k < nums2.length) && i < comb.length) {
            if (j == nums1.length) {
                comb[i] = nums2[k];
                k++;
            } else if (k == nums2.length) {
                comb[i] = nums1[j];
                j++;
            } else {
                if (nums1[j] <= nums2[k]) {
                    comb[i] = nums1[j];
                    j++;
                } else {
                    comb[i] = nums2[k];
                    k++;
                }
            }
            i++;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return (comb[comb.length - 1]);
        } else {
            return (comb[comb.length - 1] + comb[comb.length - 2]) / 2.0;
        }
    }
}


