import java.util.HashMap;
import java.util.Map;

public class GraphNode {
    private int key;
    private int weight;
    private int timeVisited;
    private Status status;
    private GraphNode parent;
    private Map<Integer, GraphNode> adjacencyList;

    public enum Status {
        UNVISITED, VISITED, COMPLETED
    }

    public GraphNode(int key) {
        this.key = key;
        weight = 0;
        timeVisited = 0;
        status = Status.UNVISITED;
        parent = null;
        adjacencyList = new HashMap<Integer, GraphNode>();
    }

    public GraphNode(int key, int weight) {
        this.key = key;
        this.weight = weight;
        timeVisited = 0;
        status = Status.UNVISITED;
        parent = null;
        adjacencyList = new HashMap<Integer, GraphNode>();
    }

    public GraphNode getAdjacentNode(GraphNode node) {
        return adjacencyList.get(node);
    }

    public void addEdge(GraphNode node) {
        adjacencyList.put(node.key, node);
    }

    public int getKey() {
        return key;
    }

    public int getWeight() {
        return weight;
    }

    public int getTimeVisited() {
        return timeVisited;
    }

    public GraphNode getParent() {
        return parent;
    }

    public void resetTimeVisit() {
        timeVisited = 0;
    }
}
