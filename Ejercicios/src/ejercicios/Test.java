package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import punto.Punto;
import punto.PuntoImpl;

public class Test {

	public static void main(String[] args) {
		Double[] arr1 = {2.34, 4.2, 5.2, 6.2, 7.88, 9.78, 10.1};
		List<Double> ls1 = Arrays.asList(arr1);
		
		List<Punto> lp = new ArrayList<>();
		Punto p1 = new PuntoImpl(3.2, 1.2);
		Punto p2 = new PuntoImpl(-4.3, 1.2);
		Punto p3 = new PuntoImpl(5.1, -4.7);
		Punto p4 = new PuntoImpl(2.7, 4.9);
		Punto p5 = new PuntoImpl(-6.3, -5.2);
		Punto p6 = new PuntoImpl(-7.5, 9.5);
		Punto p7 = new PuntoImpl(6.4, -6.6);
		Punto p8 = new PuntoImpl(4.6, -2.5);
		lp.add(p1);
		lp.add(p2);
		lp.add(p3);
		lp.add(p4);
		lp.add(p5);
		lp.add(p6);
		lp.add(p7);
		lp.add(p8);
		
		Punto[] arr2 = {p1, p2, p3, p4, p5, p6, p7, p8};
		
		Integer[] arr3 = {1, 5, 3, 7, 1, 1, 5, 3, 5};
		List<Integer> ls2 = Arrays.asList(arr3);
		
	}

}
