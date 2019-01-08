package ejercicio2;

import java.util.List;

import us.lsi.common.Streams2;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio2 {

	public static <E> Boolean sonIguales(Tree<E> arbol1, Tree<E> arbol2) {
		Boolean res = true;
		
		switch (arbol1.getType()) {
			case Empty:
				res = arbol2.isEmpty();
				break;
			case Leaf:
				res = arbol2.isLeaf() && arbol1.getLabel().equals(arbol2.getLabel());
				break;
			case Nary:
//				List<Tree<E>> hijosA1 = arbol1.getChildren();
//				List<Tree<E>> hijosA2 = arbol2.getChildren();
//				
//				if (hijosA2 == null || hijosA1.size() != hijosA2.size() || 
//						!arbol1.getLabel().equals(arbol2.getLabel())) {
//					res = false;
//				} else {
//					int i = 0;
//					while (i < hijosA1.size() && res) {
//						res = sonIguales(arbol1.getChild(i), arbol2.getChild(i));
//						i++;
//					}
//				}
				
				
				// CASO FUNCIONAL
				res = arbol2.isNary() && arbol1.getLabel().equals(arbol2.getLabel()) && 
					Streams2.zip(arbol1.getChildren().stream(), arbol2.getChildren().stream(), 
							(ab1, ab2) -> sonIguales(ab1, ab2))
					.allMatch(x -> x == true);
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
		Tree<Integer> t7 = Tree.nary(34, t2, t4, t5);
		
		System.out.println("Resultado del segundo ejercicio: ¿Son iguales los árboles?: " +
				sonIguales(t6, t7));

	}

}
