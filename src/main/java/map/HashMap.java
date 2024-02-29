package map;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K,V> {   //generics

    private class Node{
        K key;
        V value;
        Node(K key, V value){
            this.key=key;
            this.value=value;
        }
    }

    private int n;   // n - nodes
    private int N;   // N - buckets

    private LinkedList<Node> buckets[]; //  N - buckets length

    @SuppressWarnings("unchecked")
    public HashMap(){
        this.N=4;
        this.buckets=new LinkedList[4];
        for(int i=0;i<4;i++){
           this. buckets[i]=new LinkedList<>();
        }
    }

    private int hashFunction(K key){
        int bi = key.hashCode();
        return Math.abs(bi) % N;
    }

    private int searchInLL(K key, int bi){
        LinkedList<Node> ll=buckets[bi];
        for(int i=0;i<ll.size();i++){
            if(ll.get(i).key==key){
                return i;   // di (data Index)
            }
        }
        return -1;
    }

    public void put(K key, V value){
        int bi=hashFunction(key);
        int di=searchInLL(key,bi);
        if(di==-1){    //key doesn't exists
            buckets[bi].add(new Node(key,value));
            n++;
        }else{        // key exists
            Node node=buckets[bi].get(di);
            node.value=value;
        }
    }

    public boolean containsKey(K key){
        int bi=hashFunction(key);
        int di=searchInLL(key,bi);    // di=-1
        if(di == -1){
            return false;    //key doesn't exists
        }else{
            return true;       // key exists
        }
    }

    public V remove(K key){
        int bi=hashFunction(key);
        int di=searchInLL(key,bi);    // di = -1
        if(di==-1){     //key doesn't exists
            return null;
        }else{    // if key exists
            Node node=buckets[bi].remove(di);
            n--;
            return node.value;
        }
    }

    public V get(K key){
        int bi=hashFunction(key);
        int di=searchInLL(key,bi);    // di = -1
        if(di==-1){   // key doesn't exists
            return null;
        }else{    // key exists
           Node node = buckets[bi].get(di);
           return node.value;
        }
    }

    public ArrayList<K> keySet(){
        ArrayList<K> keySets=new ArrayList<K>();
        for(int i=0;i<buckets.length;i++){      // bi
            LinkedList<Node> ll = buckets[i];
            for(int j=0;j<ll.size();j++){       // di
                Node node = ll.get(j);
                keySets.add(node.key);
            }
        }
        return keySets;
    }


    public static void main(String[] args) {
        HashMap<String, Integer> map=new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        Integer a=map.remove("US");
        System.out.println(a);
        ArrayList<String> keys = map.keySet();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i)+"        "+map.get(keys.get(i)));
        }
    }


}
