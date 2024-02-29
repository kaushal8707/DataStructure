package map;

import java.util.LinkedList;
import java.util.ArrayList;
public class HashMapTemp<K,V> {
    class Node{
        K key;
        V value;
        Node(K key, V value){
            this.key=key;
            this.value=value;
        }
    }

    private int n;   // No of Nodes
    private int N;   // No of Buckets
    LinkedList<Node> buckets[];
    HashMapTemp(){
        this.N=4;;
        this.buckets=new LinkedList[4];
        for(int i=0;i<4;i++){
            this.buckets[i]=new LinkedList<>();
        }
    }

    public int hashFunction(K key){
        int bi = key.hashCode();
        return Math.abs(bi) % N;
    }

    public int searchLL(K key, int bi){
        LinkedList<Node> ll=buckets[bi];
        for(int i=0;i<ll.size();i++){
            if(ll.get(i).key==key){
                return i;   //  di
            }
        }
        return -1;   // key not exist
    }

    public void put(K key, V value){
        int bi=hashFunction(key);
        int di=searchLL(key,bi);
        if(di==-1){   // key not exist
            buckets[bi].add(new Node(key,value));
            n++;
        }else{    //key exists
           Node node = buckets[bi].get(di);
           node.value=value;
        }
    }

    public V get(K key){
        int bi=hashFunction(key);
        int di=searchLL(key,bi);
        if(di==-1){
            return null;
        }else{
            Node node=buckets[bi].get(di);
            return node.value;
        }
    }

    public V remove(K key){
        int bi=hashFunction(key);
        int di=searchLL(key,bi);
        if(di==-1){
            return null;
        }else{
            Node node=buckets[bi].remove(di);
            n--;
            return node.value;
        }
    }

    public boolean containsKey(K key){
        int bi=hashFunction(key);
        int di=searchLL(key,bi);
        if(di==-1){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<K> keySets(){
        ArrayList<K> keyList=new ArrayList<>();
        for(int i=0;i<buckets.length;i++){
            LinkedList<Node> ll=buckets[i];
            for(int j=0;j<ll.size();j++){
                Node n=ll.get(j);
                keyList.add(n.key);
            }
        }
        return keyList;
    }

    public static void main(String[] args) {
        HashMapTemp<String, Integer> map=new HashMapTemp();
        map.put("abc",123);
        map.put("def",456);
        map.put("ghi",789);
        map.put("jkl",1011);
        System.out.println(map.get("ghi"));
        System.out.println(map.keySets());
        System.out.println(map.remove("jkl"));
        System.out.println(map.keySets());

    }
}
