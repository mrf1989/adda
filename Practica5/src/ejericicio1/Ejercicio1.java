package ejericicio1;

import java.util.List;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio1 {
	
	public static <E> Boolean contieneEtiqueta(Tree<E> arbol, E etiqueta) {
		Boolean res = false;
		
		switch (arbol.getType()) {
			case Empty:
				res = false;
				break;
			case Leaf:
				res = arbol.getLabel().equals(etiqueta);
				break;
			case Nary:
				if (arbol.getLabel().equals(etiqueta)) {
					res = true;
				} else {
					List<Tree<E>> hijos = arbol.getChildren();
					int i = 0;
					while (i < hijos.size() && !res) {
						res = contieneEtiqueta(hijos.get(i), etiqueta);
						i++;
					}
				}
				/*
				 * FUNCIONAL
				 * 
				 * res = arbol.getLabel().equals(etiqueta) ||
				 * arbol.getChildren().stream().anyMatch(a -> contieneEtiqueta(a, etiqueta));
				 */
		}
		
		return res;
	}

	public static void main(String[] args) {
		Tree<Integer> t1 = Tree.empty();
		Tree<Integer> t2 = Tree.leaf(3);
		Tree<Integer> t3 = Tree.leaf(6);
		Tree<Integer> t4 = Tree.leaf(13);
		Tree<Integer> t5 = Tree.nary(23, t1, t2, t3, t4);
		Tree<Integer> t6 = Tree.nary(34, t2, t4, t5);
		
		Integer etiqueta = 6;
		
		System.out.println("Resultado del primer ejercicio: ¿Existe la etiqueta " + etiqueta + " en el árbol?: " +
				contieneEtiqueta(t6, etiqueta));

	}

}
