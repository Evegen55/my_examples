package guava;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import com.google.common.math.BigIntegerMath;
import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.common.net.InternetDomainName;
import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedLong;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URL;
import java.util.List;

import static com.google.common.io.CharStreams.readLines;
import static java.math.RoundingMode.CEILING;
import static java.math.RoundingMode.FLOOR;
import static org.junit.Assert.assertTrue;

/**
 * @author Evgenii_Lartcev on 9/29/2016.
 */
public class TestFeautures {

    /**
     * @see <a href="https://github.com/google/guava/wiki/IOExplained">IOExplained</a>
     * @throws IOException when try to read non-exist file
     */
    @Test
    public void test() throws IOException {
        List<String> list = readLines(new FileReader(new File("src/test/resources/warAndPeace.txt")));
        list.forEach(System.out::println);
        System.out.println("nums of lines in the file" + "\t" + list.size());
    }

    /**
     * @see <a href="https://github.com/google/guava/wiki/MathExplained">MathExplained</a>
     */
    @Test
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

    /**
     * @see <a href="http://google.github.io/guava/releases/snapshot/api/docs/com/google/common/primitives/UnsignedInteger.html">
     *     UnsignedInteger</a>
     */
    @Test
    public void testPrimitivesExplained() {
        int maxSigned = Integer.MAX_VALUE;
        System.out.println(maxSigned);
        //by google
        int maxUnigned = UnsignedInteger.MAX_VALUE.intValue();
        System.out.println(maxUnigned);
        System.out.println(UnsignedInteger.MAX_VALUE.longValue());
        System.out.println(UnsignedInteger.MAX_VALUE);
        System.out.println(UnsignedInteger.ONE);
        System.out.println(UnsignedInteger.ZERO);
        System.out.println(UnsignedInteger.fromIntBits(0101010101)); //good job! (Returns an UnsignedInteger corresponding to a given bit representation.)

        long maxSignedLong = Long.MAX_VALUE;
        System.out.println("long max value" + "\t" + maxSignedLong);
        //by google
        System.out.println("long max value" + "\t" + UnsignedLong.MAX_VALUE);
        System.out.println(UnsignedLong.fromLongBits(0101010101));
    }

    /**
     * @see <a href="https://github.com/google/guava/wiki/MathExplained">MathExplained</a>
     */
    @Test(expected = ArithmeticException.class)
    public void testMath() {
        IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /**
     * @see <a href="https://github.com/google/guava/wiki/InternetDomainNameExplained">InternetDomainNameExplained</a>
     */
    @Test
    public void testInternetDomainNameExplained() {
        InternetDomainName owner = InternetDomainName.from("mail.google.com").topPrivateDomain();
        System.out.println(owner);
    }

    @Test
    public void testIOExplained() throws IOException {
        // SHA-1 a file
        File file = new File("src/test/resources/warAndPeace.txt");
        HashCode hashSHA1 = Files.asByteSource(file).hash(Hashing.sha1());
        System.out.println(hashSHA1);
        HashCode hashCRC32 = Files.asByteSource(file).hash(Hashing.crc32());
        System.out.println(hashCRC32);

        // Copy the data from a URL to a file
        URL url = new URL("ftp://ftp-trace.ncbi.nih.gov/1000genomes/ftp/phase3/data/HG00105/alignment/HG00105.unmapped.ILLUMINA.bwa.GBR.low_coverage.20130415.bam.bai");
        File fileJava = new File("src/test/resources/20130415.bam.bai");
        fileJava.deleteOnExit();
        Resources.asByteSource(url).copyTo(Files.asByteSink(fileJava));
        assertTrue(fileJava.exists());

    }




}
