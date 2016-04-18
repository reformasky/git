package util;

/**
 * Created by xzhou2 on 4/14/16.
 */
public class TrieNode{
    boolean end;
    TrieNode[] nexts;

    public TrieNode() {
        end = false;
        nexts = new TrieNode[26];
    }

    public void setEnd(boolean e) {
        end = e;
    }

    public boolean isEnd() {
        return end;
    }

    public void set(char c) {
        nexts[c - 'a'] = new TrieNode();
    }

    public TrieNode get(char c) {
        return nexts[c - 'a'];
    }

    public TrieNode[] getNexts() {
        return nexts;
    }

    public TrieNode addString(String s) {
        TrieNode node = this;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.get(c) == null) {
                node.set(c);
            }
            node = node.get(c);
        }
        node.setEnd(true);

        return this;
    }

    public static boolean search(TrieNode node, char[] arr, int beginIndex) {
        if (node == null) {
            return false;
        }
        if (beginIndex == arr.length) {
            return node.isEnd();
        }
        char c = arr[beginIndex];
        if (c == '.') {
            for(TrieNode n : node.getNexts()) {
                if (search(n, arr, beginIndex + 1)) {
                    return true;
                }
            }
            return false;
        }
        else {
            return search(node.get(c), arr, beginIndex + 1);
        }
    }
}