package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.math.Math2;

public class Ejercicio1 {

	// Solución iterativa (while)
	public static List<Integer> primosCuadradosIterativo(Integer n) {
		List<Integer> res = new ArrayList<>();
		Integer p = 2;
		
		while (p <= n) {
			if (Math2.esPrimo(p)) {
				res.add(p * p);
			}
			p++;
		}
		
		return res;
	}

	// Solución funcional con Java 8 (Stream)
	public static List<Integer> primosCuadradosFuncional(Integer n) {
		return IntStream.rangeClosed(2, n)
			.filter(x -> Math2.esPrimo(x))
			.map(x -> x * x)
			.boxed()
			.collect(Collectors.toList());
	}
	
	// Solución recursiva
	public static List<Integer> primosCuadradosRecursivo(Integer n) {
		return primosRecursivosAux(2, n, new ArrayList<>());
	}

	private static List<Integer> primosRecursivosAux(int i, Integer n, List<Integer> lista) {
		List<Integer> res = new ArrayList<>();
		
		if (i > n) {
			res = lista;
		} else {
			if (Math2.esPrimo(i)) {
				lista.add(i*i);
			}
			res = primosRecursivosAux(i+1, n, lista);
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println("Cuadrados de todos los primos hasta el número 29: " + primosCuadradosIterativo(29));
		System.out.println("Cuadrados de todos los primos hasta el número 29: " + primosCuadradosFuncional(29));
		System.out.println("Cuadrados de todos los primos hasta el número 29: " + primosCuadradosRecursivo(29));

	}

}
