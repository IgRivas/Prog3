package tp1;

import java.util.Iterator;

public class Iterador<T>  implements Iterator<T> {
	
	private Node<T> iterador;
	
	public Iterador(Node<T> n){
		this.iterador= n;
	}
	@Override
	public boolean hasNext() {
	
		return this.iterador!= null;
	}

	@Override
	public T next() {
		T toReturn = this.iterador.getInfo();
		this.iterador = this.iterador.getNext();
		return toReturn;
	}
	
	public T getElemento() {
		return this.iterador.getInfo();
	}
	

}
