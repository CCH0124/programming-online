import import java.math.BigInteger;
public static String addBinary(String a, String b) {
        BigInteger big1,big2;
        String result;
        big1 = new BigInteger(a, 2);
        big2 = new BigInteger(b, 2);
        result = big1.add(big2).toString(2);
        return result;
}
