package cs6301.g45;

/**
 * Implementation of Merge Sort algorithm using generic.
 * @author Lopamudra Muduli
 * @author Bhakti Khatri
 * @author Sangeeta Kadambala
 * @author Gautam Gunda
 */

public class MergeSortUsingGenerics {
	
	/**
	 * @param arr: T[] - unsorted input array to be sorted.
	 * @param temp: T[] - temporary array to be used during the merge.
	 * @param leftIdx: int - left index of input array
	 * @param rightIdx: int - right index of input array
	 */

	public static<T extends Comparable<? super T>> void mergeSort(T[] arr, T[] temp, int leftIdx, int rightIdx){
		if(leftIdx < rightIdx){
			int midIdx = (leftIdx + rightIdx)/2;
			mergeSort(arr, temp, leftIdx, midIdx);
			mergeSort(arr, temp, midIdx + 1, rightIdx);
			merge(arr,temp,leftIdx,midIdx,rightIdx);
		}
	}
	
	/**
	 * Method for merge operation.
	 * @param arr: T[] - input array to be merged.
	 * @param temp: T[] - temporary array to be used during the merge.
	 * @param leftIdx: int - left index of input array
	 * @param midIdx: int - middle index of input array
	 * @param rightIdx: int - right index of input array
	 */
	
	public static <T extends Comparable<? super T>> void merge(T[] arr, T[] temp, int leftIdx, int midIdx, int rightIdx) {
		int temp_startIdx = leftIdx;
		int startIdx_right = midIdx + 1;
		int total_length = rightIdx - leftIdx + 1;
		
		while(leftIdx <= midIdx && startIdx_right <= rightIdx){
			if(arr[leftIdx].compareTo(arr[startIdx_right]) <= 0){
				temp[temp_startIdx] = arr[leftIdx];
				leftIdx++;
				
			}else{
				temp[temp_startIdx] = arr[startIdx_right];
				startIdx_right++;
			}
			temp_startIdx++;
		}
		//Copy remaining elements from left
		while(leftIdx <= midIdx){
				temp[temp_startIdx] = arr[leftIdx];
				temp_startIdx++;
				leftIdx++;
		}
		//Copy remaining elements from right

		while(startIdx_right <= rightIdx){
				temp[temp_startIdx] = arr[startIdx_right];
				temp_startIdx++;
				startIdx_right++;
		}
		for(int i = 0; i < total_length; i++,rightIdx--){
			arr[rightIdx] = temp[rightIdx];
		}
		
	}

	
	static<T> void printFirstTen(T[] arr) {
        int n = Math.min(arr.length, 10);
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
     }	
}
