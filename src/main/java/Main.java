import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        method();
    }

    private static void method() {

        int n = 2124680;
        long startTime = System.currentTimeMillis();
        boolean primes[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            primes[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            if(primes[p])
            {
                for(int i = p*2; i <= n; i += p)
                    primes[i] = false;
            }
        }

        BigInteger  numerator = BigInteger.ONE;;
        BigInteger denominator = BigInteger.ONE;
        BigInteger numeratorPrev ;
        List<BigInteger> wolstenholmePrimes = new ArrayList<BigInteger>();
        int lastPrimeNumber =1;
        for (int i = 3; i <=n; i +=2) {
            if (primes[i]) {


                BigInteger prime = BigInteger.valueOf(i);
                for (int j = lastPrimeNumber; j < i; j++) {
                    BigInteger currentNumber = BigInteger.valueOf(j);
                    BigInteger lcm = (denominator.multiply(currentNumber)).divide(denominator.gcd(currentNumber));
                    numeratorPrev = numerator;
                    if(j>1) {
                        numerator = numeratorPrev.multiply(lcm.divide(denominator)).add(lcm.divide(currentNumber));
                    }
                    denominator = lcm;

                }


                BigInteger mod = numerator.mod(prime.pow(3));

                if (mod.equals(BigInteger.ZERO)) {

                    wolstenholmePrimes.add(BigInteger.valueOf(i));
                    System.out.println(i);
                }
                lastPrimeNumber=i;
            }
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }
}


