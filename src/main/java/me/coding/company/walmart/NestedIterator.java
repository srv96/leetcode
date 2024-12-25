package me.coding.company.walmart;

import me.coding.ds.list.NestedList;

import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    public List<NestedList> nestedList;
    int idx;

    public NestedIterator(List<NestedList> nestedList) {
        this.nestedList = nestedList;
        idx = 0;
    }

    @Override
    public Integer next() {
        if(nestedList.get(idx).isInteger()){
            idx++;
            return nestedList.get(idx).getInteger();
        }else {
        }
        return 0;
    }

    @Override
    public boolean hasNext() {
        if(idx < nestedList.size()-1) return true;
        return false;
    }
}
