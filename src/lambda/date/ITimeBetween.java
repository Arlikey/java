package lambda.date;

public interface ITimeBetween<T1, T2> {
    public T2 test(T1 date1, T1 date2);
}