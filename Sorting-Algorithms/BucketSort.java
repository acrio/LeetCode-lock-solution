import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class BucketSort {

    private static final int DEFAULT_BUCKET_SIZE = 5;

    public static void sort(int[] arr) {
        bucketSort(arr, DEFAULT_BUCKET_SIZE);
    }

    public static void bucketSort(int arr[], int size) {
        if (arr.length == 0) return;

        Integer minValue = arr[0];
        Integer maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
            maxValue = Math.max(maxValue, arr[i]);
        }

        int bucketCount = (maxValue - minValue) / size + 1;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < arr.length; i++) {
            buckets.get((arr[i] - minValue) / size).add(arr[i]);
        }

        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
            for (int j = 0; j < buckets.get(i).size(); j++) {
                arr[currentIndex++] = buckets.get(i).get(j);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 7, 5, 1, 15, 20};
        BucketSort.sort(arr);
        System.out.println(Arrays.toString(arr1));
    }

}
