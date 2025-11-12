import java.math.BigInteger;
import java.util.Hashtable;

public class FibonacciThreadsBigIntegerMem implements Runnable {

    private BigInteger fi;
    private int num;
    private static final Hashtable<BigInteger, BigInteger> memoria = new Hashtable<>();

    public FibonacciThreadsBigIntegerMem(int n, BigInteger f) {
        num = n;
        fi = f;
    }

    @Override
    public void run() {
        System.out.println("Starte #" + num);
        BigInteger res = fibonacci(fi);
        System.out.println("Abschlussverfahren: " + num +
                " - " + "fibonacci(" + fi + ") = " + res);
    }

    // Fibonacci recursivo con memoria (Hashtable)
    private BigInteger fibonacci(BigInteger f) {
        if (memoria.containsKey(f)) {
            return memoria.get(f);
        }

        BigInteger resultado;
        if (f.compareTo(BigInteger.TWO) < 0) {
            resultado = BigInteger.ONE;
        } else {
            resultado = fibonacci(f.subtract(BigInteger.ONE))
                    .add(fibonacci(f.subtract(BigInteger.TWO)));
        }

        memoria.put(f, resultado);
        return resultado;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            long valor = (long) (Math.random() * 50) + 1;
            threads[i] = new Thread(new FibonacciThreadsBigIntegerMem(i,
                    BigInteger.valueOf(valor)));
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

