package com.pigopoyo.funprog.cloning;

public class SubClone implements  Cloneable {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public SubClone(SubClone dup){
        this.data = dup.data;
    }

    public SubClone() {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new SubClone(this);
    }
}
