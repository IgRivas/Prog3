package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GrafoDirigido<T> implements Grafo<T> {
	//Cada clave integer hace referencia a un vertice con valor de tipo NodoGrafo.
	//
	private HashMap<Integer, HashMap<Integer,T>> vertices;
	
	
	public GrafoDirigido(){
	this.vertices = new HashMap<>();	
	}
	
	//Vertice Id es el vertice en si
	public void agregarVertice(int verticeId) {
		//Chequea si la clave existe en el map
		if(!vertices.containsKey(verticeId)){
			//No me deja hacer put.(verticeId, new HashMap<>())... Unica solucion encontrada 
			HashMap<Integer,T> arco= new HashMap<>();
			vertices.put(verticeId, arco);
			System.out.println("ingresado");
		}else 
			System.out.println("El verticeID "+verticeId+ " ya existe");
		

	}

	@Override
	//Elimina un vertice si es que este existe/ Debemos eliminar tambien arcos entrantes y salientes
	public void borrarVertice(int verticeId) {
		if(vertices.containsKey(verticeId)){	
			//Si existe el vertice buscado, debemoss recorrer todos los vertices y preguntar
			//si este se encuentra en su lista de adyacentes, para que no queden arcos apuntando a la nada
			for(int v: this.vertices.keySet()){ 
				//KeySet() nos devuelve un conjunto de todas las claves del hashmap
				HashMap<Integer, T> ady = this.vertices.get(v);
				if(ady.containsKey(verticeId)){
					//Si cada vertice contiene a el vertice a eliminar elmino el arco que los une
					borrarArco(v,verticeId);
				}
				//Una vez eliminado los arcos, elimo el vertice
				this.vertices.remove(verticeId);
			}	
		}
		System.out.println("El vertice no existe");
	}

	@Override
	//
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		//Buscamos el espacio para agregar el arco al vertice corrspondiente
		HashMap<Integer,T> arco = this.vertices.get(verticeId1);
		if(!this.vertices.containsKey(verticeId2)){
			Arco<T> arcoNuevo = new Arco<T>(verticeId1,verticeId2,etiqueta);
			arco.put(verticeId2, (T) arcoNuevo);
		}
		else System.out.println("El arco ya existe");
	}
	
	
	

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		//Map Interno donde almacenamos los arcos. 
		HashMap<Integer,T> aux = this.vertices.get(verticeId1);
		if(this.existeArco(verticeId1, verticeId2)){
			//DUDA!?
			aux.remove(verticeId2);
		}
	}
	

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.containsKey(verticeId);
	
	}

	@Override
	public boolean existeArco(int origen, int destino) {
		HashMap<Integer,T> aux = this.vertices.get(origen);
		return aux.containsKey(destino);
	}

	@Override
	public Arco<T> obtenerArco(int origen ,int destino) {
		Arco<T> toReturn= null;
		if(existeArco(origen, destino)){
			HashMap<Integer, T> aux= this.vertices.get(origen);
			toReturn= new Arco<T>(origen,destino,aux.get(destino));	
		}
		return toReturn;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int cant = 0;
		//KeySet, conjunto de claves, en este caso todos los vertices.
		for(int v: this.vertices.keySet()){
			//Para cada vertice, voy a tener un hasmap con todos los arcos salientes
			HashMap<Integer, T> aux= this.vertices.get(v);
			//Por cada conjunto de arcos salientes, recorro y sumo el contador
			for(int ar : aux.keySet()){
				cant++;
			}
		}	
		return cant;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		HashMap<Integer,T> toReturn = this.vertices.get(verticeId);
		return toReturn.keySet().iterator();
	}

//	@Override
//	public Iterator<Arco<T>> obtenerArcos() {
//		HashMap<Integer, T> arcos = new HashMap<>();
//		for(int v: this.vertices.keySet()){
//				HashMap<Integer, T> aux= this.vertices.get(v);
//				for(int ar : aux.keySet()){
//					arcos.put(ar, null);
//				}
//		}
//		
//		return arcos.keySet().iterator();
//	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		String toReturn= "";
		//el .entrySet() nos da un consjunto de todas las claves y valores
		for (Entry<Integer, HashMap<Integer, T>> entry : this.vertices.entrySet()) {
			toReturn +=  "\n" + entry.getKey() ;
			toReturn += "=";
			toReturn += entry.getValue();			
        }
		return toReturn;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}
}