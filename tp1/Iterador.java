package tp1;

import java.util.Iterator;

public class Iterador  implements Iterator {
	
	private Node iterador;
	
	public Iterador(Node n){
		this.iterador= n;
	}
	@Override
	public boolean hasNext() {
	
		return this.iterador!= null;
	}

	@Override
	public Object next() { // Retorno el nodo en el que estoy y paso al siguiente
		Node toReturn = this.iterador;
		this.iterador = this.iterador.getNext();
		return toReturn;
	}
	

}
