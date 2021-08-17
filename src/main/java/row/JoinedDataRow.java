package row;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JoinedDataRow<K, V1, V2> {
    public K key;
    public V1 valueOne;
    public V2 valueSecond;

    @Override
    public String toString() {
        return "{" +key + ", " + valueOne + ", " + valueSecond + "}";

    }
}
