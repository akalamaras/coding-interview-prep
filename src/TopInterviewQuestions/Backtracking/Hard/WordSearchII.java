package TopInterviewQuestions.Backtracking.Hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    // Creates a trie from the words in our array
    public TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();
        for(String w: words) {

            TrieNode p = root;
            for(char ch : w.toCharArray()) {
                int i = ch - 'a';
                if(p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++)
                backtrack(board, i, j, root, ans);
        }
        return ans;
    }

    private void backtrack(char[][] board, int i, int j, TrieNode node, List<String> ans) {

        char ch = board[i][j];

        if(ch == '#' || node.next[ch - 'a'] == null)
            return;

        node = node.next[ch - 'a'];

        // Found a word in the trie
        if(node.word != null) {
            ans.add(node.word);
            node.word = null; // Remove it to ensure no duplicates
        }

        // Signifies visited node
        board[i][j] = '#';

        // Branching
        if(i > 0)                    backtrack(board, i - 1, j, node, ans);
        if(i < board.length - 1)     backtrack(board, i + 1, j, node, ans);
        if(j > 0)                    backtrack(board, i, j - 1, node, ans);
        if(j < board[0].length - 1)  backtrack(board, i, j + 1, node, ans);

        // 'De-visit' the node
        board[i][j] = ch;
    }
}
