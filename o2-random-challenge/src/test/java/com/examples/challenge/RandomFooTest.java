package com.examples.challenge;

import org.junit.Assert;
import org.junit.Test;


public class RandomFooTest {

	private  static RandomFoo randomFoo;

	private static final int FIFTY_PERCENT = 50;

	private static final int ONE_PERCENT = 1;

	@Test
	public void testRandomFooFor50Percent() {
		randomFoo = new RandomFoo(FIFTY_PERCENT);

		int count = 100;
		int trueCount = 0;
		while (count-->0) {
			if(randomFoo.randomFunc()){
				trueCount++;
			}
		}

		Assert.assertEquals(50,trueCount);
	}

	@Test
	public void testRandomFooFoR1Percent() {
		randomFoo = new RandomFoo(ONE_PERCENT);

		int count = 100;
		int trueCount = 0;
		while (count-->0) {
			if(randomFoo.randomFunc()){
				trueCount++;
			}
		}

		Assert.assertEquals(1,trueCount);
	}
}
