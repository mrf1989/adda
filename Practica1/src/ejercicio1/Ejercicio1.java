package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicio1 {
	
	public final static Integer NUMERO = 40;
	
	// Solución iterativa (while)
	public static List<Integer> divisoresIterativo(Integer n) {
		List<Integer> res = new ArrayList<>();
		Integer i = 1;
		
		while (i <= n) {
			if (n % i == 0) {
				res.add(i);
			}
			i++;
		}
		
		return res;
	}
	
	// Solución funcional con Java 8 (Stream)
	public static List<Integer> divisoresFuncional(Integer n) {
		return IntStream.rangeClosed(1, n)
				.filter(x -> n % x == 0)
				.boxed()
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		System.out.println("Test Ejercicio1");
		System.out.println("===============");
		System.out.println("- While (Java):");
		List<Integer> ls1 = Ejercicio1.divisoresIterativo(NUMERO);
		System.out.println(ls1);
		System.out.println("- Stream (Java 8):");
		List<Integer> ls2 = Ejercicio1.divisoresFuncional(NUMERO);
		System.out.println(ls2);
	}

}
