package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio2 {
	
	public static <E> List<E> recorridoPosOrden(BinaryTree<E> t) {
		List<E> l = new ArrayList<>();
		
		switch (t.getType()) {
		case Empty:
			break;
		case Leaf:
			l.add(t.getLabel());
			break;
		case Binary:
			l.addAll(recorridoPosOrden(t.getLeft()));
			l.addAll(recorridoPosOrden(t.getRight()));
			l.add(t.getLabel());
			break;
		}
		
		return l;
	}

}
