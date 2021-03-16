package javatutorial.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class functional {

    public static void main(String[] args) {
        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> safeDivide =
            func -> (x, y) -> {
                if (y == 0f) {
                    System.out.println("Divide by zero...");
                    return 0f;
                }
                return func.apply(x, y);
            };

        System.out.println(safeDivide.apply(divide).apply(4f, 0f));
    }
}
