package util;

/**
 * Created by  on 4/13/16.
 */


public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.addString(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = findEndNode(word);
        if (node == null || !node.isEnd()) {
            return false;
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return findEndNode(prefix) != null;
    }

    private TrieNode findEndNode(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.get(c) != null) {
                node = node.get(c);
            }
            else {
                return null;
            }
        }
        return node;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("");
// trie.search("key");
