package assignment07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class PathFinder {
    public static void solveMaze(String inputFile, String outputFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(inputFile));
        String[] dimensions = sc.nextLine().split(" ");
        if (dimensions[0].equals("") || dimensions[1].equals("") ||dimensions[0].contains("X") || dimensions[1].contains("X") || dimensions[0].contains("S") || dimensions[1].contains("S") || dimensions[0].contains("G") ||
                dimensions[1].contains("G")) {
            return;
        }
        int height = Integer.parseInt(dimensions[0]);
        int width = Integer.parseInt(dimensions[1]);
        System.out.println("Height: " + height);
        System.out.println("Width: " + width);
        Graph g = new Graph(width, height);

        //Using Scanner to extract everything in txt file and put it in graph matrix
        //If that char is 'S' or 'G', we set them as start node and goal node.
        for (int i = 0; i < height; i++) {
            char[] chars = sc.nextLine().toCharArray();
            for (int j = 0; j < width; j++) {
                g.matrix[i][j] = new Node(chars[j]);
                if (chars[j] == 'S') {
                    g.start = g.matrix[i][j];
                }
                if (chars[j] == 'G') {
                    g.goal = g.matrix[i][j];
                }
            }
        }

        //Trying to add every node neighbors if they are not a 'X'.
        //For example, if the matrix data is 'X' then ignore. But if that data is not a 'X', then we find its top, right, bottom and left data. Furthermore, if that data isn't 'X' then add it to the neighbor array of its node.
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
//                System.out.print(g.matrix[i][j]._data);
                if (g.matrix[i][j]._data != 'X') {
                    if (g.matrix[i - 1][j]._data != 'X') {
                        g.matrix[i][j].neighbors.add(g.matrix[i - 1][j]);
                    }
                    if (g.matrix[i + 1][j]._data != 'X') {
                        g.matrix[i][j].neighbors.add(g.matrix[i + 1][j]);
                    }
                    if (g.matrix[i][j + 1]._data != 'X') {
                        g.matrix[i][j].neighbors.add(g.matrix[i][j + 1]);
                    }
                    if (g.matrix[i][j - 1]._data != 'X') {
                        g.matrix[i][j].neighbors.add(g.matrix[i][j - 1]);
                    }
                }

//                System.out.println(g.matrix[i][j].neighbors.size());
            }
//            System.out.println(" ");
        }
        //BFS finding the shortest path and then return same matrix but with dotted path indicates that is a shortest path it found.
        BFS(g.start, g.goal);


        PrintWriter pw = new PrintWriter(outputFile);
        pw.println(height + " " + width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
//                System.out.print(g.matrix[i][j]._data);
                pw.print(g.matrix[i][j]._data);
            }
            pw.println("");
//            System.out.println("");
        }
        pw.flush();


    }

    //Traverse and mark it as visited so it won't go back.
    //Store the node into cameFrom variable so its can traverse back to start node.
    public static void BFS(Node start, Node goal) {
        Queue<Node> q = new LinkedList<>();
        start.visited = true;
        q.add(start);

        while (!q.isEmpty()) {
            Node currentQ = q.poll();
            if (currentQ._data == goal._data) {
                goBackToStart(currentQ.cameFrom);
            }
            for (Node node : currentQ.neighbors) {
                if (!node.visited) {
                    node.visited = true;
                    node.cameFrom = currentQ;
                    q.add(node);
                }
            }
        }
    }

    //Recursive back to the start node.
    //If the cameFrom is a null then its mean it reaches the start node.
    public static void goBackToStart(Node end) {
        //Base case
        if (end.cameFrom == null) {
            return;
        }
        end._data = '.';
        goBackToStart(end.cameFrom);
    }
}
