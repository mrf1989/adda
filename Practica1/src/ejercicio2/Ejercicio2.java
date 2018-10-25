package ejercicio2;

import java.util.Arrays;
import java.util.List;

import us.lsi.common.ListMultimap;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejercicio2 {
	
	// Solución iterativo (while)
	public static ListMultimap<Cuadrante, Punto2D> agrupaPorCuadrante(List<Punto2D> ls) {
		ListMultimap<Cuadrante, Punto2D> res = new ListMultimap<>();
		Integer i = 0;
		
		while (i < ls.size()) {
			Punto2D p = ls.get(i);
			Cuadrante c = p.getCuadrante();
			
			if (res.containsKey(c)) {
				res.get(c).add(p);
			} else {
				res.put(c, p);
			}
			
			i++;
		}
		
		return res;
	}
	
	// Solución funcional (Stream)
	
	public static ListMultimap<Cuadrante, Punto2D> agrupaPorCuadranteFuncional(List<Punto2D> ls) {
		// TODO Implementar método funcional (Java 8) que agrupe en una lista los puntos por cuadrante.
		return null;
	}
	
	public static void main(String[] args) {
		Punto2D p1 = Punto2D.create(3.4, -1.3);
		Punto2D p2 = Punto2D.create(4.2, 4.4);
		Punto2D p3 = Punto2D.create(-1.8, 3.2);
		Punto2D p4 = Punto2D.create(-0.5, -5.3);
		Punto2D p5 = Punto2D.create(-4.5, -3.3);
		Punto2D[] arr = {p1, p2, p3, p4, p5};
		List<Punto2D> ls = Arrays.asList(arr);
		System.out.println("Test Ejercicio2");
		System.out.println("===============");
		System.out.println("- While (Java):");
		System.out.println(Ejercicio2.agrupaPorCuadrante(ls));

	}

}
