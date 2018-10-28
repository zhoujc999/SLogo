package parsing;

public class Pair<L, R> {
    private L myLeft;
    private R myRight;

    public Pair(L left, R right){
        myLeft = left;
        myRight = right;
    }

    public L getLeft() {
        return myLeft;
    }

    public R getRight() {
        return myRight;
    }
}
