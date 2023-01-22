package assignment07;

public class Graph {
    public Node[][] matrix;
    public Node start;
    public Node goal;

    Graph(int rowSize, int heightSize) {
        matrix = new Node[heightSize][rowSize];
    }
}
