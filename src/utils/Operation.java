package utils;

import lombok.Data;
import utils.exceptions.InvalidOperatorException;

@Data
public class Operation {

    private static final int I_J_MIN_VALUE = 1;
    private static final int K_MIN_VALUE = 0;
    private static final int K_MAX_VALUE = 1000000000;

    private static final String I_J_CONSTRAIN_ERR_MSG = "1 <= i <= j <= X";
    private static final String K_CONSTRAIN_ERR_MSG = "0 <= k <= 10^9";

    private static final String I_J_VALIDATION_ERR_MSG =
            "index i = %s and index j = %s with x = %s do not match the following constrain: " + I_J_CONSTRAIN_ERR_MSG;
    private static final String K_VALIDATION_ERR_MSG =
            "index k = %s does not match the following constraing: " + K_CONSTRAIN_ERR_MSG;

    private final int i;
    private final int j;
    private final int k;

    public Operation(int[] operator, final int x) throws InvalidOperatorException {
        this.i = operator[0];
        this.j = operator[1];
        this.k = operator[2];
        if( ! (I_J_MIN_VALUE <= i &&  i <= j  && j <= x)) {
            throw new InvalidOperatorException(String.format(I_J_VALIDATION_ERR_MSG, i, j ,x));
        }
        if( ! (K_MIN_VALUE <= k && k <= K_MAX_VALUE)) {
            throw new InvalidOperatorException(String.format(K_VALIDATION_ERR_MSG, k));
        }
    }

}
