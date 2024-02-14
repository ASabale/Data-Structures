package arrays.multiDimentional;

public class TwoDimArray {
    public static void main(String[] args) {
        //declaration
        int[][] arr1;

        //memory allocation
        arr1 = new int[5][5];
        int[][] arr2 = new int[3][2];

        //initialization
        int count=1;
        for (int i = 0; i < arr2.length; i++) {
            int[] subArr = arr2[i];
            for (int j = 0; j < subArr.length; j++) {
                subArr[j]=count++;
            }
        }

        int[][] arr3 = new int[][]{{1,2}, {3,4}};

        //iterate
        System.out.print("arr2: ");
        for (int i = 0; i < arr2.length; i++) {
            int[] subArr = arr2[i];
            for (int k : subArr) {
                System.out.print(k + " ");
            }
        }
        System.out.println();

        System.out.print("arr3: ");
        for (int i = 0; i < arr3.length; i++) {
            int[] subArr = arr3[i];
            for (int k : subArr) {
                System.out.print(k + " ");
            }
        }
        System.out.println();
    }
}
