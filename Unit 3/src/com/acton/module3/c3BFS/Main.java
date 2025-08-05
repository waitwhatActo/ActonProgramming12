package com.acton.module3.c3BFS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Node> graph;
    public static void main(String[] args) throws FileNotFoundException {
        long start =  System.currentTimeMillis();
        setupTree();
        BFS();
        long end =  System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + "ms");
    }

    private static void BFS() {
        StringBuilder order = new StringBuilder();
        LinkedList<Node> queue = new LinkedList<Node>();
        graph.getFirst().setVisited(true);
        queue.add(graph.getFirst());
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            order.append(node.getKey()).append(" ");
            for (Integer i : node.getNodes()) {
                for (Node n : graph) {
                    if (n.getKey() == i) {
                        if (!n.isVisited()) {
                            n.setVisited(true);
                            queue.add(n);
                        }
                    }
                }
            }
        }
        System.out.println(order);
    }

    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("Unit 3\\src\\com\\acton\\module3\\c3BFS\\treeExtended.txt"));
        while(scan.hasNext()){
            parseLine(scan.nextLine());
        }
    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(Integer.parseInt(keys[0]), points));
    }
}