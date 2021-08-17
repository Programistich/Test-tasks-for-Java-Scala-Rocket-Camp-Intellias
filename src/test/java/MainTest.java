import impl.InnerJoinOperation;
import impl.LeftJoinOperation;
import impl.RightJoinOperation;
import org.junit.Assert;
import org.junit.Test;
import row.DataRow;
import row.JoinedDataRow;

import java.util.ArrayList;

public class MainTest {

    private static final InnerJoinOperation<Integer, String> innerJoinOperation = new InnerJoinOperation<>();
    private static final LeftJoinOperation<Integer, String> leftJoinOperation = new LeftJoinOperation<>();
    private static final RightJoinOperation<Integer, String> rightJoinOperation = new RightJoinOperation<>();

    @Test
        public void innerJoinOperationTestOne(){
        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "German"));
        leftCollection.add(new DataRow<>(2, "France"));

        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));


        ArrayList<JoinedDataRow<Integer, String, String>> result = new ArrayList<>();
        result.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        result.add(new JoinedDataRow<>(1, "German", "Berlin"));

        Assert.assertEquals(result, innerJoinOperation.join(leftCollection, rightCollection));
    }

    @Test
    public void innerJoinOperationTestTwo(){
        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "German"));
        leftCollection.add(new DataRow<>(2, "France"));

        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(2, "Budapest"));


        ArrayList<JoinedDataRow<Integer, String, String>> result = new ArrayList<>();
        result.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        result.add(new JoinedDataRow<>(1, "German", "Berlin"));
        result.add(new JoinedDataRow<>(2, "France", "Budapest"));

        Assert.assertEquals(result, innerJoinOperation.join(leftCollection, rightCollection));
    }

    @Test
    public void leftJoinOperationTestOne(){
        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "German"));
        leftCollection.add(new DataRow<>(2, "France"));

        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));

        ArrayList<JoinedDataRow<Integer, String, String>> result = new ArrayList<>();
        result.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        result.add(new JoinedDataRow<>(1, "German", "Berlin"));
        result.add(new JoinedDataRow<>(2, "France", null));

        Assert.assertEquals(result, leftJoinOperation.join(leftCollection, rightCollection));
    }

    @Test
    public void leftJoinOperationTestTwo(){
        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "German"));
        leftCollection.add(new DataRow<>(2, "France"));
        leftCollection.add(new DataRow<>(3, "Hungary"));

        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));

        ArrayList<JoinedDataRow<Integer, String, String>> result = new ArrayList<>();
        result.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        result.add(new JoinedDataRow<>(1, "German", "Berlin"));
        result.add(new JoinedDataRow<>(2, "France", null));
        result.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));

        Assert.assertEquals(result, leftJoinOperation.join(leftCollection, rightCollection));
    }

    @Test
    public void rightJoinOperationTestOne(){
        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "German"));
        leftCollection.add(new DataRow<>(2, "France"));

        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));

        ArrayList<JoinedDataRow<Integer, String, String>> result = new ArrayList<>();
        result.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        result.add(new JoinedDataRow<>(1, "German", "Berlin"));
        result.add(new JoinedDataRow<>(3, null, "Budapest"));

        Assert.assertEquals(result, rightJoinOperation.join(leftCollection, rightCollection));
    }

    @Test
    public void rightJoinOperationTestTwo(){
        ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "German"));
        leftCollection.add(new DataRow<>(2, "France"));
        leftCollection.add(new DataRow<>(3, "Hungary"));

        ArrayList<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));

        ArrayList<JoinedDataRow<Integer, String, String>> result = new ArrayList<>();
        result.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        result.add(new JoinedDataRow<>(1, "German", "Berlin"));
        result.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));

        Assert.assertEquals(result, rightJoinOperation.join(leftCollection, rightCollection));
    }
}
