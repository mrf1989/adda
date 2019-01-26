package ejercicios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ficheros.Ficheros;
import punto.Cuadrante;
import punto.Punto;
import punto.PuntoImpl;
import us.lsi.common.Lists2;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import utiles.Listas;

public class Recursivos {
	
	// Búsqueda binaria
	public static <E extends Comparable<? super E>> Integer bb(List<E> ls, E n) {
		return bb(ls, n, 0, ls.size() - 1);
	}
	
	private static <E extends Comparable<? super E>> Integer bb(List<E> ls, E n, int i, int j) {
		Integer r;
		int k;
		if (j - i < 0) {
			r = -1;
		} else {
			k = (i + j) / 2;
			if (ls.get(k).compareTo(n) == 0) {
				r = k;
			} else if (ls.get(k).compareTo(n) > 0) {
				r = bb(ls, n, i, k - 1);
			} else {
				r = bb(ls, n, k + 1, j);
			}
		}
		return r;
	}
	
	// Bandera Holandesa
	public static <E> Tuple2<Integer, Integer> bh(List<E> ls, E p, Comparator<E> cmp) {
		List<Integer> la = bh(ls, p, 0, 0, ls.size(), cmp, new ArrayList<>());
		Tuple2<Integer, Integer> r = Tuple.asTuple2(la);
		return r;
	}
	
	private static <E> List<Integer> bh(List<E> ls, E p, int a, int b, int c, Comparator<E> cmp, List<Integer> acum) {
		if (c - b <= 0) {
			acum.add(a);
			acum.add(b);
		} else {
			if (cmp.compare(ls.get(b), p) < 0) {
				Listas.intercambiar(ls, a, b);
				bh(ls, p, a + 1, b + 1, c, cmp, acum);
			} else if (ls.get(b).equals(p)) {
				bh(ls, p, a, b + 1, c, cmp, acum);				
			} else {
				Listas.intercambiar(ls, b, c - 1);
				bh(ls, p, a, b, c - 1, cmp, acum);
			}
		}
		return acum;
	}
	
	// Bandera Portuguesa
	public static <E> Integer bp(List<E> ls, E p, Comparator<E> cmp) {
		return bp(ls, p, 0, ls.size(), cmp);
	}
	
	private static <E> Integer bp(List<E> ls, E p, int i, int j, Comparator<E> cmp) {
		Integer r;
		if (j - i <= 0) {
			r = i;
		}
		else {
			if (cmp.compare(ls.get(i), p) < 0) {
				r = bp(ls, p, i + 1, j, cmp);
			} else {
				Listas.intercambiar(ls, i, j - 1);
				r = bp(ls, p, i, j - 1, cmp);
			}
		}
		return r;
	}
	
	// * Fibonacci de n (algoritmo recursivo con memoria)
	public static Long fib(Integer n) {
		Map<Integer, Long> m = new HashMap<>();
		return fib(n, m);
	}
	
	private static Long fib(Integer n, Map<Integer, Long> m) {
		Long r;
		if (m.containsKey(n)) {
			r = m.get(n);
		} else if (n <= 1) {
			r = (long) n;
			m.put(n, r);
		} else {
			r = fib(n - 1, m) + fib(n - 2, m);
			m.put(n, r);
		}
		return r;
	}
	
	// QuickSort
	public static <E extends Comparable<E>> void quickSort(List<E> ls) {
		Comparator<E> cmp = Comparator.naturalOrder(); 
		quickSort(ls, 0, ls.size() - 1, cmp);
	}

	private static <E> void quickSort(List<E> ls, int i, int j, Comparator<E> cmp) {
		if (i < j) {
			E p = ls.get((i + j) / 2);
			int index = particion(ls, i, j, p, cmp);
			quickSort(ls, i, index - 1, cmp);
			quickSort(ls, index, j, cmp);
		}
	}

	private static <E> int particion(List<E> ls, int i, int j, E p, Comparator<E> cmp) {
		while (i <= j) {
			while (cmp.compare(ls.get(i), p) < 0) {
				i++;
			}
			while (cmp.compare(ls.get(j), p) > 0) {
				j--;
			}
			if (i <= j) {
				Listas.intercambiar(ls, i, j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	// MergeSort
	public static <E extends Comparable<? super E>> void mergeSort(List<E> ls) {
		Comparator<E> cmp = Comparator.naturalOrder();
		List<E> tmp = Lists2.newList(ls);
		mergeSort(ls, 0, ls.size(), cmp, tmp);
	}

	private static <E> void mergeSort(List<E> ls, int i, int j, Comparator<E> cmp, List<E> tmp) {
		if (j - i > 1) {
			int k = (i + j) / 2;
			mergeSort(ls, i, k, cmp, tmp);
			mergeSort(ls, k, j, cmp, tmp);
			mezcla(ls, i, k, ls, k, j, tmp, i, j, cmp);
			copia(ls, i, j, tmp);
		}
	}
	
	private static <E> void mezcla(List<E> ls1, int i1, int j1, List<E> ls2, int i2, int j2, List<E> ls3, int i3, int j3, Comparator<E> cmp) {
		int k1 = i1, k2 = i2, k3 = i3;
		while (k3 < j3) {
			if (k1 < j1 && k2 < j2) {
				if (cmp.compare(ls1.get(k1), ls2.get(k2)) <= 0) {
					ls3.set(k3, ls1.get(k1));
					k1++;
				} else {
					ls3.set(k3, ls2.get(k2));
					k2++;
				}
			} else if (k2 == j2) {
				ls3.set(k3, ls1.get(k1));
				k1++;
			} else {
				ls3.set(k3, ls2.get(k2));
				k2++;
			}
			k3++;
		}
	}
	
	private static <E> void copia(List<E> ls, int i, int j, List<E> tmp) {
		for (int k = i; k < j; k++) {
			ls.set(k, tmp.get(k));
		}
	}
	
	// K-ésimo
	public static <E extends Comparable<? super E>> E getKesimo(List<E> ls, int k) {
		Comparator<E> cmp = Comparator.naturalOrder();
		return escogeKesimo(ls, 0, ls.size(), k, cmp);
	}

	private static <E> E escogeKesimo(List<E> ls, int i, int j, int k, Comparator<E> cmp) {
		E r;
		if (j - i == 0) {
			r = null;
		} else if (j - i == 1) {
			r = ls.get(i);
		} else {
			E p = ls.get(((i + j) / 2) + 1);
			Tuple2<Integer, Integer> tp = bh(ls, p, cmp);
			if (k < tp.v1) {
				r = escogeKesimo(ls, i, tp.v1, k, cmp);
			} else if (k >= tp.v2) {
				r = escogeKesimo(ls, tp.v2, j, k, cmp);
			} else {
				r = ls.get(k);
			}
		}
		return r;
	}

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
	
	// Ejercicio 59
	public static void guardaPrimos(String nombreArchivo, Long n) throws IOException {
		List<Long> ls = new ArrayList<>();
		if (n >= 2) {
			ls.add(2L);
		}
		guardaPrimos(nombreArchivo, n, 2L, ls);
	}

	private static void guardaPrimos(String nombreArchivo, Long n, Long e, List<Long> a) throws IOException {
		Long tmp = Iterativos.siguientePrimo(e);
		if (tmp <= n) {
			a.add(tmp);
			guardaPrimos(nombreArchivo, n, tmp, a);
		} else {
			Ficheros.escribir(a, "./data/" + nombreArchivo);
		}
		
	}
}
