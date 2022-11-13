import java.util.Random;

public class mergeSort {
	public static void main(String[] args) {
		int array_size = 16;
		int[] array = new int[array_size];
		long start_time, end_time, elapsed_time;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);

		// part 2(b)

		System.out.print("Array size 16 before sorting: ");
		print_array(array);
		merge_sort(array, 0, array_size - 1);
		System.out.print("Array size 16 after sorting: ");
		print_array(array);

		// part 3(a)
		//part 3(b)

		int array_size2 = 104857;
		int[] array2 = new int[array_size2];
		int[] InsertionArray = new int[array_size2];

		Random rand2 = new Random();
		rand2.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size2; i++)
			array2[i] = rand2.nextInt(100);

		for (int j = 0; j < array_size2; j++) {
			InsertionArray[j] = array2[j];
		}

		start_time = System.nanoTime();
		merge_sort(array2, 0, array_size2 - 1);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
		System.out.println("Elapsed time for merge sort: " + elapsed_time);

		start_time = System.nanoTime();
		insertion_sort(InsertionArray);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
		System.out.println("Elapsed time for insertion sort: " + elapsed_time);

		
		

	}

	// indices p and r can start from 0
	public static void merge_sort(int[] A, int p, int r) {

		if (p >= r) {
			return;
		}

		int middle = p + (r - p) / 2;

		merge_sort(A, p, middle);
		merge_sort(A, middle + 1, r);

		merge(A, p, middle, r);
	}

	// Part 2(a)
	public static void merge(int[] A, int p, int q, int r) {

		int leftArraySize = q - p + 1;
		int rightArraySize = r - q;

		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		for (int i = 0; i < leftArraySize; i++) {
			leftArray[i] = A[p + i];

		}
		for (int i = 0; i < rightArraySize; i++) {
			rightArray[i] = A[q + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = p;
		while (i < leftArraySize && j < rightArraySize) {
			if (leftArray[i] < rightArray[j]) {
				A[k] = leftArray[i];
				i++;
				k++;
			} else {
				A[k] = rightArray[j];
				j++;
				k++;
			}
		}

		while (i < leftArraySize) {
			A[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightArraySize) {
			A[k] = rightArray[j];
			j++;
			k++;
		}

	}

	public static void insertion_sort(int[] A) {

		for (int i = 1; i < A.length; i++) {
			int key = A[i];
			int j = i - 1;
			while (j >= 0 && key < A[j]) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = key;
		}

	}

	// prints the elements of the array A on the screen
	public static void print_array(int[] A) {
		System.out.printf("[");
		for (int i = 0; i < A.length - 1; i++) {
			System.out.printf("%d, ", A[i]);
		}

		System.out.printf("%d]\n", A[A.length - 1]);

	}
}
