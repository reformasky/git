package util;

/**
 * Created by xzhou2 on 4/14/16.
 */
public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
        root.setEnd(true);
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        root.addString(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return TrieNode.search(root, word.toCharArray(), 0);
    }
}
