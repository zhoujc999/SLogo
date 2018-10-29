package parsing;

@FunctionalInterface
public interface PentaConsumer<T, U, V, S, W> {
    public void accept(T t, U u, V v, S s, W w);
}
