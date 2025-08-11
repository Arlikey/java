package generic;

import generic.atm.ATM;
import generic.atm.Bank;
import generic.atm.exceptions.ATMException;
import generic.matrix.Matrix;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //matrix();

        atm();
    }

    private static void matrix(){
        Integer[][] arr1 = new Integer[3][3];
        Integer[][] arr2 = new Integer[3][3];

        Matrix<Integer> m1 = new Matrix<>(arr1, Integer.class);
        Matrix<Integer> m2 = new Matrix<>(arr2, Integer.class);

        try{
            m2.setMatrix(new Integer[4][4]);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        m1.randomInit();
        m2.randomInit();

        System.out.println("Matrix 1:");
        m1.print();

        System.out.println("\nMatrix 2:");
        m2.print();

        System.out.println("\nMatrix sum:");
        Matrix<Integer> sum = m1.add(m2);
        sum.print();

        System.out.println("\nMatrix subtract:");
        Matrix<Integer> diff = m1.subtract(m2);
        diff.print();

        System.out.println("\nMax sequence in rows of Matrix 1:");
        int[] seq = m1.findMaxSequenceInRows();
        for (int i = 0; i < seq.length; i++) {
            System.out.println("Row " + i + ": " + seq[i]);
        }

        System.out.println("\nAverage of main diagonal 1: " + m1.averageMainDiagonal());

        int cmp = m1.compareTo(m2);
        System.out.print("\nMatrix 1 in compare to Matrix 2: ");
        System.out.println(cmp);
    }

    private static void atm(){
        ATM atm1 = new ATM(10, 20);
        ATM atm2 = new ATM(10, 20);

        atm1.loadCash(Arrays.asList(
                100,100,100,100,100,100,100,100,100,100,
                50,50,50,50,50,50,50,50,50,50,
                20,20,20,20,20,20,20,20,20,20
        ));

        atm2.loadCash(Arrays.asList(
                500,500,500,500,500,
                200,200,200,200,200
        ));

        Bank bank = new Bank(Arrays.asList(atm1, atm2));

        System.out.println("Total cash in bank network: " + bank.getTotalCashInNetwork());

        try {
            List<Integer> dispensed = atm1.withdraw(65400);
            System.out.println("Dispensed from ATM1: " + dispensed);
        } catch (ATMException e) {
            System.out.println("Error during withdrawal from ATM1: " + e.getMessage());
        }

        try {
            List<Integer> dispensed = atm1.withdraw(200);
            System.out.println("Dispensed from ATM1: " + dispensed);
        } catch (ATMException e) {
            System.out.println("Error during withdrawal from ATM1: " + e.getMessage());
        }

        System.out.println("Total cash after withdrawal: " + bank.getTotalCashInNetwork());
    }
}

