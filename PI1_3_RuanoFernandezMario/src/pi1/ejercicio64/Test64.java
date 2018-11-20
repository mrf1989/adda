package pi1.ejercicio64;

import java.util.Arrays;
import java.util.List;

public class Test64 {

	public static void main(String[] args) {
		
		Integer[] arr1 = {3, 40, 80, 81, 82, 83, 90};
		Integer[] arr2 = {1, 2, 3, 4, 6, 20, 21, 30, 32, 60};
		List<Integer> ls1 = Arrays.asList(arr1);
		List<Integer> ls2 = Arrays.asList(arr2);
		
		/*
		 * TEST. Caso 1 (iterativo): Fusión en orden de dos listas ordenadas.
		 */
		try {
			System.out.println("Test 1 del ejercicio 1.4 (64): Fusión en orden de dos listas ordenadas (iterativo).");
			System.out.println("- Lista fusionada ordenada: " + Metodos64.fusionListWhile(ls1, ls2));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 2 (funcional): Fusión en orden de dos listas ordenadas.
		 */
		try {
			System.out.println("Test 2 del ejercicio 1.4 (64): Fusión en orden de dos listas ordenadas (funcional).");
			System.out.println("- Lista fusionada ordenada: " + Metodos64.fusionListJava10(ls1, ls2));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");
		
		/*
		 * TEST. Caso 3 (recursivo): Fusión en orden de dos listas ordenadas.
		 */
		try {
			System.out.println("Test 3 del ejercicio 1.4 (64): Fusión en orden de dos listas ordenadas (recursivo).");
			System.out.println("- Lista fusionada ordenada: " + Metodos64.fusionListRec(ls1, ls2));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("");

	}

}
