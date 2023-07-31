package com.home.samples.calculator;

public class MainTest {

    static int[] nums = {1, 2, 3, 4};
    public static void main(String[] args) {
        // test copy by value
        System.out.println(nums);
        manipulateNumbers(nums);
        System.out.println(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }

    static void manipulateNumbers(int[] numArray) {
        int[] numsCopy = numArray;
        boolean checkIsSameArray = nums == numsCopy;
        numsCopy[0] = 10;
    }
}
