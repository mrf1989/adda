package ejercicios;

import java.util.ArrayList;
import java.util.List;

import punto.Punto;

public class Recursivos {
	
	// Ejercicio 1
	public static Double sumaDoubleList(List<Double> ls) {
		return sumaDoubleList(ls, ls.size(), 0.0);
	}	

	private static Double sumaDoubleList(List<Double> ls, int n, Double a) {
		Double r;
		if (n == 0) {
			r = a;
		} else if (n == 1) {
			r = a + ls.get(n - 1);
		} else {
			r = sumaDoubleList(ls, n - 1, a + ls.get(n - 1));
		}
		return r;
	}
	
	// Ejercicio 2
	public static List<Double> coordX(List<Punto> ls) {
		List<Double> res = new ArrayList<>();
		return coordX(ls, 0, res);
	}

	private static List<Double> coordX(List<Punto> ls, int n, List<Double> a) {
		List<Double> r; 
		if (ls.size() == 0) {
			r = new ArrayList<>();
		} else if (n == ls.size() - 1) {
			a.add(ls.get(n).getX());
			r = a;
		} else {
			a.add(ls.get(n).getX());
			r = coordX(ls, n + 1, a);
		}
		return r;
	}
	
	// Ejercicio 3
	public static Boolean sonImpares(List<Integer> ls) {
		return sonImpares(ls, 0, true);
	}

	private static Boolean sonImpares(List<Integer> ls, int n, Boolean b) {
		if (b) {
			if (ls.size() == 0) {
				b = false;
			} else if (n == ls.size() - 1) {
				b = ls.get(n) % 2 != 0;
			} else {
				b = sonImpares(ls, n + 1, ls.get(n) % 2 != 0);
			}	
		}
		return b;
	}
	
	// Ejercicio 4
	public static Boolean algunPrimoImpar(List<Integer> ls) {
		return algunPrimoImpar(ls, 0, false);
	}
	
	private static Boolean algunPrimoImpar(List<Integer> ls, int n, Boolean b) {
		if (!b) {
			if (ls.size() == 0) {
				b = false;
			} else if (ls.size() - n == 1) {
				b = ls.get(n) % 2 != 0 && Iterativos.esPrimo((long) ls.get(n));
			} else {
				b = algunPrimoImpar(ls, n + 1, ls.get(n) % 2 != 0 && Iterativos.esPrimo((long) ls.get(n)));
			}
		}
		return b;
	}
	
	// Ejercicio 6
	public static Double buscarMayorA(List<Double> ls, Double n) {
		return buscarMayorA(ls, n, 0, false, null);
	}
	
	private static Double buscarMayorA(List<Double> ls, Double n, int i, Boolean b, Double r) {
		if (!b) {
			if (i == ls.size() - 1 && ls.get(i) > n) {
				r = ls.get(i);
			} else if (i < ls.size()) {
				r = buscarMayorA(ls, n, i + 1, ls.get(i) > n, ls.get(i));
			} else {
				r = -1.;
			}
		}
		return r;
	}
	
}
