package pi1.ejercicio64;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Mario Ruano Fernández
 *
 */
public class Metodos64 {
	
	/**
	 * 
	 * Recibe dos listas ordenadas previamente de Integer y fusiona ambas listas en una Lista de Integer ordenada,
	 * en la cual se mantienen los elementos duplicados que aparecen en ambas listas.
	 * Este método ofrece la solución iterativa del problema 64 (1.4).
	 * @param ls1 Lista de Integer que debe estar ordenada.
	 * @param ls2 Lista de Integer que debe estar ordenada.
	 * @return Lista de Integer.
	 */
	public static List<Integer> fusionListWhile(List<Integer> ls1, List<Integer> ls2) {
		List<Integer> res = new ArrayList<>();
		int i = 0, j = 0;
		
		while (!(i == ls1.size() && j == ls2.size())) {
			if (i == ls1.size()) {
				res.addAll(ls2.subList(j, ls2.size()));
				j = ls2.size();
			} else if (j == ls2.size()) {
				res.addAll(ls1.subList(i, ls1.size()));
				i = ls1.size();
			} else {
				if (ls1.get(i).compareTo(ls2.get(j)) < 0) {
					res.add(ls1.get(i));
					i++;
				} else {
					res.add(ls2.get(j));
					j++;
				}
			}
		}
		
		return res;
	}
	
	/**
	 * 
	 * Recibe dos listas ordenadas previamente de Integer y fusiona ambas listas en una Lista de Integer ordenada,
	 * en la cual se mantienen los elementos duplicados que aparecen en ambas listas.
	 * Este método ofrece la solución funcional del problema 64 (1.4).
	 * @param ls1 Lista de Integer que debe estar ordenada.
	 * @param ls2 Lista de Integer que debe estar ordenada.
	 * @return Lista de Integer.
	 */	
	public static List<Integer> fusionListJava10(List<Integer> ls1, List<Integer> ls2) {
		List<Integer> res = new ArrayList<>();
		res.addAll(ls1);
		res.addAll(ls2);
		return res.stream()
				.sorted()
				.collect(Collectors.toList());
	}
	/*
	 * Otra posible solución usando la clase Streams2 de la API de la asignatura.
	 * 
	public static List<Integer> fusionListJava10(List<Integer> ls1, List<Integer> ls2) {
	return Streams2.concat(ls1.stream(), ls2.stream())
			.sorted()
			.collect(Collectors.toList());
	}
	 *
	 */
	
	/**
	 * 
	 * Recibe dos listas ordenadas previamente de Integer y fusiona ambas listas en una Lista de Integer ordenada,
	 * en la cual se mantienen los elementos duplicados que aparecen en ambas listas.
	 * Este método ofrece la solución recursiva del problema 64 (1.4).
	 * @param ls1 Lista de Integer que debe estar ordenada.
	 * @param ls2 Lista de Integer que debe estar ordenada.
	 * @return Lista de Integer.
	 */
	public static List<Integer> fusionListRec(List<Integer> ls1, List<Integer> ls2) {
		return fusionListRecGen(ls1, ls2, 0, 0, new ArrayList<Integer>());
	}

	private static List<Integer> fusionListRecGen(List<Integer> ls1, List<Integer> ls2, int i, int j,
			ArrayList<Integer> ac) {
		List<Integer> res = new ArrayList<>();
		
		if (i == ls1.size() && j == ls2.size()) {
			res = ac;
		} else {
			if (i == ls1.size()) {
				ac.addAll(ls2.subList(j, ls2.size()));
				res = fusionListRecGen(ls1, ls2, i, ls2.size(), ac);
			} else if (j == ls2.size()) {
				ac.addAll(ls1.subList(i, ls1.size()));
				res = fusionListRecGen(ls1, ls2, ls1.size(), j, ac);
			} else {
				if (ls1.get(i).compareTo(ls2.get(j)) < 0) {
					ac.add(ls1.get(i));
					res = fusionListRecGen(ls1, ls2, i + 1, j, ac);
				} else {
					ac.add(ls2.get(j));
					res = fusionListRecGen(ls1, ls2, i, j + 1, ac);
				}
			}
		}
		
		return res;
	}
	
}
