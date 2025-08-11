package generic.matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix<T extends Number> implements Comparable<Matrix<T>> {
    private T[][] matrix;
    private int cols;
    private int rows;
    private Class<T> type;

    private final Random rand = new Random();

    public Matrix(T[][] matrix, Class<T> type) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException("Matrix cannot be empty");
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.type = type;
    }

    public T[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(T[][] matrix) {
        if (matrix == null || matrix.length != rows || matrix[0].length != cols)
            throw new IllegalArgumentException("Matrix size mismatch");
        this.matrix = matrix;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public void randomInit() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (type == Integer.class) {
                    matrix[i][j] = type.cast(rand.nextInt(-100, 101));
                } else if (type == Double.class) {
                    matrix[i][j] = type.cast(rand.nextDouble() * 200 - 100);
                } else if (type == Float.class) {
                    matrix[i][j] = type.cast((float) rand.nextDouble() * 200 - 100);
                } else if (type == Long.class) {
                    matrix[i][j] = type.cast(rand.nextLong(-100, 101));
                }
            }
        }
    }

    public Matrix<T> add(Matrix<T> other) {
        checkSameSize(other);
        T[][] result = createEmptyMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double sum = matrix[i][j].doubleValue() + other.matrix[i][j].doubleValue();
                result[i][j] = castNumber(sum);
            }
        }
        return new Matrix<>(result, type);
    }

    public Matrix<T> subtract(Matrix<T> other) {
        checkSameSize(other);
        T[][] result = createEmptyMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double diff = matrix[i][j].doubleValue() - other.matrix[i][j].doubleValue();
                result[i][j] = castNumber(diff);
            }
        }
        return new Matrix<>(result, type);
    }

    public int[] findMaxSequenceInRows() {
        int[] result = new int[rows];

        for (int i = 0; i < rows; i++) {
            double max = matrix[i][0].doubleValue();
            for (int j = 1; j < cols; j++) {
                double val = matrix[i][j].doubleValue();
                if (val > max) {
                    max = val;
                }
            }

            int maxSeq = 0, currentSeq = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j].doubleValue() == max) {
                    currentSeq++;
                    if (currentSeq > maxSeq) {
                        maxSeq = currentSeq;
                    }
                } else {
                    currentSeq = 0;
                }
            }
            result[i] = maxSeq;
        }

        return result;
    }

    public double averageMainDiagonal() {
        int n = Math.min(rows, cols);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i].doubleValue();
        }
        return sum / n;
    }

    public void print() {
        for (T[] row : matrix) {
            for (T value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    @Override
    public int compareTo(Matrix<T> o) {
        double thisSum = 0;
        double otherSum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                thisSum += matrix[i][j].doubleValue();
                otherSum += o.matrix[i][j].doubleValue();
            }
        }

        return Double.compare(thisSum, otherSum);
    }

    private void checkSameSize(Matrix<T> other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrix sizes must be equal");
        }
    }

    private T[][] createEmptyMatrix() {
        return (T[][]) new Number[rows][cols];
    }

    private T castNumber(double value) {
        if (type == Integer.class) return (T) Integer.valueOf((int) value);
        if (type == Double.class) return (T) Double.valueOf(value);
        if (type == Float.class) return (T) Float.valueOf((float) value);
        if (type == Long.class) return (T) Long.valueOf((long) value);
        throw new UnsupportedOperationException("Unsupported type");
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                ", cols=" + cols +
                ", rows=" + rows +
                '}';
    }
}
