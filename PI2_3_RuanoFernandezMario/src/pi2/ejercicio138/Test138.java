package pi2.ejercicio138;

import us.lsi.tiposrecursivos.BinaryTree;

public class Test138 {

	public static void main(String[] args) {
		// Test 1. Árbol Binario equilibrado
		
		BinaryTree<Integer> tA8 = BinaryTree.leaf(8);
		BinaryTree<Integer> tA10 = BinaryTree.leaf(10);
		BinaryTree<Integer> tA16 = BinaryTree.binary(16, tA8, tA10);
		
		BinaryTree<Integer> tA23 = BinaryTree.leaf(23);
		BinaryTree<Integer> tA22 = BinaryTree.leaf(22);
		BinaryTree<Integer> tA7 = BinaryTree.binary(7, tA23, tA22);
		
		BinaryTree<Integer> tA6 = BinaryTree.binary(6, tA16, tA7);
		
		BinaryTree<Integer> tA5 = BinaryTree.leaf(5);
		BinaryTree<Integer> tA11 = BinaryTree.leaf(11);
		BinaryTree<Integer> tA32 = BinaryTree.binary(32, tA5, tA11);
		
		BinaryTree<Integer> tA3 = BinaryTree.leaf(3);
		BinaryTree<Integer> tA76 = BinaryTree.leaf(76);
		BinaryTree<Integer> tA42 = BinaryTree.binary(42, tA3, tA76);
		
		BinaryTree<Integer> tA9 = BinaryTree.binary(9, tA32, tA42);
		
		BinaryTree<Integer> tA30 = BinaryTree.binary(30, tA6, tA9);
		
		System.out.println("TEST 1: Árbol Binario equilibrado");
		System.out.println("=================================");
		System.out.println("¿Árbol binario equilibrado? " + Metodos138.estaEquilibrado(tA30));
		System.out.println();
		
		// Test 2. Árbol Binario no equilibrado
		
		BinaryTree<Integer> tB14 = BinaryTree.leaf(14);
		BinaryTree<Integer> tB33 = BinaryTree.leaf(33);
		BinaryTree<Integer> tB3 = BinaryTree.binary(3, tB14, tB33);
		
		BinaryTree<Integer> tB6 = BinaryTree.leaf(6);
		BinaryTree<Integer> tB16 = BinaryTree.binary(16, tB6, tB3);
		
		BinaryTree<Integer> tBE = BinaryTree.empty();
		BinaryTree<Integer> tB4 = BinaryTree.binary(4, tBE, tB16);
		
		System.out.println("TEST 2: Árbol Binario equilibrado");
		System.out.println("=================================");
		System.out.println("¿Árbol binario equilibrado? " + Metodos138.estaEquilibrado(tB4));
		
	}

}
