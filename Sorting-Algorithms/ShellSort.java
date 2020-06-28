
import java.util.Arrays;
import java.util.Random;
 
public class ShellSort {
    
    public void shellSort(int[] arrNative) {
        
        int[] arr = new int[arrNative.length + 1];
        System.arraycopy(arrNative, 0, arr, 1, arrNative.length);
        
        int increment = arrNative.length;
        
        do {
            increment = increment/3 + 1;
            
            for (int i = increment + 1; i < arr.length; i++) {
                
                if (arr[i] < arr[i - increment]) {
                    arr[0] = arr[i];
                    
                    int j;
                    for (j = i - increment; j > 0 && arr[0] < arr[j]; j-=increment)
                        arr[j + increment] = arr[j];
                    
                    arr[j + increment] = arr[0];
                    
                }
            }
        } while (increment > 1);
        
        System.arraycopy(arr, 1, arrNative, 0, arrNative.length);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        new ShellSort().shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
 
}
