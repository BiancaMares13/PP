import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        method();
    }
    private static void method() {
        boolean ok;
        BigInteger numerator;
        BigInteger denominator;
        List<BigInteger> wolstenholmePrimes=new ArrayList<BigInteger>();
        for (int i = 1; i < 4000000; i += 2) {
            ok = true;
            numerator =BigInteger.ONE;
            denominator =BigInteger.ONE;
            for (int d = 2; d <= Math.sqrt(i); d++) {
                if (i % d == 0) {
                    ok = false;
                }
            }
            if (ok) {
                BigInteger numeratorPrev;
                BigInteger prime=BigInteger.valueOf(i);

                for (int j = 2; j < i ; j++) {
                    BigInteger currentNumber=BigInteger.valueOf(j);
                    BigInteger lcm=(denominator.multiply(currentNumber)).divide(denominator.gcd(currentNumber));
                    numeratorPrev=numerator;
                    numerator = numeratorPrev.multiply(lcm.divide(denominator)).add(lcm.divide(currentNumber));
                    denominator = lcm;

                }

                BigInteger mod = numerator.mod(prime.pow(3));

                if( mod.equals(BigInteger.ZERO)){

                   wolstenholmePrimes.add(BigInteger.valueOf(i));
                }

            }
        }
        System.out.println(wolstenholmePrimes.size()+ " size");
        for(int k=0;k<wolstenholmePrimes.size();k++){

            System.out.println(wolstenholmePrimes.get(k));
        }
    }

}
