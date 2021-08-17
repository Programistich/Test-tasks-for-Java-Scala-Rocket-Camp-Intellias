package impl;

import interfaces.JoinOperation;
import row.DataRow;
import row.JoinedDataRow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class LeftJoinOperation<K, V> implements JoinOperation<DataRow<K, V>, DataRow<K, V>, JoinedDataRow<K, V, V>> {
    @Override
    public Collection<JoinedDataRow<K, V, V>> join(Collection<DataRow<K, V>> leftCollection,
                                                   Collection<DataRow<K, V>> rightCollection) {
        ArrayList<JoinedDataRow<K, V, V>> resultJoinedDataRow = new ArrayList<>();

        leftCollection.forEach(leftDataRow -> {
            Optional<DataRow<K, V>> rightDataRow = rightCollection.stream()
                    .filter(dataRow -> leftDataRow.key.equals(dataRow.key))
                    .findFirst();

            if (rightDataRow.isPresent()) {
                resultJoinedDataRow.add(new JoinedDataRow<>(leftDataRow.key,
                        leftDataRow.value,
                        rightDataRow.get().value));
            } else {
                resultJoinedDataRow.add(new JoinedDataRow<>(leftDataRow.key,
                        leftDataRow.value,
                        null));
            }
        });

        return resultJoinedDataRow;
    }
}
