import java.util.HashMap;
import java.util.Map;

public class Graph {
    private int keyIncrementer;
    private Map<Integer, GraphNode> nodes;

    public Graph() {
        keyIncrementer = 1;
        nodes = new HashMap<Integer, GraphNode>();
    }

    public GraphNode addNode() {
        GraphNode node = new GraphNode(keyIncrementer++);

        return node;
    }

    public GraphNode addNodeWithWeight(int weight) {
        GraphNode node = new GraphNode(keyIncrementer++, weight);

        return node;
    }
}
