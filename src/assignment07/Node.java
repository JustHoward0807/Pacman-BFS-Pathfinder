package assignment07;

import java.util.ArrayList;

public class Node {
    public char _data;
    public boolean visited = false;
    public ArrayList<Node> neighbors = new ArrayList<>();
    public Node cameFrom;

    Node(char data) {
        this._data = data;
    }
}
