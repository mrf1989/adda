package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import punto.Cuadrante;
import punto.Punto;
import punto.PuntoImpl;

public class Recursivos {
	
	// Ejercicio 1
	public static Double sumaReales(List<Double> ls) {
		return sumaReales(ls, ls.size(), 0.0);
	}	

	private static Double sumaReales(List<Double> ls, int n, Double a) {
		Double r;
		if (n == 0) {
			r = a;
		} else if (n == 1) {
			r = a + ls.get(n - 1);
		} else {
			r = sumaReales(ls, n - 1, a + ls.get(n - 1));
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
	
	// Ejercicio 5
	public static Integer sumaCuadrados(List<Integer> ls) {
		return sumaCuadrados(ls, 0, 0);
	}
	
	private static Integer sumaCuadrados(List<Integer> ls, int n, Integer a) {
		Integer r;
		if (ls.size() - n == 0) {
			r = a;
		} else if (ls.size() - n == 1) {
			r = a + (ls.get(n) * ls.get(n));
		} else {
			r = sumaCuadrados(ls, n + 1, a + ls.get(n) * ls.get(n));
		}
		return r;
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
				r = null;
			}
		}
		return r;
	}
	
	// Ejercicio 7
	public static List<Punto> simetriaY(List<Punto> ls) {
		return simetriaY(ls, 0, new ArrayList<>());
	}
	
	private static List<Punto> simetriaY(List<Punto> ls, int n, List<Punto> a) {
		if (ls.size() - n == 0) {
		} else if (ls.size() - n == 1) {
			Punto p = new PuntoImpl(0 - ls.get(n).getX(), ls.get(n).getY());
			a.add(p);
		} else {
			Punto p = new PuntoImpl(0 - ls.get(n).getX(), ls.get(n).getY());
			a.add(p);
			simetriaY(ls, n + 1, a);
		}
		return a;
	}
	
	// Ejercicio 8
	public static Punto mayorX(List<Punto> ls) {
		return mayorX(ls, 0, null);
	}
	
	private static Punto mayorX(List<Punto> ls, int i, Punto p) {
		if (ls.size() - i == 1) { 
			if (p == null || ls.get(i).getX().compareTo(p.getX()) > 0) {
				p = ls.get(i);
			}
		} else {
			if (p == null || ls.get(i).getX().compareTo(p.getX()) > 0) {
				p = mayorX(ls, i + 1, ls.get(i));
			} else {
				p = mayorX(ls, i + 1, p);
			}
		}
		return p;
	}
	
	// Ejercicio 9
	public static List<Punto> toPuntoList(Punto[] arr) {
		return toPuntoList(arr, 0, new ArrayList<Punto>());
	}
	
	private static List<Punto> toPuntoList(Punto[] arr, int i, List<Punto> a) {
		if (arr.length - i == 1) {
			a.add(arr[i]);
		} else {
			a.add(arr[i]);
			toPuntoList(arr, i + 1, a);
		}
		return a;
	}
	
	// Ejercicio 10
	public static Integer puntosC1(List<Punto> ls) {
		return puntosC1(ls, 0, 0);
	}
	
	private static Integer puntosC1(List<Punto> ls, int i, int a) {
		if (ls.size() - i == 1) {
			if (ls.get(i).getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE)) {
				a = a + 1;
			}
		} else {
			if (ls.get(i).getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE)){
				a = puntosC1(ls, i + 1, a + 1);
			} else {
				a = puntosC1(ls, i + 1, a);
			}
		}
		return a;
	}
	
	// Ejercicio 11
	public static Map<Cuadrante, List<Punto>> puntosPorCuadrante(List<Punto> ls) {
		return puntosPorCuadrante(ls, 0, new HashMap<Cuadrante, List<Punto>>());
	}
	
	private static Map<Cuadrante, List<Punto>> puntosPorCuadrante(List<Punto> ls, int i, Map<Cuadrante, List<Punto>> mp) {
		List<Punto> tmp = new ArrayList<>();
		Cuadrante c = ls.get(i).getCuadrante();
		if (ls.size() - i == 1) {
			if (mp.containsKey(c)) {
				tmp = mp.get(c);
			}
			tmp.add(ls.get(i));
			mp.put(c, tmp);
		} else {
			if (mp.containsKey(c)) {
				tmp = mp.get(c);
			}
			tmp.add(ls.get(i));
			mp.put(c, tmp);
			puntosPorCuadrante(ls, i + 1, mp);
		}
		return mp;
	}
}
