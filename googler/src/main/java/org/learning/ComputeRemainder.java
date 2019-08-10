package org.learning;

public class ComputeRemainder {

	public static void main(String[] args) {
		System.out.println(computeRemainder(2, 20));
	}

	public static long computeRemainder(long base, long power) {
		long baseRaisedToPower = 1;

		for (long i = 1; i <= power; i++) {
			baseRaisedToPower *= base;
		}

		return baseRaisedToPower;
	}

	public static long computeRemainderUsingEBS(long base, long power) {
		long baseRaisedToPower = 1;
		long powerBitsReversed = 0;
		int numBits = 0;

		while (power > 0) {
			powerBitsReversed <<= 1;
			powerBitsReversed += power & 1;
			power >>>= 1;
			numBits++;

		}

		while (numBits-- > 0) {
			if (powerBitsReversed % 2 == 1)
				baseRaisedToPower *= baseRaisedToPower * base;
			else
				baseRaisedToPower *= baseRaisedToPower;

			powerBitsReversed >>>= 1;
		}
		return baseRaisedToPower;
	}
}
