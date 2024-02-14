package arrays.singleDimentional;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        System.out.println(numbers.length);
        System.out.println(numbers[0]);
        System.out.println(Arrays.toString(numbers));

        int[] nums = new int[10];
        System.out.println(Arrays.toString(nums));
        nums[5] = 6;
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        System.out.println(Arrays.toString(nums));
    }
}
