import java.util.Hashtable;
import java.util.Scanner;

public class MainMiFiboHash {

    // Tabla hash para guardar resultados ya calculados
    static Hashtable<Integer, Long> memo = new Hashtable<>();

    // Función recursiva de Fibonacci con memoización
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        // Si ya está calculado, lo obtenemos directamente
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Si no, lo calculamos y guardamos en la tabla
        long valor = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, valor);

        return valor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la posición n para calcular Fibonacci(n): ");
        int n = sc.nextInt();

        long resultado = fibonacci(n);

        System.out.println("\nFibonacci(" + n + ") = " + resultado);
        System.out.println("Tamaño de la tabla hash: " + memo.size());
        System.out.println("Valores almacenados en memoria: " + memo);

        sc.close();
    }
}

