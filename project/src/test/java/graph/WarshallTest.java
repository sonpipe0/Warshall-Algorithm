package graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;  // Importing assertEquals
import java.util.ArrayList;
import java.util.List;

public class WarshallTest {

    @Test
    public void testSize(){
        WarshallAlgorithm<Integer> warshall = new WarshallAlgorithm<>();
        for(int i = 0 ; i <10 ; i++){
            assertEquals(warshall.order(),i);
            warshall.addVertex(i);
        }
    }

    @Test
    public void removeVertexTest(){
        WarshallAlgorithm<Integer> warshall = new WarshallAlgorithm<>();
        for(int i = 0 ; i <10 ; i++){
            assertEquals(warshall.order(),i);
            warshall.addVertex(i);
        }

        for(int i = 0; i<10; i++){
            assertEquals(warshall.order(),10-i);
            warshall.removeVertex(i);
        }
        assertEquals(warshall.order(),0);
    }

    @Test
    public void addEdge(){
        WarshallAlgorithm<Character> warshall = new WarshallAlgorithm<>();

        for(char i = 'a'; i <='d' ; i++){
            warshall.addVertex(i);
        }

        warshall.addEdge('a', 'b');
        warshall.addEdge('b', 'c');
        warshall.addEdge('d', 'c');
        warshall.addEdge('c', 'd');

        List<List<Character>> matrizEsperada = new ArrayList<>(4);

        for (char i = 'a'; i <= 'd'; i++) {
            matrizEsperada.add(new ArrayList<>(4));
        }


        matrizEsperada.get(0).add('b');
        matrizEsperada.get(1).add('c');
        matrizEsperada.get(2).add('d');
        matrizEsperada.get(3).add('c');

        assertEquals(matrizEsperada, warshall.getList());
    }

    @Test
    public void warshallTest(){

        WarshallAlgorithm<Character> warshall = new WarshallAlgorithm<>();
        List<Character> listaVerticesEsperado = new ArrayList<>(4);
        for(char i='a'; i<='d'; i++){
            listaVerticesEsperado.add(i);
            warshall.addVertex(i);
        }

        warshall.addEdge('a', 'b');
        warshall.addEdge('b', 'c');
        warshall.addEdge('d', 'c');
        warshall.addEdge('c', 'd');

        System.out.println("Lista de vertices: " + listaVerticesEsperado);
        System.out.println("Lista de adyacencia: ");
        warshall.ListToString(warshall.getList());
        System.out.println("Lista de clausura: ");
        warshall.warshallAlgorithm();
    }

    @Test
    public void warshallTest2(){
        WarshallAlgorithm<Character> warshall = new WarshallAlgorithm<>();
        List<Character> listaVerticesEsperado = new ArrayList<>(5);
        for(char i='a'; i<='e'; i++){
            listaVerticesEsperado.add(i);
            warshall.addVertex(i);
        }

        warshall.addEdge('a', 'b');
        warshall.addEdge('b', 'c');
        warshall.addEdge('c', 'd');
        warshall.addEdge('d', 'e');

        System.out.println("Lista de vertices: " + listaVerticesEsperado);
        System.out.println("Lista de adyacencia: ");
        warshall.ListToString(warshall.getList());
        System.out.println("Lista de clausura: ");
        warshall.warshallAlgorithm();
    }
}
