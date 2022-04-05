import utils.InputNormalizer;
import utils.OperationOverList;
import utils.exceptions.InvalidOperatorException;

import java.io.IOException;

public class TwagoTest {

    public static void main(String[] args) throws InvalidOperatorException, IOException {

        OperationOverList normalizer;
        if (args.length == 0) {
            normalizer = InputNormalizer.normalizeInput(args);
        } else {
            normalizer = InputNormalizer.normalizeInput(args[0]);
        }
        normalizer.printMaximumNumber();
    }
}
