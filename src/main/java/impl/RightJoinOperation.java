package impl;

import interfaces.JoinOperation;
import row.DataRow;
import row.JoinedDataRow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class RightJoinOperation<K, V> implements JoinOperation<DataRow<K, V>, DataRow<K, V>, JoinedDataRow<K, V, V>> {
    @Override
    public Collection<JoinedDataRow<K, V, V>> join(Collection<DataRow<K, V>> leftCollection,
                                                   Collection<DataRow<K, V>> rightCollection) {

        ArrayList<JoinedDataRow<K, V, V>> resultJoinedDataRow = new ArrayList<>();

        rightCollection.forEach(rightDataRow -> {
            Optional<DataRow<K, V>> leftDataRow = leftCollection.stream()
                    .filter(dataRow -> rightDataRow.key.equals(dataRow.key))
                    .findFirst();

            if (leftDataRow.isPresent()) {
                resultJoinedDataRow.add(new JoinedDataRow<>(rightDataRow.key,
                        leftDataRow.get().value,
                        rightDataRow.value));
            } else {
                resultJoinedDataRow.add(new JoinedDataRow<>(rightDataRow.key,
                        null,
                        rightDataRow.value));
            }
        });

        return resultJoinedDataRow;
    }
}
