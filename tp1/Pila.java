package tp1;

public class Pila {
	private MySimpleLinkedList lista;
	
	public <T> Pila(){
		this.lista = new MySimpleLinkedList<T>();
		
	}
	
	public void push(T info){
		this.lista.insertFront(info);
	}
	
}
