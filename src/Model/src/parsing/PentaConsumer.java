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
<<<<<<< HEAD
    /**
     * This method accepts the corresponding objects. It executes a block of code that is created when you call execute in the Command Objects
     * @param t Parser p
     * @param u TreeExecutor t
     * @param v VariableManipulator
     * @param s ParameterChangeInterface pci
     * @param w Invokable inv
     */
=======
>>>>>>> parent of 3d09264... added docs
    public void accept(T t, U u, V v, S s, W w);
}
