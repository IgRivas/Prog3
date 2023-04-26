package tp2;

public class Main {

	public static void main(String[] args) {

	
		
		CharacterTree tree = new CharacterTree('F');
		tree.add('G');
		tree.add('A');
		tree.add('C');
		tree.add('D');
		tree.add('B');
		tree.add('E');
		tree.imprimirPreOrden();
		System.out.println(tree.getWordsWithNvocales(2));
		
		
	}
}