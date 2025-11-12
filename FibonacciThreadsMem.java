import java.util.Hashtable;

public class FibonacciThreadsMem implements Runnable {

    private long fi;
    private int num;
    private static final Hashtable<Long, Long> memoria = new Hashtable<>();

    public FibonacciThreadsMem(int n, long f) {
        num = n;
        fi = f;
    }

    @Override
    public void run() {
        System.out.println("Starte #" + num);
        long res = fibonacci(fi);
        System.out.println("Abschlussverfahren: " + num +
                " - " + "fibonacci(" + fi + ") = " + res);
    }

    // Método recursivo con memoria (memoization)
    private long fibonacci(long f) {
        // Verificar si el valor ya está guardado
        if (memoria.containsKey(f)) {
            return memoria.get(f);
        }

        long resultado;

        if (f < 2) {
            resultado = 1;
        } else {
            resultado = fibonacci(f - 1) + fibonacci(f - 2);
        }

        // Guardar el resultado en la Hashtable antes de devolverlo
        memoria.put(f, resultado);
        return resultado;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new FibonacciThreadsMem(i,
                    (long) (Math.random() * 50) + 1));
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

