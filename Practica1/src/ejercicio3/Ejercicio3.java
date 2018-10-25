package ejercicio3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicio3 {
	
	public final static String CADENA = "Hola Mundo!";
	
	// Solución iterativa (while)
	public static String invertirString(String str) {
		String res = "";
		int i = str.length() - 1;

		while (i >= 0) {
			res = res + str.charAt(i);
			i--;
		}
		
		return res;
	}
	
	// Solución funcional con Java 8 (Stream)
	public static String invertirStringFuncional(String str) {
		return IntStream.rangeClosed(1, str.length())
				.boxed()
				.map(i -> String.valueOf(str.charAt(str.length() - i)))
				.collect(Collectors.joining());
	}
	
	public static void main(String[] args) {
		System.out.println("Test Ejercicio3");
		System.out.println("===============");
		System.out.println("- While (Java):");
		System.out.println("Cadena original: " + CADENA + " / Cadena invertida: " + Ejercicio3.invertirString(CADENA));
		System.out.println("- Stream (Java 8):");
		System.out.println("Cadena original: " + CADENA + " / Cadena invertida: " + Ejercicio3.invertirStringFuncional(CADENA));
	}
	
}
