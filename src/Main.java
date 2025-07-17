import generic.Matrix;
import interfaces.ACipher;
import interfaces.BCipher;
import interfaces.ICipher;
import oop.*;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Matrix<Integer> matrix = new Matrix<>(new Integer[3][3], Integer.class);
        matrix.randomInit();
        matrix.print();
    }
}