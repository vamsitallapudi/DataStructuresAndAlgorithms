package main.concepts.hashMaps;

import java.util.*;

public class LRUCache {
    Map<Integer, DLLNode> cache;
    DLLNode start;
    DLLNode end;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        start = new DLLNode();
        end = new DLLNode();
        start.prev = null;
        start.next = end;
        end.prev = start;
        end.next = null;
    }

    public int get(int key) {
        DLLNode node;
        if(cache.containsKey(key)){
            return refreshByKey(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        DLLNode node;
        if(cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
            refreshNode(node);
        } else {
            node = new DLLNode(key, value);
            cache.put(key, node);
            pushFront(node);
            if(cache.size() > capacity) {
                node = removeLast();
                cache.remove(node.key);
            }
        }
    }

    private void pushFront(DLLNode node) {
        node.next = start.next;
        node.prev = start;
        start.next.prev = node;
        start.next = node;
    }

    private void removeNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLLNode removeLast() {
        DLLNode last = end.prev;
        removeNode(last);
        return last;
    }

    private void refreshNode(DLLNode node) {
        removeNode(node);
        pushFront(node);
    }

    private int refreshByKey(int key) {
        DLLNode node = cache.get(key);
        refreshNode(node);
        return node.value;
    }



    public class DLLNode {
        DLLNode prev;
        DLLNode next;
        int key;
        int value;
        public DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public DLLNode() {
            key = -1;
            value = -1;
        }
    }

    public static void main(String[] args) {
//        ["LRUCache","put","put","get","put","put","get"]
//[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
// expected ans: [null,null,null,2,null,null,-1]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4,1);
        System.out.println(lruCache.get(2));
    }
}
