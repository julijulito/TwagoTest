package utils;

import org.apache.commons.lang.ArrayUtils;
import utils.exceptions.InvalidOperatorException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OperationOverList {

    private static final String X_CONSTRAIN = "3 <= X <= 10^7";
    private static final String Y_CONSTRAIN = "1 <= Y <= 2*10^5";

    private static final String X_CONSTRAIN_ERR_MSG =
            "Limiter x = %s does not match with constrain: " + X_CONSTRAIN;
    private static final String Y_CONSTRAIN_ERR_MSG =
            "Limiter y = %s does not match with constrain: " + Y_CONSTRAIN;

    private static final int MIN_X_VALUE = 3;
    private static final int MAX_X_VALUE = 10000000;
    private static final int MIN_Y_VALUE = 1;
    private static final int MAX_Y_VALUE = 200000;


    private final List<Operation> operations;
    private final int[] outputList;

    public OperationOverList(
        int x,
        final int y,
        final List<Operation> operations
    ) throws InvalidOperatorException {

        if ( ! (MIN_X_VALUE <= x && x <= MAX_X_VALUE)) {
            throw new InvalidOperatorException(String.format(X_CONSTRAIN_ERR_MSG, x));
        }
        if ( ! (MIN_Y_VALUE <= y && y <= MAX_Y_VALUE)) {
            throw new InvalidOperatorException(String.format(Y_CONSTRAIN_ERR_MSG, y));
        }
        this.operations = operations;
        this.outputList = new int[x];
    }

    public void printMaximumNumber(){
        for (Operation op : operations) {
            for(int i = op.getI() - 1; i <= op.getJ() - 1; i++) {
                outputList[i] = outputList[i] + op.getK();
            }
        }
        System.out.println(
                Collections.max(Arrays.asList(ArrayUtils.toObject(outputList)))
        );
    }

}
