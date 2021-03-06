package row;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataRow<K ,V>{
    public K key;
    public V value;

    @Override
    public String toString() {
        return "{" + key + ", " + value + "}";
    }
}
