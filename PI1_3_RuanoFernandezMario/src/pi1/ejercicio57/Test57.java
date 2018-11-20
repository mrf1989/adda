package pi1.ejercicio57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test57 {
	
	public static void main(String[] args) {
		String[] arr1 = {"TOURMALET", "Armario", "DOLOMITAS", "Esternocleidomastoideo", "Lola", "UDP", "Cañonero"};
		String[] arr2 = {"FINACIACIÓN", "REO", "MILAGRO", "RUTINA", "TALENTO"};
		List<String> ls1 = Arrays.asList(arr1);
		List<String> ls2 = Arrays.asList(arr2);
		List<String> ls3 = new ArrayList<>();
		
		/*
		 * TEST. Caso 1 (iterativo): Lista con cadenas que mezclan mayúsculas y minúsculas.
		 */
		try {
			System.out.println("Test 1 del ejercicio 1.1 (57): Lista con cadenas que mezclan mayúsculas y minúsculas (iterativo).");
			System.out.println("- String con mayor número de minúsculas de la lista introducida: " + Metodos57.mayorNumCharMinus(ls1));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 2 (iterativo): Lista con cadenas que están completamente en mayúsculas.
		 */
		try {
			System.out.println("Test 2 del ejercicio 1.1 (57): Lista con cadenas que están completamente en mayúsuclas (iterativo).");
			System.out.println("- String con mayor número de minúsculas de la lista introducida: " + Metodos57.mayorNumCharMinus(ls2));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 3 (iterativo): Lista vacía.
		 */
		try {
			System.out.println("Test 3 del ejercicio 1.1 (57): Lista vacía (iterativo).");
			System.out.println("- String con mayor número de minúsculas de la lista introducida: " + Metodos57.mayorNumCharMinus(ls3));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 4 (funcional Java 10): Lista con cadenas que mezclan mayúsculas y minúsculas.
		 */
		try {
			System.out.println("Test 4 del ejercicio 1.1 (57): Lista con cadenas que mezclan mayúsculas y minúsculas (funcional).");
			System.out.println("- String con mayor número de minúsculas de la lista introducida: " + Metodos57.mayorNumCharMinusJava10(ls1));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 5 (funcional Java 10): Lista con cadenas que están completamente en mayúsculas.
		 */
		try {
			System.out.println("Test 5 del ejercicio 1.1 (57): Lista con cadenas que están completamente en mayúsculas (funcional).");
			System.out.println("- String con mayor número de minúsculas de la lista introducida: " + Metodos57.mayorNumCharMinusJava10(ls2));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 6 (funcional Java 10): Lista vacía.
		 */
		try {
			System.out.println("Test 6 del ejercicio 1.1 (57): Lista vacía (funcional).");
			System.out.println("- String con mayor número de minúsculas de la lista introducida: " + Metodos57.mayorNumCharMinusJava10(ls3));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 7 (recursivo): Lista con cadenas que mezclan mayúsculas y minúsculas.
		 */
		try {
			System.out.println("Test 7 del ejercicio 1.1 (57): Lista con cadenas que mezclan mayúsculas y minúsculas (recursivo).");
			System.out.println("- String con mayor número de minúsculas de la lista introducida: " + Metodos57.mayorNumCharMinusRecursivo(ls1));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 8 (recursivo): Lista con cadenas que están completamente en mayúsculas.
		 */
		try {
			System.out.println("Test 8 del ejercicio 1.1 (57): Lista con cadenas que están completamente en mayúsculas (recursivo).");
			System.out.println("- String con mayor número de minúsculas de la lista introducida: " + Metodos57.mayorNumCharMinusRecursivo(ls2));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 9 (recursivo): Lista vacía.
		 */
		try {
			System.out.println("Test 9 del ejercicio 1.1 (57): Lista vacía (recursivo).");
			System.out.println("- String con mayor número de minúsculas de la lista introducida: " + Metodos57.mayorNumCharMinusRecursivo(ls3));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");

	}

}
