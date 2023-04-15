package tp1;

import java.util.Comparator;
import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{
	private Node<T> first;
	private Node<T> last;
	private int size;
	private Comparator<T> comparador;

	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
		this.size =0;
		
	}
	
	
	public DoublyLinkedList(Comparator comparador) {
		this.first = null;
		this.last = null;
		this.size =0;
		this.comparador= comparador;
		
	}

	
	public void insertFront(T info) { //Si la lista no esta vacia, el siguiente del nuevo nodo sera first,el prev de first sera nuevo y first sera nuevo
		if(!this.isEmpty()){
			Node<T> tmp = new Node<T>(info,null,null);	
			tmp.setNext(this.first);
			this.first.setprev(tmp);
			this.first = tmp;
			this.size ++;
		}
		else
		this.first = new Node<T>(info,null,null);
		this.last =first;
	}
	
	
	public T extractFront() {
		T aux = this.first.getInfo();
		this.first = this.first.getNext();
		this.first.setprev(null);
		this.size--;
		return aux;
	}
	
	public T get(int index) {//si la lista no esta vacia, recorro la lista hasta que encuentro la posicion y retorno su valor.
		if(!isEmpty()){
			int aux = 0;
			Node<T> temp = this.first;
			while(aux < index){
				if(temp.getNext()!= null){
					temp = temp.getNext();
					aux++;
				}
			}
		return temp.getInfo();
		}
		return null;
	}
	
	
	public int indexOf(T elemento) {
		Node<T>tmp = this.first;
		int aux = 0;
		if(!this.isEmpty()) {
			while(!tmp.getInfo().equals(elemento)) {
				tmp = tmp.getNext();
				aux++;
			}
		}
		return aux;
	}
	
	
	public boolean isEmpty() {
		// TODO
		return(this.first == null);
	}
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

