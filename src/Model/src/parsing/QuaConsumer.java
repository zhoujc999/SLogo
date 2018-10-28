package parsing;

@FunctionalInterface
public interface QuaConsumer<T, U, V, S> {
    public void accept(T t, U u, V v, S s);
}
