package com.myoi.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author myoi
 * @date 2021/12/29 - 13:49
 */
public class exer {

    @Test
    public void test1() {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(""));


    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = 0;
        while (x > n) {
            n = x % 10 + n * 10;
            x /= 10;
        }
        return n == x || n / 10 == x;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        System.out.println(Arrays.toString(hand));
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : hand) {
            if (!map.containsKey(x)) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int num = x + i;
                if (!(map.containsKey(num))) {
                    return false;
                }
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        boolean flag = true;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0, k = i; k < length; j++, k++) {
                map.clear();
                flag = true;
                String substring = s.substring(j, k + 1);
                for (int l = 0; l < substring.length(); l++) {
                    if (map.containsKey(substring.charAt(l))) {
                        flag = false;
                        break;
                    } else {
                        map.put(substring.charAt(l), 1);
                    }
                }
                if (flag) {
                    return substring.length();
                }
            }
        }


        return 0;
    }

    public int countQuadruplets(int[] nums) {
        int length = nums.length;
        int n = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    for (int l = k + 1; l < length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            n++;
                        }
                    }
                }
            }
        }
        return n;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0, newVal = 0;
        while (p1 != null || p2 != null || carry > 0) {
            newVal = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            carry = newVal / 10;
            newVal %= 10;
            p.next = new ListNode(newVal);
            p = p.next;
            p1 = p1 == null ? null : p.next;
            p2 = p2 == null ? null : p2.next;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}