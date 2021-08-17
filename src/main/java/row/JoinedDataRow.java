package row;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class JoinedDataRow<K, V1, V2> {
    public K key;
    public V1 valueOne;
    public V2 valueSecond;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinedDataRow<?, ?, ?> that = (JoinedDataRow<?, ?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(valueOne, that.valueOne) && Objects.equals(valueSecond, that.valueSecond);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, valueOne, valueSecond);
    }

    @Override
    public String toString() {
        return "{" +key + ", " + valueOne + ", " + valueSecond + "}";

    }

}
