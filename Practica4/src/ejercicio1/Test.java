package ejercicio1;

import java.util.stream.Stream;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple3;

public class Test {

	// Iterativo
	public static Integer determinaPosicion(Integer[] a) {
		Integer i = 0, j = a.length;
		Integer k = (i + j) / 2;
		Integer res = -1;
	
		while (j - i != 0) {
			if (a[k] == k) {
				res = k;
				break;
			} else if (a[k] < k) {
				i = k + 1;
				k = (i + j) / 2;
			} else {
				j = k;
				k = (i + j) / 2;
			}
		}
		
		return res;
	}
	
	// Recursivo
	public static Integer determinaPosicionR(Integer[] a) {
		return determinaPosicionRG(a, 0, a.length);
	}
	
	private static Integer determinaPosicionRG(Integer[] a, int i, int j) {
		Integer res = - 1;
		Integer k = (i + j) / 2;
		
		if (a[k] == k) {
			res = k;
		} else if (a[k] < k) {
			res = determinaPosicionRG(a, k + 1, j);
		} else if (a[k] > k) {
			res = determinaPosicionRG(a, i, k);
		}
		
		return res;
	}
	
	// Funcional.
	// Se usa la clase Tupla proporcionada por la API de la asignatura.
	public static Integer determinaPosicionF(Integer[] a) {
		Tuple3<Integer,Integer,Integer> t = Tuple.create(0, a.length, (0+a.length) / 2);
		return Stream.iterate(t, x -> siguiente(a, x))
				.dropWhile(x -> a[x.getV3()] != x.getV3())
				.findFirst()
				.get().getV3();
	}
	
	private static Tuple3<Integer, Integer, Integer> siguiente(Integer[] a, Tuple3<Integer, Integer, Integer> t) {
		Integer i = t.getV1();
		Integer j = t.getV2();
		Integer k = t.getV3();
		Tuple3<Integer, Integer, Integer> res;
		
		if (a[k] < k) {
			res = Tuple.create(k+1, j, (k+1+j)/2);
		} else {
			res = Tuple.create(i, k, (i+j)/2);
		}
		
		return res;
	}

	// TEST
	public static void main(String[] args) {
		
		Integer[] a = {-2,-1,1,2,4,7,8};
		
		System.out.println(determinaPosicionF(a));
		
	}

}
