import java.io.*;
import java.util.*;
class sort
{
	public static void selectionSort(int a[])
	{
		int n = a.length;
		for (int i = 0; i < n-1; i++)
		{
			// index of minimum element
			int min = i;
			for (int j = i+1; j < n; j++)
            {
				if (a[j] < a[min])
					min = j;
            }

			// Swap the found minimum element with the first element
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}

	static void stableSelectionSort(int[] a, int n)
    {
		int n = a.length;
        for (int i = 0; i < n - 1; i++)
        {
            // Loop invariant: Elements till a[i - 1] are already sorted.
            // Find minimum element from arr[i] to arr[n - 1].
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (a[min] > a[j])
                    min = j;
 
            // Move minimum element at current i.
            int key = a[min];
            while (min > i)
            {
                a[min] = a[min - 1];
                min--;
            }
             
            a[i] = key;
        }
    }

	static void bubbleSort(int a[])
    {
		int n = a.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++)
		{
            swapped = false;
            for (int j = 0; j < n - i - 1; j++)
			{
                if (a[j] > a[j + 1])
				{
                    // Swap a[j] and a[j+1]
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                } 
            }
            // If no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

	static void recursiveBubbleSort(int arr[], int n)
    {
        // Base case
        if (n == 1)
            return;
  
        int count = 0;
        // One pass of bubble sort. After this pass, the largest element is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
		{
            if (arr[i] > arr[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                count = count+1;
            }
		}
  
        // Check if any recursion happens or not If any recursion is not happen then return
        if (count == 0)
        	return;
  
        // Largest element is fixed, recur for remaining array
        recursiveBubbleSort(arr, n-1);
    }

	void InsertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Merges two subarrays of arr[]. First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void MergeSort(int arr[], int l, int r)
    {
        if (l < r) {
 
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

	public static void printArray(int a[])
	{
		int n = a.length;
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = sc.nextInt();
		}
		selection(a);
		stableSelectionSort(a);
		bubbleSort(a);
		recursiveBubbleSort(a, a.length);
		InsertionSort(a);
        MergeSort(a, 0, a.length);

		System.out.println("Sorted array");
		printArray(a);
	}
}