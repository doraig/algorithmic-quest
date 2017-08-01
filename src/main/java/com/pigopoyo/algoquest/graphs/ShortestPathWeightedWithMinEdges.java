package com.pigopoyo.algoquest.graphs;

import java.util.*;


public class ShortestPathWeightedWithMinEdges {

    public static void main(String[] args) {
        Graph graph =  new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        graph.addEdge(0, 1, 6);
        graph.addEdge(1, 4, 3);
        graph.addEdge(0, 3, 1);
        graph.addEdge(3, 2, 2 );
        graph.addEdge(2, 1, 3);

        shortestPath(graph, 0, 4);
    }

    public static Map<Integer, DistanceEdgeInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceEdgeInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                 if (v1.getDistance().compareTo(v2.getDistance()) != 0) {
                     return  v1.getDistance().compareTo(v2.getDistance());
                 }
                 return v1.getNumEdges().compareTo(v2.getNumEdges());
            }
        });

        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceEdgeInfo());
        }

        distanceTable.get(source).setInfo(source, 0 /* distance */, 0 /* numEdges */);

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0, 0);
        queue.add(sourceVertexInfo);

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        vertexInfoMap.put(source, sourceVertexInfo);

        while (!queue.isEmpty()) {
            VertexInfo currentVertexInfo = queue.poll();

            for (Integer neighbour : graph.getAdjacentVertices(currentVertexInfo.getVertexId())) {
                // Get the distance and number of edges from the current vertex to the neighbour.
                int distance = distanceTable.get(currentVertexInfo.getVertexId()).getDistance()
                        + graph.getWeightedEdge(currentVertexInfo.getVertexId(), neighbour);
                int edges = distanceTable.get(currentVertexInfo.getVertexId()).getNumEdges() + 1;

                int neighbourDistance = distanceTable.get(neighbour).getDistance();
                if (neighbourDistance > distance || ((neighbourDistance == distance)
                        && (distanceTable.get(neighbour).getNumEdges() > edges))) {

                    // Update the distance table for the neighbour with the new information.
                    distanceTable.get(neighbour).setInfo(
                            currentVertexInfo.getVertexId(), distance, edges);

                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null) {
                        queue.remove(neighbourVertexInfo);
                    }

                    // Set up the updated neigbour vertex info with the new distance
                    // and number of edges.
                    neighbourVertexInfo = new VertexInfo(neighbour, distance, edges);
                    queue.add(neighbourVertexInfo);
                    vertexInfoMap.put(neighbour, neighbourVertexInfo);
                }
            }

        }

        return distanceTable;
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceEdgeInfo> distanceTable = buildDistanceTable(graph, source);

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
            System.out.print("Smallest Path is " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " +stack.pop());
            }
            System.out.println();
            System.out.println("ShortestPathWeightWithMinEdges DONE!");
        }

    }


    public static class DistanceEdgeInfo {

        private Integer distance;
        private Integer numEdges;
        private Integer lastVertex;

        public DistanceEdgeInfo() {
            distance = Integer.MAX_VALUE;
            lastVertex = -1;
            numEdges = Integer.MAX_VALUE;
        }

        public Integer getDistance() {
            return distance;
        }

        public Integer getLastVertex() {
            return lastVertex;
        }

        public Integer getNumEdges() {
            return numEdges;
        }

        public void setInfo(int lastVertex, int distance, int numEdges) {
            this.distance = distance;
            this.lastVertex = lastVertex;
            this.numEdges = numEdges;
        }
    }

    public static class VertexInfo {

        private Integer vertexId;
        private Integer distance;
        private Integer numEdges;

        public VertexInfo(int vertexId, int distance, int edges) {
            this.vertexId = vertexId;
            this.distance = distance;
            this.numEdges = edges;
        }

        public Integer getVertexId() {
            return vertexId;
        }

        public Integer getDistance() {
            return distance;
        }

        public Integer getNumEdges() {
            return numEdges;
        }
    }
}
