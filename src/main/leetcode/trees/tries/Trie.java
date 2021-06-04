package main.leetcode.trees.tries;

class Trie {

    class TrieNode {
        //        R links to node children
        private TrieNode[] links;

        private final int size = 26;

        private boolean isWord;

        public TrieNode() {
            links = new TrieNode[size];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isWord = true;
        }

        public boolean isWord() {
            return isWord;
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return false;
            }
        }
        return node.isWord();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i< prefix.length();i++) {
            char ch = prefix.charAt(i);
            if(node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("search");
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
