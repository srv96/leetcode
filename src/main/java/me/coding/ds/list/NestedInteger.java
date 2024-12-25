package me.coding.ds.list;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger{

    private Integer singleInteger;
    private List<NestedInteger> nestedList;

    public NestedInteger() {
        this.nestedList = new ArrayList<>();
    }

    public NestedInteger(int value) {
        this.singleInteger = value;
    }

    public boolean isInteger() {
        return singleInteger != null;
    }

    public Integer getInteger() {
        return singleInteger;
    }

    public void setInteger(int value) {
        this.singleInteger = value;
        this.nestedList = null;
    }

    public void add(NestedInteger ni) {
        if (nestedList == null) {
            nestedList = new ArrayList<>();
        }
        nestedList.add(ni);
        this.singleInteger = null;
    }

    public List<NestedInteger> getList() {
        return nestedList;
    }
}
