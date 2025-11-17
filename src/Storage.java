public class Storage<T> {
    private final T value;
    private final T altValue;

    public Storage(T value, T altValue) {
        this.value = value;
        this.altValue = altValue;
    }

    public T getValue() {
        if (value != null) {
            return value;
        }
        else {
            return altValue;
        }
    }

    public void printValue() {
        System.out.println("Извлеченное значение: " + getValue());
    }

    @Override
    public String toString() {
        return "Storage{value=" + value + ", alternative=" + altValue + "}";
    }
}
