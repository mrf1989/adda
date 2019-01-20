package ejercicios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Double[] arr = {2.34, 4.2, 5.2, 6.2, 7.88, 9.78, 10.1};
		List<Double> ls = Arrays.asList(arr);
		System.out.println(Ejercicios.buscarOrd(ls, 2.35, Comparator.naturalOrder()));

	}

}
