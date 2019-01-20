package ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import punto.Cuadrante;
import punto.Punto;

public class Ejercicios {
	
	// Ejercicio 1
	public static Double sumaReales(List<Double> ls) {
		Integer e = 0;
		Double a = 0.0;
		while (e < ls.size()) {
			a = a + ls.get(e);
			e = e + 1;
		}
		return a;
	}
	
	// Ejercicio 2
	public static List<Double> coordX(List<Punto> ls) {
		List<Double> a = new ArrayList<>();
		Integer e = 0;
		while (e < ls.size()) {
			a.add(ls.get(e).getX());
			e = e + 1;
		}
		return a;
	}
	
	// Ejercicio 3
	public static Boolean sonImpares(List<Integer> ls) {
		Integer e = 0;
		Boolean a = true;
		while (e < ls.size() && a) {
			a = ls.get(e) % 2 != 0;
			e = e + 1;
		}
		return a;
	}

	// Ejercicio 4
	public static Boolean algunImparPrimo(List<Integer> ls) {
		Integer e = 0;
		Boolean a = false;
		while (e < ls.size() && !a) {
			a = (ls.get(e) % 2 != 0) && esPrimo((long) e);
			e = e + 1;
		}
		return a;
	}

	// Ejercicio 5
	public static Integer sumarCuadrados(List<Integer> ls) {
		Integer e = 0, a = 0, d = 0;
		while (e < ls.size()) {
			d = ls.get(e);
			a = a + (d * d);
			e = e + 1;
		}
		return a;
	}

	// Ejercicio 6
	public static Double buscarMayorA(List<Double> ls, Double n) {
		Integer e = 0;
		Double a = -1.;
		Boolean b = false;
		while (e < ls.size() && !b) {
			b = ls.get(e) > n;
			if (b) {
				a = ls.get(e);
			}
			e = e + 1;
		}
		return a;
	}
	
	// Ejemplo 7
	public static List<Punto> simetriaY(List<Punto> ls) {
		List<Punto> a = new ArrayList<>();
		Integer e = 0;
		while (e < ls.size()) {
			Punto p = ls.get(e);
			p.setX(0 - p.getX());
			a.add(p);
			e = e + 1;
		}
		return a;
	}
	
	// Ejercicio 8
	public static Double mayorX(List<Punto> ls) {
		Double a = null;
		Integer e = 0;
		while (e < ls.size()) {
			Double c = ls.get(e).getX();
			if (a == null || c.compareTo(a) > 0) {
				a = c;
			}
			e = e + 1;
		}
		return a;
	}
	
	// Ejercicio 9
	public static List<Punto> toPuntoList(Punto[] arr) {
		Integer e = 0;
		List<Punto> a = new ArrayList<>();
		while (e < arr.length) {
			a.add(arr[e]);
			e = e + 1;
		}
		return a;
	}
	
	// Ejercicio 10
	public static Integer puntosC1(List<Punto> ls) {
		Integer e = 0;
		Integer a = 0;
		while (e < ls.size()) {
			if (ls.get(e).getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE)) {
				a = a + 1;
			}
			e = e + 1;
		}
		return a;
	}
	
	// Ejercicio 11
	public static Map<Cuadrante, List<Punto>> puntosPorCuadrante(List<Punto> ls) {
		Map<Cuadrante, List<Punto>> a = new HashMap<>();
		Integer e = 0;
		while (e < ls.size()) {
			Punto p = ls.get(e);
			Cuadrante c = p.getCuadrante();
			if (a.containsKey(c)) {
				a.get(c).add(p);
			} else {
				List<Punto> l = new ArrayList<>();
				l.add(p);
				a.put(c, l);
			}
			e = e + 1;
		}
		return a;
	}
	
	// Ejercicio 12
	public static Map<Cuadrante, Double> sumaCoordXPorCuadrante(List<Punto> ls) {
		Map<Cuadrante, Double> a = new HashMap<>();
		Integer e = 0;
		while (e < ls.size()) {
			Double x = ls.get(e).getX();
			Cuadrante c = ls.get(e).getCuadrante();
			if (a.containsKey(c)) {
				a.put(c, a.get(c) + x);
			} else {
				a.put(c, x);
			}
			e = e + 1;
		}
		return a;
	}

	// Ejercicio 14
	public static Integer buscarMayor(List<Integer> ls, Comparator<Integer> cmp) {
		Integer e = 0;
		Integer a = null;
		while (e < ls.size()) {
			if (a == null || cmp.compare(a, ls.get(e)) <= 0) {
				a = ls.get(e);
			}
			e = e + 1;
		}
		return a;
	}
	
	// Ejercicio 15
	public static Integer buscarMenor(List<Integer> ls, Comparator<Integer> cmp) {
		Integer e = 0;
		Integer a = null;
		while (e < ls.size()) {
			if (a == null || cmp.compare(a,  ls.get(e)) >= 0) {
				a = ls.get(e);
			}
			e = e + 1;
		}
		return a;
	}

	// Ejercicio 16
	public static Boolean esMultiplo(Integer m, Integer n) {
		Boolean b = false;
		while (m > 0 && !b) {
			m = m - n;
			b = m == 0;
		}
		return b;
	}

	// Ejercicio 17
	public static Double media(List<Integer> ls) {
		Integer e = 0, a = 0;
		while (e < ls.size()) {
			a = a + ls.get(e);
			e = e + 1;
		}
		return (double) (a / ls.size());
	}

	// Ejercicio 18
	public static Boolean esPrimo(Long n) {
		Long sqrt = (long) Math.sqrt((double) n);
		Long e = 2L;
		Boolean b = true;
		while (e <= sqrt && b) {
			b = n % e != 0;
			e = e + 1;
		}
		return b;
	}

	// Ejercicio 20
	public static Integer contarMinusculas(String str) {
		Integer e = 0, a = 0;
		while (e < str.length()) {
			if (Character.isLowerCase(str.charAt(e))) {
				a = a + 1;
			}
			e = e + 1;
		}
		return a;
	}

	// Ejercicio 21
	public static String inversa(String str) {
		Integer e = str.length() - 1;
		String a = "";
		while (e >= 0) {
			a = a + str.charAt(e);
			e = e - 1;
		}
		return a;
	}

	// Ejercicio 22
	public static Boolean esPalindromo(String str) {
		return str == inversa(str);
	}

	// Ejercicio 23
	public static Integer factorial(Integer n) {
		Integer e = 1, a = 1;
		while (e <= n) {
			a = a * e;
			e = e + 1;
		}
		return a;
	}

	// Ejercicio 30
	public static Integer raizN(Integer n, Integer a) {
		Integer e = 1;
		while (a >= Math.pow((double) e, (double) n)) {
			e = e + 1;
		}
		return e;
	}

	// Ejercicio 38
	public static List<Integer> divisores(Integer n) {
		Integer e = 2;
		List<Integer> a = new ArrayList<>();
		while (e < n) {
			if (n % e == 0) {
				a.add(e);
			}
			e = e + 1;
		}
		return a;
	}

	// Ejercicio 40
	// a
	public static <T> Boolean buscarNoOrd(List<T> ls, T e) {
		Integer i = 0;
		Boolean b = false;
		while (i < ls.size() && !b) {
			b = ls.get(i).equals(e);
			i = i + 1;
		}
		return b;
	}
	// b
	public static <T> Boolean buscarOrd(List<T> ls, T e, Comparator<T> cmp) {
		Integer i = 0, j = ls.size() - 1;
		Integer k;
		Boolean b = false;
		while (i <= j && !b) {
			k = (i + j) / 2;
			if (ls.get(k).equals(e)) {
				b = true;
			} else {
				if (cmp.compare(ls.get(k), e) < 0) {
					i = k + 1;
				} else if (cmp.compare(ls.get(k), e) > 0) {
					j = k - 1;
				}
			}
		}
		return b;
	}

	// Ejercicio 43
	public static Integer raizCuadrada(Integer a) {
		Integer n = 2;
		while (a >= (n * n)) {
			n = n + 1;
		}
		return n - 1;
	}

	// Ejercicio 58
	public static List<Integer> aplanaLists(List<List<Integer>> ls) {
		Integer i = 0, j;
		List<Integer> a = new ArrayList<>();
		while (i < ls.size()) {
			j = 0;
			List<Integer> l = ls.get(i);
			while (j < l.size()) {
				a.add(l.get(j));
				j = j + 1;
			}
			i = i + 1;
		}
		return a;
	}

}
