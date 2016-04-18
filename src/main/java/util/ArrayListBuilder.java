package util;

import java.util.ArrayList;

/**
 * Created by xuan on 2015/11/5.
 */
public class ArrayListBuilder {
    private ArrayList<Integer> arrayList;
    public ArrayListBuilder() {
        arrayList = new ArrayList<Integer>();
    }
    public ArrayListBuilder add(Integer val) {
        arrayList.add(val);
        return this;
    }
    public  ArrayList<Integer> build() {
        return this.arrayList;
    }
}
