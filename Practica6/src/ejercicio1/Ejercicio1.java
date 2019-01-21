package ejercicio1;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio1 {
	
	public static Integer sumaPares(BinaryTree<Integer> t) {
		Integer r = 0;
		
		switch (t.getType()) {
		case Empty:
			r = 0;
			break;
		case Leaf:
			if (t.getLabel() % 2 == 0) {
				r = t.getLabel();
			}
			break;
		case Binary:
			if (t.getLabel() % 2 == 0) {
				r = t.getLabel();
			}
			r = r + sumaPares(t.getLeft()) + sumaPares(t.getRight());
			break;
		}
		
		return r;
	}
	
}
