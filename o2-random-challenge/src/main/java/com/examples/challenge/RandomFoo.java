package com.examples.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Author: Sharat Chandra
Find out the minimum group size in which we have to randomize and continue this for the next groups
Time complexity: O(n)
Space: O(1) as the list will contain maximum of 100 elements

example:
1. For 50%, minimum group size is 2 and randomize first 2 elements, next randomize 2 elements and continue(first 2 should contain exactly one true)
2. For 75%, minimum group size is 4 and randomize first 4 elements, next randomize 4 elements and continue(first 4 should contain exactly 3 true)
*/


public class RandomFoo {

    private int numberOfTimesCalled;
    private int percentTimes;
    private int smallestGroupNumber;
    private int numberOfTruesInTheGroup;
    private List<Boolean> list;

    public RandomFoo(int percentTimes) {
        this.percentTimes = percentTimes;
        this.numberOfTimesCalled = 0;
    }

    public Boolean randomFunc() {
        Boolean result;

        if (numberOfTimesCalled == 0) {
            initialise();
        }

        Random random = new Random();

        int curRandomIndex = random.nextInt(list.size());
        result = list.get(curRandomIndex);
        list.remove(curRandomIndex);

        if (list.size() == 0){
            list = createBooleanList(smallestGroupNumber, numberOfTruesInTheGroup);
        }
        numberOfTimesCalled++;

        return result;
    }

    private void initialise(){
        smallestGroupNumber = findSmallestGroupNumberMustContainTrue(this.percentTimes);
        numberOfTruesInTheGroup =(int) (smallestGroupNumber * ((double)percentTimes / 100));

        list = createBooleanList(smallestGroupNumber, numberOfTruesInTheGroup);
    }

    private List<Boolean> createBooleanList(int smallestGroupNumber, int numberOfTruesInTheGroup) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < numberOfTruesInTheGroup; i++) {
            list.add(true);
        }

        for (int i = 0; i < smallestGroupNumber - numberOfTruesInTheGroup; i++) {
            list.add(false);
        }

        return list;
    }

    private int findSmallestGroupNumberMustContainTrue(int percentTimes) {
        for (int i = 1; i <= 100; i++) {
            double
                curGroupNumber =
                ((double)percentTimes / 100)
                * i;// curGroupNumber must be an integer value because either we call the function or not
            if (isInt(curGroupNumber)) {
                return i;
            }
        }

        return -1;
    }

    public static boolean isInt(double d) {
        return d == (int) d;
    }
}