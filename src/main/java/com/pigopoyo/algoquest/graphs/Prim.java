package com.pigopoyo.algoquest.graphs;

import javafx.util.Pair;

import java.util.*;


public class Prim {

    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 2);
        graph1.addEdge(0, 4, 2);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 1);
        graph1.addEdge(3, 6, 3);
        graph1.addEdge(4, 7, 22);
        graph1.addEdge(7, 5, 4);

        spanningTree(graph1, 0);
    }

    public static void spanningTree(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
            }
        });

        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);
        vertexInfoMap.put(source, sourceVertexInfo);

        Set<String> spanningTree = new HashSet<>();
        Set<Integer> visitedVertices = new HashSet<>();

        while (!queue.isEmpty()) {
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();

            // Do not re-visit vertices which are already part of the
            // tree.
            if (visitedVertices.contains(currentVertex)) {
                continue;
            }
            visitedVertices.add(currentVertex);

            // If the current vertex is a source we do not have an edge
            // yet.
            if (currentVertex != source) {
                String edge = String.valueOf(currentVertex)
                        + String.valueOf(distanceTable.get(currentVertex).getLastVertex());
                if (!spanningTree.contains(edge)) {
                    spanningTree.add(edge);
                }
            }

            for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
                int distance = graph.getWeightedEdge(currentVertex, neighbour);

                // If we find a new shortest path to the neighbour update
                // the distance and the last vertex.
                if (distanceTable.get(neighbour).getDistance() > distance) {
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);

                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null) {
                        queue.remove(neighbourVertexInfo);
                    }

                    neighbourVertexInfo = new VertexInfo(neighbour, distance);
                    vertexInfoMap.put(neighbour,neighbourVertexInfo);
                    queue.add(neighbourVertexInfo);
                }
            }
        }

        for (String edge : spanningTree) {
            System.out.println(edge);
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
            // The initial distance to all nodes is assumed
            // infinite.
            distance = Integer.MAX_VALUE;
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


    /**
     * A simple class which holds the vertex id and the weight of
     * the edge that leads to that vertex from its neighbour
     */

    public static class VertexInfo {

        private int vertexId;
        private int distance;

        public VertexInfo(int vertexId, int distance) {
            this.vertexId = vertexId;
            this.distance = this.distance;
        }

        public int getVertexId() {
            return vertexId;
        }

        public int getDistance() {
            return distance;
        }
    }

}


