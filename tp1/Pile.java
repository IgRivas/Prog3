package tp1;

public class Pile<T> {
	private MySimpleLinkedList<T> lista;
	
	public Pile(){
		this.lista = new MySimpleLinkedList<>();
		
	}
	
	
	public void push(T info){
		this.lista.insertFront(info);
		
	}
	
	public T pop(){
		return this.lista.extractFront();
		
	}
	public T top(){
		return this.lista.get(0);
	}
	
	public void reverse(){
		MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
		int cursor = this.lista.size();
		while(aux.size()< cursor){
			aux.insertFront(this.lista.extractFront());
		
		}
		this.lista = aux;
		
	}
	public int indexOf(T elemento){
		return this.lista.indexOf(elemento);
	}
	@Override 
	public String toString(){
		return this.lista.toString();
	}
	
	
}
