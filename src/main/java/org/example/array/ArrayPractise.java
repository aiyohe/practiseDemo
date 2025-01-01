package org.example.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayPractise {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }
        int n1 = Integer.parseInt(s1.reverse().toString());
        int n2 = Integer.parseInt(s2.reverse().toString());
        int sum = n1 + n2;
        //把顺序颠倒一下
        String reversedStr = new StringBuilder(String.valueOf(sum)).reverse().toString();
        reversedStr = String.valueOf(Integer.parseInt(reversedStr));
        ListNode result = new ListNode();
        ListNode s = result;
        for (int i = 0; i < reversedStr.length(); i++) {
            int numericValue = Character.getNumericValue(reversedStr.charAt(i));
            if (i == 0 && numericValue == 0) {
                continue;
            }
            s.val = numericValue;
            if (i < reversedStr.length() - 1) {
                s.next = new ListNode();
                s = s.next;
            }
        }
        return result;
    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
