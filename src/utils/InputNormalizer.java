package utils;

import lombok.Data;
import utils.exceptions.InvalidOperatorException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public final class InputNormalizer {

    private static final int OPERATOR_OFFSET = 2;
    private static final int NEXT_OPERATORS_OFFSET = 3;

    public static OperationOverList normalizeInput(String[] args) throws InvalidOperatorException {

        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            List<Operation> operations = new ArrayList<>();
            for(int i = OPERATOR_OFFSET;  i <= args.length -2; i = i + NEXT_OPERATORS_OFFSET){
                int[] ijk = new int[3];
                ijk[0] = Integer.parseInt(args[i]);
                ijk[1] = Integer.parseInt(args[i + 1]);
                ijk[2] = Integer.parseInt(args[i + 2]);
                Operation operation = new Operation(ijk, x);
                operations.add(operation);
            }
            return new OperationOverList(x, y, operations);
        } catch (NumberFormatException e){
            throw new NumberFormatException("Was not possible parse String arguments to int");
        }
    }

    public static OperationOverList normalizeInput(String filePath) throws IOException, InvalidOperatorException {

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            String[] firstLine = line.split(" ");
            int x = Integer.parseInt(firstLine[0]);
            int y = Integer.parseInt(firstLine[1]);
            List<Operation> operations = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                int[] ijk = new int[3];
                String[] readLine = line.split(" ");
                ijk[0] = Integer.parseInt(readLine[0]);
                ijk[1] = Integer.parseInt(readLine[1]);
                ijk[2] = Integer.parseInt(readLine[2]);
                Operation operation = new Operation(ijk, x);
                operations.add(operation);
            }
            return new OperationOverList(x, y, operations);
        } catch (NumberFormatException e){
            throw new NumberFormatException("Was not possible parse String arguments to int");
        } catch (FileNotFoundException e) {
            throw new IOException("File Could Not Be Found");
        }
    }

}