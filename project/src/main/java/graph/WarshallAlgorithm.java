package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class WarshallAlgorithm<T> implements Graph<T> {

    private List<List<T>> adjacencyList;
    private List<T> vertexList;
    int edges;

    public WarshallAlgorithm() {
        adjacencyList = new ArrayList<>();
        vertexList = new ArrayList<>();
    }

    @Override
    public void addVertex(T x) {
        if (!vertexList.contains(x)) {
            vertexList.add(x);
            adjacencyList.add(new ArrayList<>());
        } else {
            System.out.println("El vertice " + x + " ya se encuentra en el grafo");
        }
    }

    @Override
    public void removeVertex(T x) {
        if (vertexList.contains(x)) {
            int pos = vertexList.indexOf(x);
            vertexList.remove(pos);
            adjacencyList.remove(pos);
            for (List<T> successors : adjacencyList) {
                successors.remove(x);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasVertex(T v) {
        return vertexList.contains(v);
    }

    @Override
    public List<T> getVertexes() {
        return vertexList;
    }

    @Override
    public void addEdge(T v, T w) {
        if (hasVertex(v) && hasVertex(w)) {
            int indexV = vertexList.indexOf(v);
            adjacencyList.get(indexV).add(w);
            edges++;
        }
    }

    @Override
    public void removeEdge(T v, T w) {
        if (hasVertex(v) && hasVertex(w)) {
            int indexV = vertexList.indexOf(v);
            adjacencyList.get(indexV).remove(w);
            edges--;
        }
    }

    @Override
    public boolean hasEdge(T v, T w) {
        if (hasVertex(v) && hasVertex(w)) {
            int indexV = vertexList.indexOf(v);
            return adjacencyList.get(indexV).contains(w);
        } else {
            return false;
        }
    }

    @Override
    public int order() {
        return vertexList.size();
    }

    @Override
    public int alpha() {
        return edges;
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        return adjacencyList.get(vertexList.indexOf(v));
    }

    public List<List<T>> warshallAlgorithm() {
        List<List<T>> clausure = new ArrayList<>();
        for(int k=0;k<order();k++){
            clausure.add(new ArrayList<>());
            List<T> explored = new ArrayList<>();
            //explored.add(vertexList.get(k)); Para agregar o no a si mismo
            Explore(k,k,explored,clausure);
            System.out.println("\nPaso "+k+":");
            ListToString(clausure);
        }
        return clausure;
    }

    private void Explore(int row, int k, List<T> explored, List<List<T>> clausure) {
        List<T> list = adjacencyList.get(k);
        for (int i = 0; i < list.size(); i++) {
            if (!explored.contains(list.get(i))) {
                clausure.get(row).add(list.get(i));
                explored.add(list.get(i));
                int z = vertexList.indexOf(list.get(i));
                Explore(row, z, explored, clausure);
            }
        }
    }

    public List<List<T>> getList(){
        return adjacencyList;
    }


    public  void ListToString(List<List<T>> ady){
        for(int i = 0 ; i< ady.size(); i++){
            String variable = "";
            if(!ady.get(i).isEmpty()){
            variable +=ady.get(i).get(0);}
            for (int j=1 ;j<ady.get(i).size();j++){
                variable += ","+ady.get(i).get(j);
            }
            System.out.println(vertexList.get(i)+":["+variable+"]");
        }
    }
}