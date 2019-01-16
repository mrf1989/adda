package pi2.ejercicio78;

import java.util.List;

public class Metodos78 {
	
	/**
	 * 
	 * Busca la cadena String en la lista ordenada y devuelve el índice de su posición.
	 * En caso de no encontrarse devuelve -1.
	 * @param ls Lista ordenada cadenas String.
	 * @param str String a buscar en la lista ls.
	 * @return int
	 */
	public static int buscaPalabra(List<String> ls, String str) {
		return buscaPalabraGen(ls, str, 0, ls.size());
	}

	private static int buscaPalabraGen(List<String> ls, String str, int i, int j) {
		int res;
		
		int c1 = i + (j - i) / 3;
		int c2 = i + 2 * (j - i) / 3;
		
		if (j - i == 0) {
			res = -1;
		} else if (str == ls.get(c1)) {
			res = c1;
		} else if (str == ls.get(c2)) {
			res = c2;
		} else {
			if (str.compareTo(ls.get(c1)) < 0) {
				j = c1;
			} else if (str.compareTo(ls.get(c2)) < 0) {
				i = c1 + 1;
				j = c2;
			} else {
				i = c2 + 1;
			}
			
			res = buscaPalabraGen(ls, str, i, j);
		}
		
		return res;
	}
	
}
