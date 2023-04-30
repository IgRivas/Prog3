package tp3;
/*
 * 	NodoGrafo, seran los vertices de nuestro grafo.
 * Al elegir trabajar con una lista de listas adyacentes, vamos a necesitar por cada vertice, guardar su lista de adyacentes
 */
import java.util.LinkedList;

public class NodoGrafo {
	 private int valor;
	 private LinkedList<NodoGrafo> adyacentes;
	 
	 public NodoGrafo(int valor){
		 this.valor= valor;
		 this.adyacentes = new LinkedList<>();
		 
	 }
	 public NodoGrafo(){
		 this.adyacentes = new LinkedList<>();
		 
	 }
	 //
	 public <T> void addAdyacente(Arco arco){
		 
	 }

}
