import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tang on 1/4/15.
 */
public class TrieNode {
    private Map<String, TrieNode> children;
    private Set<String> words;

    public TrieNode() {
        children = new HashMap<String, TrieNode>();
        words = new HashSet<String>();
    }

    public void addNode(String text) {
        _addNode(text, text);
    }

    private void _addNode(String text, String remaining) {
        if (remaining.isEmpty()) {
            words.add(text);
            return;
        }

        String character = remaining.charAt(0) + "";
        TrieNode child = children.get(character);

        if (child == null) {
            child = new TrieNode();
            children.put(character, child);
        }

        child._addNode(text, remaining.substring(1));
    }
}
