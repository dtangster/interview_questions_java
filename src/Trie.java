/**
 * Created by tang on 1/4/15.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String text) {
        root.addNode(text);
    }

    public static void main(String [] args) {
        Trie trie = new Trie();
        trie.addWord("cat");
        trie.addWord("car");
        trie.addWord("castle");
        trie.addWord("cast");
        System.out.println();
    }
}
