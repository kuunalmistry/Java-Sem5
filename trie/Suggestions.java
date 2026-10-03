package AdvanceTopics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Suggestions {
    static class Node {
        Node[] next = new Node[26];
        List<String> top = new ArrayList<>(2);
    }
    private final Node root = new Node();
    public void add(String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) {
                cur.next[i] = new Node();
            }
            cur = cur.next[i];
            insertTop(cur.top, s);
        }
    }
    private void insertTop(List<String> top, String s) {
        if (!top.contains(s) && top.size() < 3) {
            top.add(s);
        }
    }
    public List<List<String>> suggestedProduct(String[] products, String searchWord) {
        if (products == null) {
            return new ArrayList<>();
        }
        Arrays.sort(products);
        for (String product : products) {
            add(product);
        }
        List<List<String>> ans = new ArrayList<>();
        Node cur = root;
        for (char c : searchWord.toCharArray()) {
            if (cur != null) {
                cur = cur.next[c - 'a'];
            }
            ans.add(cur == null ? new ArrayList<>() : new ArrayList<>(cur.top));
        }
        return ans;
    }
    public static void main(String[] args) {
        Suggestions suggest = new Suggestions();
        String[] products = {"mobile", "moneypot", "mouse", "mousepad", "monk"};
        List<List<String>> result = suggest.suggestedProduct(products, "mouse");
        System.out.println(result.toString());
    }
}