package com.pigopoyo.algoquest.graphs;

import javafx.util.Pair;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        List<String> Courses = new ArrayList<>();
        Courses.add("CS100");
        Courses.add("CS101");
        Courses.add("CS102");
        Courses.add("CS103");
        Courses.add("CS104");
        Courses.add("CS105");

        Map<String, List<String>> prereqs = new HashMap<>();
        List<String> list = new ArrayList<>();

        list.add("CS101");
        list.add("CS102");
        list.add("CS103");
        prereqs.put("CS100", list);

        list = new ArrayList<>();
        list.add("CS104");
        prereqs.put("CS102", list);

        list = new ArrayList<>();
        list.add("CS105");
        prereqs.put("CS103", list);

        List<String> courseSchedule = order(Courses, prereqs);
        System.out.println("Valid schedule for CS Students");

        for (String course : courseSchedule) {
            System.out.println(course);
        }
    }

    public static List<String> order(List<String> courseList, Map<String, List<String>> prereqs) {
        Graph courseGraph = new AdjacencyMatrixGraph(courseList.size(), Graph.GraphType.DIRECTED);

        Map<String, Integer> courseIdMap = new HashMap<>();
        Map<Integer, String> idCourseMap = new HashMap<>();

        for(int i = 0; i < courseList.size(); i++) {
            courseIdMap.put(courseList.get(i), i);
            idCourseMap.put(i, courseList.get(i));
        }

        for (Map.Entry<String, List<String>> prereq : prereqs.entrySet()) {
            for (String course : prereq.getValue()) {
                courseGraph.addEdge(courseIdMap.get(prereq.getKey()),
                        courseIdMap.get(course));
            }
        }

        List<Integer> courseIdList =  TopologicalSort.sort(courseGraph);

        List <String> courseScheduleList =  new ArrayList<>();

        for (int courseId : courseIdList) {
            courseScheduleList.add(idCourseMap.get(courseId));
        }

        return courseScheduleList;
    }
}