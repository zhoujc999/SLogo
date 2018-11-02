package parsing;

/**
 * 
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <S>
 * @param <W>
 */
@FunctionalInterface
public interface PentaConsumer<T, U, V, S, W> {
    public void accept(T t, U u, V v, S s, W w);
}
