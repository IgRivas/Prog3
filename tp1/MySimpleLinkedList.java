package tp1;

public class MySimpleLinkedList<T>  implements Iterable<T>{
	
	private Node<T> first;
	private int size;
	
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size =0;
	}
	
	public void insertFront(T info) { // first se vuelve el siguiente del nodo temporal y el nodo temporal se vuelve first.
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size ++;
	}
	
	public T extractFront() {	//Si la lista no esta vacia, guardo el valor del ultimo agregado para poder eliminarlo y luego retornarlo.
		if(!this.isEmpty()){
			T aux = this.first.getInfo();
			if(this.first.getInfo()!= null){
				this.first= this.first.getNext();
			}
			this.size--;
			return aux;
		}
		return null;
	}

	public boolean isEmpty() {
		// TODO
		return(this.first == null);
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
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		if(!isEmpty()){
			Node<T> temp =this.first;
			String result = this.first.toString();
			while(temp!=null){
				result+= temp.toString();
				temp = temp.getNext();
				
			}
			return result;
		}
		return null;
	}
	
	
	
	    public int indexOf(T element) {//recorro los nodos de la lista y comparo su valor, cuando coinciden retorno su pos
	        int index = 0;
	        Node<T> temp = this.first;
	        while (temp != null) {
	            if (temp.getInfo().equals(element)) {
	                return index;
	            }
	            temp = temp.getNext();
	            index++;
	        }
	        return -1;
	    }
	    
	    @Override
		public Iterador iterator() {
			Iterador i = new Iterador(this.first); 
			return i;
		}
	 }
