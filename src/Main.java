import DataStructure.ListNode;
import org.junit.Test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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


