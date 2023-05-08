package tp3;

import java.util.HashMap;
import java.util.List;





public class Main {
	public static void main(String[]args) {
	GrafoDirigido<Object> grafo = new GrafoDirigido();
		grafo.agregarVertice(3);
		grafo.agregarVertice(8);
		grafo.agregarVertice(7);
		grafo.agregarVertice(10);
		grafo.agregarVertice(9);
		
		grafo.agregarArco(3, 8, "");
		grafo.agregarArco(3, 10, "");
		grafo.agregarArco(8,9, "");
		grafo.agregarArco(7,8, "");

		
		HashMap<Integer, Boolean> hash = new HashMap<>();
		
		
		ServicioBFS bfs = new ServicioBFS(grafo);
		List<Integer>auxBfs = bfs.bfsForest();
		System.out.println(auxBfs);
}
}
