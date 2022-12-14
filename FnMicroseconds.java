
public class FnMicroseconds {

	public static void nlogn(long numberNLogn) {

		long n = 1;
		long temp = 1;
		long nlogn = 1;
		while (true) {

			n = n + temp;
			temp++;
							// here, instead of n++, I used n + temp while temp is increasing +1 in each
							// loop. Because if we calculate with just n++, it will take a lot of time when
							// we go big numbers. But if we use n + temp, after some numbers, it will exceed
							// what we want. So, we need to decrease n until the numbers will be the same.
							// It is in the next lines

			nlogn = (long) (n * Math.log(n) / Math.log(2));
			if (numberNLogn <= nlogn) {
				while (numberNLogn <= nlogn) {
					n--; // Here, we need to find equal things that I mentioned above.
					nlogn = (long) (n * Math.log(n) / Math.log(2));
				}
				System.out.println(n);
				break;
			}
		}
	}

	public static void nfuctorial(long numberFuct) {

		long fuct = 1;

		long i = 1;
 
		while (fuct <= numberFuct) { // It's just calculating fuctorial.
			i++;
			fuct = fuct * i;
		}
		/*
		 * double fuct2 = 1;
		long longvalue = Long.MAX_VALUE;
		for(double t = 1; t<longvalue; t++) {
			fuct2 = fuct2 * t;
			if(fuct2 > numberFuct) {
				System.out.println(t-1);
				break;
			}
		}*/
		System.out.println(i - 1);

	}

	/* public static long Log2basen(long n) { // I used Math.log functionality above, but I also would use this code that I
											// wrote I guess.
		return (n > 1) ? 1 + Log2basen(n / 2) : 0;
	} */

	public static void main(String[] args) {

		// I implemented the times and changed it in microsecond unit below as question asks.
		
		long sec = 1000000;    
		long min = sec * 60;
		long hour = min * 60;
		long day = hour * 24;
		long month = day * 30;
		long year = day * 365;
		long century = day * 36524;

		System.out.println("For Fuctorial (n!): ");
		System.out.print("1 second: ");
		nfuctorial(sec);
		System.out.print("1 min: ");
		nfuctorial(min);
		System.out.print("1 hour: ");
		nfuctorial(hour);
		System.out.print("1 day: ");
		nfuctorial(day);
		System.out.print("1 month: ");
		nfuctorial(month);
		System.out.print("1 year: ");
		nfuctorial(year);
		System.out.print("1 century: ");
		nfuctorial(century);

		System.out.println("\nFor nlogn (nlogn): ");
		System.out.print("1 second: ");
		nlogn(sec);
		System.out.print("1 min: ");
		nlogn(min);
		System.out.print("1 hour: ");
		nlogn(hour);
		System.out.print("1 day: ");
		nlogn(day);
		System.out.print("1 month: ");
		nlogn(month);
		System.out.print("1 year: ");
		nlogn(year);
		System.out.print("1 century: ");
		nlogn(century);

	}

}
