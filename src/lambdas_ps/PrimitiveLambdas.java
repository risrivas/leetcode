package lambdas_ps;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;

public class PrimitiveLambdas {

    public static void main(String[] args) {
        IntSupplier supplier = () -> 10;
        int i = supplier.getAsInt();
        System.out.println("i = " + i);

        DoubleToIntFunction function = (val) -> (int) Math.floor(val);
        int pi = function.applyAsInt(Math.PI);
        System.out.println("PI = " + pi);
    }

}
