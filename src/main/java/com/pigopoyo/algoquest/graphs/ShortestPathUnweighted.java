package com.pigopoyo.algoquest.graphs;

import java.util.*;


public class ShortestPathUnweighted {


    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        graph1.addEdge(2, 7);
        graph1.addEdge(3, 0);
        graph1.addEdge(0, 4);
        graph1.addEdge(0, 1);
        graph1.addEdge(2, 1);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 5);
        graph1.addEdge(6, 3);
        graph1.addEdge(4, 7);

        shortestPath(graph1, 1, 7);
    }

    private static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentVertex = queue.pollFirst();
            for (int i : graph.getAdjacentVertices(currentVertex)) {
                int currentDistance = distanceTable.get(i).getDistance();
                if (currentDistance == -1) {
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currentVertex);
                    // Enqueue the neighbour only if it has other adjacent vertices.
                    if (!graph.getAdjacentVertices(1).isEmpty()) {
                        queue.add(i);
                    }
                }
            }

        }
        return distanceTable;
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source
                    + " to node: " + destination);
        }
        else {
            System.out.print("Smallest path is " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " +stack.pop());
            }
            System.out.println(" Shortest Path Unweighted DONE!");
        }
    }

    /**
     * A class which holds the distance information of any vertex.
     * The distance specified is the distance from the source node
     * and the last vertex is the last vertex just before the current
     * one while traversing from the source node.
     */
    public static class DistanceInfo {

        private int distance;
        private int lastVertex;

        public DistanceInfo() {
            distance = -1;
            lastVertex = -1;
        }

        public int getDistance() {
            return distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }
    }
}
