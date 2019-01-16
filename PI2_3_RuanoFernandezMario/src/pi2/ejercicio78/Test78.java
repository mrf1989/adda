package pi2.ejercicio78;

import java.util.Arrays;
import java.util.List;

public class Test78 {

	public static void main(String[] args) {
		String[] words = {"amor", "balance", "carisma", "dolor", "energía", "fuerza", "gentileza",
				"honor", "inteligencia", "juicio", "karma", "lealtad", "misión", "negación", "oleada",
				"piedad", "querer", "razón", "saber", "tesón", "UBER", "valor", "wolframio", "zoo"};
		
		List<String> ls = Arrays.asList(words);
		
		// Test 1. Buscar palabra que no aparece en la lista
		System.out.println("Test 1: buscar palabra ñ: " + Metodos78.buscaPalabra(ls, "ñ"));
		// Test 2. Buscar palabra del extremo inicial de la lista
		System.out.println("Test 2: buscar palabra amor: " + Metodos78.buscaPalabra(ls, "amor"));
		// Test 3. Buscar palabra del extremo final de la lista
		System.out.println("Test 3: buscar palabra zoo: " + Metodos78.buscaPalabra(ls, "zoo"));
		// Test 4. Buscar palabra cualquiera
		System.out.println("Test 4: buscar palabra karma: " + Metodos78.buscaPalabra(ls, "karma"));

	}

}
