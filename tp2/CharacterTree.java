package tp2;

import java.util.ArrayList;

public class CharacterTree {

	private Character value;
	private CharacterTree left;
	private CharacterTree right;

	public CharacterTree(char value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public Character getValue() {
		return value;
	}

	public void add(Character newValue) {
	    if (newValue.compareTo(this.value) < 0) {
	        if (this.left == null)
	            this.left = new CharacterTree(newValue);
	        else
	            this.left.add(newValue);
	    } else if (newValue.compareTo(this.value) > 0) {
	        if (this.right == null)
	            this.right = new CharacterTree(newValue);
	        else
	            this.right.add(newValue);
	    }
	}

	public Character getRoot() {
		Character toReturn = null;
		if (this.value != null) {
			toReturn = this.value;
		}
		return toReturn;
	}

	public void imprimirPreOrden() {

		// siempre que me encuentro con un valor nulo, imprimo un guion
		if (this.value == null) {
			System.out.println("-");
		} else {

			// si el arbol no esta vacio, imprimo el primer valor con el que me encuentro
			System.out.println(this.value);

			// se verifica si su izq no es nula para pedirle que se imprima su valor
			if (this.left != null) {
				this.left.imprimirPreOrden();
			} else
				System.out.println("-");

			// se verifica si su derecha no es nula para pedirle que se imprima su valor
			if (this.right != null) {
				this.right.imprimirPreOrden();
			} else
				System.out.println("-");
		}
	}
	public void imprimirPostOrder(){
		if(this.left != null){
			this.left.imprimirPostOrder();
		}
		if(this.right!= null){
			this.right.imprimirPostOrder();
		}
		System.out.println(this.value);
		if(this.left== null && this.right == null){
			System.out.println("-");
		}
	}
	
	public void imprimirInOrder(){
		if(this.left != null){
			this.left.imprimirInOrder();
		}
		System.out.println(this.value);
		if(this.right != null){
			this.right.imprimirInOrder();
		}
		
	}
	


	
	
	

	
	
	public ArrayList<String> getWordsWithNvocales(int n){
		ArrayList<String> result = new ArrayList<>();
		String palabra ="";
		getPalabras(this,n,result,palabra);		
		return result;
	}
	
	public void getPalabras(CharacterTree t,int n, ArrayList<String> result, String palabra){
		if(t==null){
			return;
		}
		if(t!= null){
			palabra = palabra+ t.getValue();
		}
		if(t.left == null && t.right==null){
			if(contarVocales(palabra)==n ){
				result.add(palabra);
			}
		}else {
			getPalabras(t.left, n, result,palabra);
			getPalabras(t.right, n, result, palabra);
		}
		
	}

	private int contarVocales(String palabra) {
        int cantidadVocales = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (esVocal(c)) {
                cantidadVocales++;
            }
        }
        return cantidadVocales;
    }
 private boolean esVocal(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

	
}