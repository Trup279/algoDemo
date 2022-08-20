/*
An element is called a peak element if its value is not smaller than the value of its adjacent elements(if they exists).
Given an array arr[] of size N, Return the index of any one of its peak elements.
Note: The generated output will always be 1 if the index that you return is correct. Otherwise output will be 0.
* */
public class Test {
    public static void main(String[] args) {
        System.out.println("Test Program");
        int arr[] = {1,3,2};
        int peakElementFound= checkPeakExists(arr);
        System.out.println("Peak Found return code::"+peakElementFound);

    }
    private static int checkPeakExists(int[] arr) {
        int peakIndex=0;
        for (int i=0;i<arr.length-1;i++){
            if(arr[i+1]>arr[i]){
                System.out.println("Peak Found at index::"+(i+1));
                peakIndex=1;
            }
            else{
                System.out.println("Peak not found");
            }
        }
        return peakIndex;
    }
}
