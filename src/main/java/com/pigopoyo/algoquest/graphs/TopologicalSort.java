package com.pigopoyo.algoquest.graphs;

import java.util.*;


public class TopologicalSort {

    public static List<Integer> sort(Graph graph){
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);
            if (indegree == 0) {
                queue.add(vertex);
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()){
            // Dequeue of the nodes from the list if there are more than one.
            // If more than one element exists then it means that the graph
            // has more than one topological sort solution.
            int vertex = queue.pollLast();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int adjacentVertex : adjacentVertices) {
                int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
                indegreeMap.remove(adjacentVertex);
                indegreeMap.put(adjacentVertex, updatedIndegree);

                if (updatedIndegree == 0) {
                    queue.add(adjacentVertex);
                }
            }
        }

        if (sortedList.size() != graph.getNumVertices()) {
            throw new RuntimeException("The Graph had a cycle!");
        }

        return  sortedList;
    }


    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        graph1.addEdge(2, 7);
        graph1.addEdge(0, 3);
        graph1.addEdge(0, 4);
        graph1.addEdge(0, 1);
        graph1.addEdge(2, 1);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 5);
        graph1.addEdge(3, 6);
        graph1.addEdge(4, 7);

        printList(sort(graph1));
    }

    public static void printList(List<Integer> list) {
        for (int v : list) {
            System.out.println(v + ", ");
        }
    }
}
