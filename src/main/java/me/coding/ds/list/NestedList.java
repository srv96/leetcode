package me.coding.ds.list;

import java.util.List;

public interface NestedList {
    public boolean isInteger();

    public Integer getInteger();

    public void setInteger(int value);

    public void add(NestedList ni);

    public List<NestedList> getList();
}
