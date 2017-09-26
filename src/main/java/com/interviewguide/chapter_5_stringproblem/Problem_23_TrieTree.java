package com.interviewguide.chapter_5_stringproblem;

/**
 * Created by BIG-JIAN on 2017/9/11.
 * 字典树的实现
 */
public class Problem_23_TrieTree {
    // 字典树节点的类型
    static class TrieNode {
        int path;
        int end;
        TrieNode[] map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];//26个字母
        }
    }

    public static class Trie {
        private TrieNode root;// 跟结点

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) return;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word)) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.map[index].path-- == 1) {
                        node.map[index] = null;
                        return;
                    }
                    node = node.map[index];
                }
                node.end--;
            }
        }


        public boolean search(String word) {
            if (word == null) return false;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) return false;
                node = node.map[index];
            }
            return node.end != 0;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
    }


}
