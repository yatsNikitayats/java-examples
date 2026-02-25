import java.util.Arrays;

public class ArraysMethods {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9};
        
        // toString
        System.out.println("toString: " + Arrays.toString(arr));
        
        // sort
        Arrays.sort(arr);
        System.out.println("sort: " + Arrays.toString(arr));
        
        // binarySearch (после сортировки!)
        int index = Arrays.binarySearch(arr, 5);
        System.out.println("binarySearch для 5: " + index);
        
        // equals
        int[] arr2 = {1, 2, 5, 8, 9};
        System.out.println("equals: " + Arrays.equals(arr, arr2));
        
        // compare
        int[] arr3 = {1, 2, 5, 8, 10};
        System.out.println("compare: " + Arrays.compare(arr, arr3));
        
        // fill
        int[] filled = new int[5];
        Arrays.fill(filled, 42);
        System.out.println("fill: " + Arrays.toString(filled));
    }
}
