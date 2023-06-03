package org.personal;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class LoanAsPerBuilderDemand {

    /*
	 Suppose your property is under construction and possession is in 3 years so you will get demand from builder side, and suppose you get x amomunt of
	 demand and you have y savings then you will ask bank to pay x-y amount (obvious x > y) and this process follow based on every period of cycle (period will be
	 suppose n) hence need to calculate how much interest  we have paid before possession.
	 */

    private final static float interestRate = 8.65f;
    private final static List<Integer> demands = Arrays.asList(529235, 433011, 962248, 962249, 1443372 ,962247, 481124, 481125, 481126, 481127, 962250, 481128, 481129);

    private final static List<Integer> paidAmount = Arrays.asList(200000, 200000, 300000, 200000, 300000, 200000, 200000, 200000, 300000, 200000, 300000, 200000, 200000);

    private static int totalPrinciple = 0;
    private static int principle = 0;
    private static float interest = 0;
    private static float totalInterest = 0;
    private static final Map<Integer, Integer> principlePendingWithMonths = new HashMap<>();

    public static void main(String[] args) {
        int months = 0;

        for (int i = 0; i < 40; i++) {
            AtomicReference<Float> monthlyInterest = new AtomicReference<>((float) 0);

            if (i % 3 == 0) {
                int index = i/3;
                if (index <= (demands.size() - 1)) {
                    principle = demands.get(index) - paidAmount.get(index);
                    principlePendingWithMonths.put(principle, months);
                    totalPrinciple += principle;
                }
            }

            principlePendingWithMonths.forEach((amount, time) -> {
                interest = calculateAndGetInterest(amount, time);
                totalInterest += interest;
                monthlyInterest.updateAndGet(v -> (v + interest));

                int updatedTime = time + 1;

                if (updatedTime > 1) {
                    updatedTime = 1;
                }

                principlePendingWithMonths.replace(amount, time, updatedTime);
            });
            System.out.println("Monthly interest of the month of " + i + ": " + monthlyInterest);
        }

        System.out.println("Total interest is: " + totalInterest);
        System.out.println("Total Principle is: " + totalPrinciple);

        for (Integer integer : principlePendingWithMonths.keySet()) {
            //System.out.println(i);
            System.out.println(integer);
        }

        getPrinciple();
    }

    private static float calculateAndGetInterest(int p, int timeInMonths) {
        return  (p * interestRate * timeInMonths)/1200;
    }

    private static int disbursedByBank(int demand, int selfPaid) {
        return demand - selfPaid;
    }

    private static int monthForPendingPrinciple(int index) {
        return 3 * index;
    }

    private static void getPrinciple() {
        int totalDemandsByBuilder = 0;
        int totalGivenValue = 0;
        for (int i = 0; i < demands.size(); i++) {
            totalDemandsByBuilder += demands.get(i);
            totalGivenValue += paidAmount.get(i);
        }

        System.out.println("Total demand is: " + totalDemandsByBuilder);
        System.out.println("Total paid amount is: " + totalGivenValue);
        System.out.println("Total remaining amount is: " + (totalDemandsByBuilder - totalGivenValue));
    }

}
