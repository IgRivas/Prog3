package tp3;
/*
 * 	NodoGrafo, seran los vertices de nuestro grafo.
 * Al elegir trabajar con una lista de listas adyacentes, vamos a necesitar por cada vertice, guardar su lista de adyacentes
 */
import java.util.LinkedList;

public class NodoGrafo {
	 private int valor;
	 private LinkedList<Arco> arcos;
	 
	 public NodoGrafo(int valor){
		 this.valor= valor;
		 this.arcos = new LinkedList<>();
		 
	 }
	 public NodoGrafo(){
		 this.arcos = new LinkedList<>();
		 
	 }
	 //
	 public <T> void addArco(Arco arco){
		 arcos.add(arco);
	 }
//	 public <T> void addArco(int origen, int destino, T etiqueta){
//		 Arco arco = new Arco(origen ,destino,etiqueta);
//		 arcos.add(arco);
//	 }
	public void borrarArco(int origen, int destino) {
		//Recorrer la lista de arcos y buscar quien coincida 
		 	Arco aBorrar = null;
		 	for(Arco a : arcos){
		 		if(a.getVerticeDestino()== destino && a.getVerticeOrigen()== origen){
		 			aBorrar = a;
		 		}
		 	}
		 	if(aBorrar != null){
		 		arcos.remove(aBorrar);
		 	}
	}
	public boolean existeArco(int origen, int destino) {
		 for(Arco a : arcos){
	 		if(a.getVerticeDestino()== destino && a.getVerticeOrigen()== origen){
	 			return true;
	 		}
	 		}
	 	return false;
	}
}
