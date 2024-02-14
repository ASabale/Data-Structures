package arrays.singleDimentional;

public class OneDimArray {
    public static void main(String[] args) {
        //declaration
        int[] arr1;

        //memory allocation
        arr1 = new int[5];
        int[] arr2 = new int[5];

        //initialization
        int[] arr3 = new int[]{1,2,3,4,5};

        for (int i = 0; i < arr2.length; i++) {
            arr2[i]=i+1;
        }

        //iterate
        System.out.print("arr2: ");
        for (int i1 : arr2) {
            System.out.print(i1 + " ");
        }
        System.out.println();

        System.out.print("arr3: ");
        for (int i = 0; i < arr3.length; i++) {
            int i1 = arr3[i];
            System.out.print(i1 + " ");
        }
        System.out.println();


    }
}
