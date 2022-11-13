
public class MaxProfitBruteForce {

	public static void FindMaxSubarrayBruteForce(int[] A, int low, int high) {
		int left = low;
		int right = high;
		int sum = Integer.MIN_VALUE;
		for (int i = low; i < high; i++) {
			for (int j = i; j < high; j++) {
				int tempdiff = A[j] - A[i];
				if (tempdiff > sum) {
					sum = tempdiff;
					left = i;
					right = j;
				}
			}
		}

		System.out.print("left: " + (left + 1));
		System.out.print(" right: " + (right + 1));
		System.out.print(" difference: " + (A[right] - A[left]));
	}

	public static int[] FindMaximumSubarray(int[] A, int low, int high) {
		if (high == low) {
			int[] r = { low, high, A[low] };
			return r;
		} else {
			int mid = (low + high) / 2;
			int[] leftArr = FindMaximumSubarray(A, low, mid);
			int[] rightArr = FindMaximumSubarray(A, mid + 1, high);
			int[] crossArr = FindMaxCrossingSubarray(A, low, mid, high);

			if (leftArr[2] >= rightArr[2] && leftArr[2] >= crossArr[2]) {
				return leftArr;
			} else if (rightArr[2] >= leftArr[2] && rightArr[2] >= crossArr[2]) {
				return rightArr;
			} else {
				return crossArr;
			}

		}
	}

	public static int[] FindMaxCrossingSubarray(int[] A, int low, int mid, int high) {

		int sum = 0;
		int leftSum = Integer.MIN_VALUE;
		int[] Arr2Out = { -1, -1, 0 };

		for (int i = mid; i >= low; i--) {
			sum += A[i];
			if (sum > leftSum) {
				Arr2Out[0] = i;
				leftSum = sum;
			}
		}

		sum = 0;

		int rightSum = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= high; i++) {
			sum += A[i];
			if (sum > rightSum) {
				Arr2Out[1] = i;
				rightSum = sum;
			}
		}
		Arr2Out[2] = leftSum + rightSum;
		return Arr2Out;
	}

	public static void main(String[] args) {

		System.out.println("Question 1:");
		int[] Arr = { 10, 11, 7, 10, 6 };
		FindMaxSubarrayBruteForce(Arr, 0, Arr.length);
		System.out.println("\n");

		System.out.println("Question 2:");
		int[] diff_test_A = { 1, -4, 3, -4 };

		int[] MaxSubArray = FindMaximumSubarray(diff_test_A, 0, 3);

		int left = MaxSubArray[0];
		int right = MaxSubArray[1];
		int maxDiff = MaxSubArray[2];

		System.out.println(
				"left indices: " + (left + 1) + " right indices: " + (right + 1) + " maximum difference: " + maxDiff);

	}
}
