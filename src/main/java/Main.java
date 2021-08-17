import impl.InnerJoinOperation;
import impl.LeftJoinOperation;
import impl.RightJoinOperation;
import row.DataRow;

import java.util.ArrayList;

public class Main {

    private static final InnerJoinOperation<Integer, String> innerJoinOperation = new InnerJoinOperation<>();
    private static final LeftJoinOperation<Integer, String> leftJoinOperation = new LeftJoinOperation<>();
    private static final RightJoinOperation<Integer, String> rightJoinOperation = new RightJoinOperation<>();

    public static void main(String[] args) {
        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "German"));
        leftCollection.add(new DataRow<>(2, "France"));

        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));

        System.out.println("Left collection: " + leftCollection);
        System.out.println("Right collection: " + rightCollection);
        System.out.println();

        System.out.println("Inner Join collection " + innerJoinOperation.join(leftCollection, rightCollection));
        System.out.println("Left Join collection " + leftJoinOperation.join(leftCollection, rightCollection));
        System.out.println("Right Join collection " + rightJoinOperation.join(leftCollection, rightCollection));
    }
}
