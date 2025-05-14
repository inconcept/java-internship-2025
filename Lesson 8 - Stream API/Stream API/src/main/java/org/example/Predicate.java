package src.main.java.org.example;

@FunctionalInterface
public interface Predicate<T> {

    boolean check(T t);
}
