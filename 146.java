class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int val){
        this.key = key;
        this.value = val;
        this.prev = null;
        this.next = null;
    }
} 

class LRUCache {
    private Node left;
    private Node right;
    private Map<Integer,Node > cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        left.next = right;
        right.prev = left;
    }
    
    private void insert(Node node){
        Node prev = right.prev;        
        prev.next = node;
        node.next = right;
        node.prev = prev;
        right.prev = node;
    }
    
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key) == false){
            return -1;
        }
        Node node  = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(cache.containsKey(key)){
            node = cache.get(key);
            node.value  = value;
            remove(node);
        }        
        cache.put(key, node);
        insert(node);
        if(cache.size() > capacity){
            Node del = left.next;
            remove(left.next);
            cache.remove(del.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */