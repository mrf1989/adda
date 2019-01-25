package utiles;

import java.util.List;

public class Listas {
	
	public static <E> void intercambiar(List<E> ls, int a, int b) {
		E tmp = ls.get(a);
		ls.set(a, ls.get(b));
		ls.set(b, tmp);
	}
	
}
