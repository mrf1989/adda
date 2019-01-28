package ejercicios;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ficheros.Ficheros;
import punto.Cuadrante;
import punto.Punto;
import punto.PuntoImpl;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import utiles.Listas;

public class Iterativos {
	
	// Búsqueda Binaria
	public static <E extends Comparable<? super E>> Integer bb(List<E> ls, E n) {
		Integer r = -1;
		int i = 0;
		int j = ls.size() - 1;
		int k;
		Boolean b = false;
		while (j - i >= 0 && !b) {
			k = (i + j) / 2;
			if (ls.get(k).compareTo(n) == 0) {
				r = k;
				b = true;
			} else if (ls.get(k).compareTo(n) > 0) {
				j = k - 1;
			} else {
				i = k + 1;
			}
		}
		return r;
	}
	
	// Bandera Holandesa
	public static <E> Tuple2<Integer, Integer> bh(List<E> ls, E p, Comparator<E> cmp) {
		return bh(ls, p, 0, ls.size(), cmp);
	}
	
	private static <E> Tuple2<Integer, Integer> bh (List<E> ls, E p, int i, int j, Comparator<E> cmp) {
		int a, b, c;
		a = i;
		b = i;
		c = j;
		List<Integer> la = new ArrayList<>();
		while (c - b > 0) {
			if (cmp.compare(ls.get(b), p) < 0) {
				Listas.intercambiar(ls, a, b);
				a++;
				b++;
			} else if (ls.get(b).equals(p)) {
				b++;
			} else {
				Listas.intercambiar(ls, b, c - 1);
				c--;
			}
		}
		la.add(a);
		la.add(b);
		Tuple2<Integer, Integer> t = Tuple.asTuple2(la);
		return t;
	}
	
	// Bandera Portuguesa
	public static <E> Integer bp(List<E> ls, E p, Comparator<E> cmp) {
		return bp(ls, p, 0, ls.size(), cmp);
	}
	
	private static <E> Integer bp(List<E> ls, E p, int i, int j, Comparator<E> cmp) {
		int a, b;
		a = i;
		b = j;
		while (b - a > 0) {
			if (cmp.compare(ls.get(a), p) < 0) {
				a++;
			} else {
				Listas.intercambiar(ls, a, b - 1);
				b--;
			}
		}
		return a;
	}
	
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
		Double a = null;
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
		List<Punto> r = new ArrayList<>();
		Integer e = 0;
		while (e < ls.size()) {
			Punto p = new PuntoImpl(0 - ls.get(e).getX(), ls.get(e).getY());
			r.add(p);
			e = e + 1;
		}
		return r;
	}
	
	// Ejercicio 8
	public static Punto mayorX(List<Punto> ls) {
		Punto a = null;
		Integer e = 0;
		while (e < ls.size()) {
			Double c = ls.get(e).getX();
			if (a == null || c.compareTo(a.getX()) > 0) {
				a = ls.get(e);
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
	
	// Ejercicio 19
	public static Long siguientePrimo(Long n) {
		Boolean b = false;
		Long e = (Long) (n % 2 == 0 ? n + 1 : n + 2);
		Long r = null;
		while (!b) {
			if (esPrimo(e)) {
				b = true;
				r = e;
			}
			e = e + 2;
		}
		return r;
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
	
	// Ejercicio 59
	public static void guardaPrimos(String nombreArchivo, Long n) throws IOException {
		List<Long> a = new ArrayList<>();
		if (n > 2) {
			a.add(2L);
			Long e = 2L;
			while (e < n) {
				e = siguientePrimo(e);
				if (e <= n) {
					a.add(e);
				}
			}
		}
		Ficheros.escribir(a, "./data/" + nombreArchivo);
	}
	
	// Ejercicio 62
	public static void fechasOrdenadas(String path, LocalDate from, LocalDate to, String nombreArchivo) throws IOException {
		List<String> fichero = Ficheros.leer(path);
		List<LocalDate> fechas = fichero.stream()
				.map(e -> LocalDate.parse(e, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.collect(Collectors.toList());
		fechas = ordenarFechas(fechas, 0, fechas.size() - 1, Comparator.naturalOrder());
		List<String> output = fechas.stream()
				.filter(d -> d.compareTo(from) >= 0 && d.compareTo(to) <= 0)
				.map(d -> d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.collect(Collectors.toList());
		Ficheros.escribir(output, nombreArchivo);
	}

	private static List<LocalDate> ordenarFechas(List<LocalDate> fechas, int i, int j, Comparator<LocalDate> cmp) {
		if (i < j) {
			LocalDate p = fechas.get((i + j) / 2);
			int index = particion(fechas, i, j, p, cmp);
			ordenarFechas(fechas, i, index - 1, cmp);
			ordenarFechas(fechas, index, j, cmp);
		}
		return fechas;
	}

	private static int particion(List<LocalDate> fechas, int i, int j, LocalDate p, Comparator<LocalDate> cmp) {
		while (i <= j) {
			while (cmp.compare(fechas.get(i), p) < 0) {
				i++;
			}
			while (cmp.compare(fechas.get(j), p) > 0) {
				j--;
			}
			if (i <= j) {
				Listas.intercambiar(fechas, i, j);
				i++;
				j--;
			}
		}
		return i;
	}

}
