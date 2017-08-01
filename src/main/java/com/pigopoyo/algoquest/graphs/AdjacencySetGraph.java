package com.pigopoyo.algoquest.graphs;


import java.util.ArrayList;
import java.util.List;


public class AdjacencySetGraph implements Graph {

    private List<Node> vertexList = new ArrayList<>() ;
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices =0;

    public AdjacencySetGraph(int  numVertices, GraphType graphType )  {
        this.graphType = graphType;
        this.numVertices = numVertices;

        for (int i = 0; i < numVertices; i++ ) {
            vertexList.add(new Node(i));
        }
    }

  public GraphType TypeofGraph(){
        return graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= numVertices || v2 >= numVertices || v1 < 0 || v2 < 0) {
            throw new  IllegalArgumentException("Vertex number is not valid");
        }
        vertexList.get(v1).addEdge(v2);
        if(graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        throw new IllegalArgumentException("Weight not implemented in Adjacency Set");
    }

    @Override
    public int getWeightedEdge(int v1, int v2) {
        throw new IllegalArgumentException("Weight not implemented in Adjacency Set");
    }

    @Override
    public List<Integer> getAdjacentVertices(int v){
        if (v < 0 ||  v >= numVertices) {
            throw new  IllegalArgumentException("Vertex number is not valid");
        }
        return vertexList.get(v).getAdjacentVertices();
    }

    @Override
    public int getIndegree(int v){
        if (v < 0 ||  v >= numVertices) {
            throw new  IllegalArgumentException("Vertex number is not valid");
        }
        int indegree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (getAdjacentVertices(i).contains(v)) {
                indegree++;
            }
        }
        return indegree;
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }
}
