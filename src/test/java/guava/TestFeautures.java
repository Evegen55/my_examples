package guava;

import com.google.common.math.BigIntegerMath;
import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

import static com.google.common.io.CharStreams.readLines;
import static java.math.RoundingMode.CEILING;
import static java.math.RoundingMode.FLOOR;

/**
 * @author Evgenii_Lartcev on 9/29/2016.
 */
public class TestFeautures {

    @Test
    //https://github.com/google/guava/wiki/IOExplained
    public void test() throws IOException {
        List<String> list = readLines(new FileReader(new File("src/test/resources/warAndPeace.txt")));
        list.forEach(System.out::println);
        System.out.println("nums of lines in the file" + "\t" + list.size());
    }

    @Test
    //https://github.com/google/guava/wiki/MathExplained
    public void testMathExplained() {
        long n = 100;
        int logFloor = LongMath.log2(n, FLOOR);

        int x = 3;
        int y = 5;
        int mustNotOverflow = IntMath.checkedMultiply(x, y);

        long knownMultipleOfThree = 9;
        long quotient = LongMath.divide(knownMultipleOfThree, 3, RoundingMode.UNNECESSARY); // fail fast on non-multiple of 3

        double d = 4.5;
        BigInteger nearestInteger = DoubleMath.roundToBigInteger(d, RoundingMode.HALF_EVEN);

        BigInteger sideLength = BigIntegerMath.sqrt(nearestInteger, CEILING);

        System.out.println(logFloor + "\n" + mustNotOverflow + "\n" + quotient + "\n" + nearestInteger + "\n" + sideLength);
    }
}
