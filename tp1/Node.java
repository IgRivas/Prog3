package tp1;

public class Node<T> {

	private T info;
	private Node<T> next;
	private Node<T> prev;


	public Node() {
		this.info = null;
		this.next = null;
	}
	
	public Node(T info, Node<T> next) {
		this.setInfo(info);
		this.setNext(next);
	}
	public Node(T info, Node<T> next, Node<T> last) {
		this.setInfo(info);
		this.setNext(next);
		this.prev =last;
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	public void setprev(Node<T> prev){
		this.prev= prev;
	}

	public T getInfo() {
		return info;
		
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	@Override  
	public String toString(){
		String s = " ";
		s += this.getInfo();
		return s;
		
	}
	@Override 
	public boolean equals(Object info){
		return info==this.getInfo();
		
	}
	
	}




