public class Pair {
    Object first;
    Object second;

    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    private Object getFirst() {
        return this.first;
    }

    private Object getSecond() {
        return this.second;
    }
}
