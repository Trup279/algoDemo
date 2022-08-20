/*
* Given a sorted array of n integers and a target value, determine if the target exists in the array in logarithmic
* time using the binary search algorithm. If target exists in the array, print the index of it.
* */
public class BinarySearchTest {
    public static void main(String[] args) {
        int arr[]={2, 3, 5, 7, 9};
        int elementToSearch=3;
        int index=binarySearch(arr,elementToSearch);
        if(index==-1)
            System.out.println("Element not present in Array!!!");
        else
        System.out.println("Element::"+elementToSearch+" found at index::"+index);
    }
    private static int binarySearch(int[] arr, int elementToSearch) {
        int start = 0;
        int last = arr.length - 1;
        int mid = (start + last) / 2;
        while (start <= last) {
            System.out.println("Arrays position start::" + start + " last::" + last + " mid::" + mid);
            if (arr[mid] == elementToSearch) {
                return mid;
            } else if (arr[mid] < elementToSearch) {
                start = mid + 1;
                 mid = (start + last) / 2;
            } else if (arr[mid] > elementToSearch) {
                last = mid - 1;
                 mid = (start + last) / 2;
            }
        }
        return -1;
    }
}
