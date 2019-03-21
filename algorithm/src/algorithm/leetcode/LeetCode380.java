package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode380 {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(0));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(-1));
        System.out.println(obj.remove(0));
        System.out.println(obj.getRandom());
        System.out.println("------");
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }


}
class RandomizedSet {
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;

        list.add(val);
        map.put(val, list.size()-1);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        int location = map.get(val);
        if(list.size()>1) {
            list.set(location, list.get(list.size() - 1));
        }else
            list.remove(0);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get((int)(Math.random()*list.size()));
    }
}
