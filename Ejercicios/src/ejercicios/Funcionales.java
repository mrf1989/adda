package ejercicios;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import punto.Cuadrante;
import punto.Punto;
import punto.PuntoImpl;

public class Funcionales {
	
	// Ejercicio 1
	public static Double sumaReales(List<Double> ls) {
		return ls.stream()
				.reduce(0.0, (b, e) -> b + e);
	}
	
	// Ejercicio 2
	public static List<Double> coordX(List<Punto> ls) {
		return ls.stream()
				.map(e -> e.getX())
				.collect(Collectors.toList());
	}
	
	// Ejercicio 3
	public static Boolean sonImpares(List<Integer> ls) {
		return ls.stream()
				.allMatch(e -> e % 2 != 0);
	}
	
	// Ejercicio 4
	public static Boolean algunPrimoImpar(List<Integer> ls) {
		return ls.stream()
				.anyMatch(e -> e % 2 != 0 && Iterativos.esPrimo((long) e));
	}
	
	// Ejercicio 5
	public static Integer sumaCuadrados(List<Integer> ls) {
		return ls.stream()
				.mapToInt(e -> e * e)
				.sum();
	}
	
	// Ejercicio 6
	public static Double buscaMayorA(List<Double> ls, Double n) {
		return ls.stream()
				.filter(e -> e > n)
				.findFirst()
				.orElse(null);
	}
	
	// Ejercicio 7
	public static List<Punto> simetriaY(List<Punto> ls) {
		return ls.stream()
				.map(e -> new PuntoImpl(0 - e.getX(), e.getY()))
				.collect(Collectors.toList());
	}
	
	// Ejercicio 8
	public static Punto mayorX(List<Punto> ls) {
		return ls.stream()
				.max(Comparator.comparing(Punto::getX))
				.get();
	}
	
	// Ejercicio 9
	public static List<Punto> toPuntoList(Punto[] arr) {
		return IntStream.range(0, arr.length)
				.mapToObj(e -> arr[e])
				.collect(Collectors.toList());
	}
	
	// Ejercicio 10
	public static Integer puntosC1(List<Punto> ls) {
		return (int) ls.stream()
				.filter(e -> e.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE))
				.count();
	}
	
	// Ejercicio 11
	public static Map<Cuadrante, List<Punto>> puntosPorCuadrante(List<Punto> ls) {
		return ls.stream().collect(Collectors.groupingBy(Punto::getCuadrante));
	}
	
	// Ejercicio 12
	public static Map<Cuadrante, Double> sumaCoordXPorCuadrante(List<Punto> ls) {
		return ls.stream()
				.collect(Collectors.groupingBy(Punto::getCuadrante, Collectors.summingDouble(Punto::getX)));
	}
}
