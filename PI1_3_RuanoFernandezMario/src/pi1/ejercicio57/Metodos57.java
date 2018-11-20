package pi1.ejercicio57;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * 
 * @author Mario Ruano Fernández
 *
 */
public class Metodos57 {
	
	/**
	 * 
	 * Obtiene el String con mayor número de caracteres minúsculas de una lista.
	 * Este método ofrece la solución iterativa del problema 57 (1.1).
	 * @param ls Lista de cadenas de caracteres.
	 * @throws NoSuchElementException Se lanza una excepción en caso de que la lista esté
	 *         vacía y no pueda devolverse ningún String.
	 * @return String.
	 */
	public static String mayorNumCharMinus(List<String> ls) {
		int i = 0;
		int max = 0;
		String str = null;
		
		while (i < ls.size()) {
			String ac = ls.get(i);
			Integer numMinus = numMinusculas(ac);
				
			if (numMinus > max) {
				max = numMinus;
				str = ac;
			}
				
			i++;
		}
			
		if (str == null && ls.size() > 0) {
			throw new NoSuchElementException("Ningún elemento de la lista cumple con las condiciones del problema.");
		} else if (str == null) {
			throw new NoSuchElementException("La lista está vacía.");
		}
			
		return str;
	}
	
	/**
	 * 
	 * Método auxiliar iterativo que calcula el número de caracteres en minúsculas de un String.
	 * @see #mayorNumCharMinus
	 * @param str Cadena de caracteres.
	 * @return Integer
	 */
	private static Integer numMinusculas(String str) {
		Integer i = 0;
		Integer res = 0;
		
		while (i < str.length()) {
			
			if (Character.isLowerCase(str.charAt(i))) {
				res++;
			}
			
			i++;
		}
		
		return res;
	}
	
	/**
	 * 
	 * Obtiene el String con mayor número de caracteres minúsculas de una lista.
	 * Este método ofrece la solución funcional del problema 57 (1.1).
	 * @param ls Lista de cadenas de caracteres.
	 * @throws NoSuchElementException Se lanza una excepción en caso de que la lista esté
	 *         vacía y no pueda devolverse ningún String.
	 * @return String.
	 */
	public static String mayorNumCharMinusJava10(List<String> ls) {
		String str = ls.stream()
				.filter(x -> numMinusculasJava10(x) > 0)
				.max(Comparator.comparing(x -> numMinusculasJava10(x)))
				.orElse(null);
		
		if (str == null && ls.size() > 0) {
			throw new NoSuchElementException("Ningún elemento de la lista cumple con las condiciones del problema.");
		} else if (str == null) {
			throw new NoSuchElementException("La lista está vacía.");
		}
		
		return str;
	}
	
	/**
	 * 
	 * Método auxiliar funcional que calcula el número de caracteres en minúsculas de un String.
	 * @see #mayorNumCharMinusJava10
	 * @param str Cadena de caracteres.
	 * @return Integer
	 */
	public static Integer numMinusculasJava10(String str) {
		return (int) Stream.iterate(0, x -> x < str.length(), x -> x + 1)
				.map(x -> str.charAt(x))
				.filter(x -> Character.isLowerCase(x))
				.count();
	}
	
	/**
	 * 
	 * Obtiene el String con mayor número de caracteres minúsculas de una lista.
	 * Este método ofrece una solución recursiva del problema 57 (1.1).
	 * @param ls Lista de cadenas de caracteres.
	 * @return String.
	 */
	public static String mayorNumCharMinusRecursivo(List<String> ls) {
		return mayorNumCharMinusRecursivoGen(ls, 0, 0, null);
	}
	
	private static String mayorNumCharMinusRecursivoGen(List<String> ls, int i, int max, String str) {
		if (i < ls.size()) {
			int numMinus = numMinusculasRec(ls.get(i));
			if (numMinus > max) {
				max = numMinus;
				str = mayorNumCharMinusRecursivoGen(ls, i + 1, max, ls.get(i));
			}
			str = mayorNumCharMinusRecursivoGen(ls, i + 1, max, str);
		}
		
		if (str == null && ls.size() > 0) {
			throw new NoSuchElementException("Ningún elemento de la lista cumple con las condiciones del problema.");
		} else if (str == null) {
			throw new NoSuchElementException("La lista está vacía.");
		}
		
		return str;
	}
	
	/**
	 * 
	 * Método auxiliar recursivo que calcula el número de caracteres en minúsculas de un String.
	 * @see #mayorNumCharMinusRecursivo
	 * @param str Cadena de caracteres.
	 * @return Integer
	 */
	private static Integer numMinusculasRec(String str) {
		return numMinusculasRecGen(str, 0, 0);
	}
	
	private static Integer numMinusculasRecGen(String str, Integer i, Integer ac) {
		if (i < str.length()) {
			char c = str.charAt(i);
			if (Character.isLowerCase(c)) {
				ac = numMinusculasRecGen(str, i+1, ac+1);
			} else {
				ac = numMinusculasRecGen(str, i+1, ac);
			}
		}
		
		return ac;
	}

}
