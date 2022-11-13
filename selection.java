import java.util.Arrays;
import java.util.Random;

public class selection {
	public static void main(String[] args) {
		int array_size = 10;
		int n_repetitions = 10;

		int array[] = new int[array_size];

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		// part(b) choosing one integer array and showing that the sort method works

		// initialize elements of array with random integers
		for (int i = 0; i < array.length; i++)
			array[i] = rand.nextInt(100);

		System.out.println("Second Question Part b array size of 10:");
		print_array(array);
		selection_sort(array);
		print_array(array);

		// part(c) min, average, max running times

		System.out.println("\nFOR ARRAY THAT HAS 1000 NUMBER:");
		statistics(1000, 1000);
		System.out.println("\nFOR ARRAY THAT HAS 10000 NUMBER:");
		statistics(10000, 1000);
	}

	// part(a) implementing selection sort algorithm as a method below
	public static void selection_sort(int[] A) {

		for (int i = 0; i < A.length - 1; i++) {
			int minindex = i;
			for (int j = i + 1; j < A.length; j++)
				if (A[j] < A[minindex])
					minindex = j;

			int temp = A[minindex];
			A[minindex] = A[i];
			A[i] = temp;
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

	// part (c) compute min, average, max times for repeatedly sorting random arrays
	public static void statistics(int array_size, int n_repetitions) {
		long min_time, max_time, sum_time;
		double average_time;

		int array[] = new int[array_size];

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		min_time = 0;
		max_time = 0;
		average_time = 0.0;
		sum_time = 0;

		long startTime = 0;
		long endTime = 0;
		long exectTime = 0;

		for (int k = 0; k < n_repetitions; k++) {

			// initialize elements of array with random integers
			for (int i = 0; i < array.length; i++)
				array[i] = rand.nextInt(100);
			// call insertion sort method
			startTime = System.nanoTime();
			selection_sort(array);
			endTime = System.nanoTime();

			exectTime = endTime - startTime;

			sum_time = sum_time + exectTime;

			if (min_time != 0) {
				if (exectTime < min_time) {
					min_time = exectTime;
				}
				if (exectTime > max_time) {
					max_time = exectTime;
				}
			} else {
				min_time = exectTime;
			}

			// compute min_time, max_time, sum_time

		}

		average_time = (double) sum_time / (double) n_repetitions;

		System.out.printf("Min time: %d\n", min_time);
		System.out.printf("Average time: %.2f\n", average_time);
		System.out.printf("Max time: %d\n", max_time);

	}

}
