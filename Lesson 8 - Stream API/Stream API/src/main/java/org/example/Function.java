package src.main.java.org.example;

@FunctionalInterface
public interface Function<T, R> {

    R map(T t);
}
