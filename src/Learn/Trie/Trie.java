package Learn.Trie;


import java.util.HashMap;
import java.util.Map;

class Trie {

    class TrieNode {

        public boolean flag;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();

    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {

        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            if(current.childrenMap.get(c) == null)
                current.childrenMap.put(c, new TrieNode());

            current = current.childrenMap.get(c);

        }
        current.flag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            if(current.childrenMap.get(c) == null)
                return false;

            current = current.childrenMap.get(c);
        }
        return current.flag;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++) {

            char c = prefix.charAt(i);
            if(current.childrenMap.get(c) == null)
                return false;

            current = current.childrenMap.get(c);
        }
        return true;
    }
}
