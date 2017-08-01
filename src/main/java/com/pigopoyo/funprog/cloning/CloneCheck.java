package com.pigopoyo.funprog.cloning;

import java.util.ArrayList;
import java.util.List;

public class CloneCheck implements  Cloneable{

    private List<String> data;
    private String val;
    private SubClone obj;
    public CloneCheck() {

    }
    public CloneCheck(CloneCheck cloneCheck) throws CloneNotSupportedException {
    this.data = new ArrayList<>(cloneCheck.data);
    this.val = cloneCheck.val;
    this.obj = (SubClone) cloneCheck.obj.clone();
    }
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public SubClone getObj() {
        return obj;
    }

    public void setObj(SubClone obj) {
        this.obj = obj;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    /**
     * Starting point for the JVM.
     */
    public static void main(String argument[]) throws CloneNotSupportedException {
            CloneCheck cloneCheck = new CloneCheck();
            SubClone subClone = new SubClone();
            subClone.setData("Test");
            List<String> data = new ArrayList<>();
            data.add("Text");
           cloneCheck.val = "Dup";
           cloneCheck.setData(data);
           cloneCheck.setObj(subClone);
           CloneCheck cloned = (CloneCheck) cloneCheck.clone();
           cloned.val = "Ori";
           cloned.getData().remove(0);
           cloned.getObj().setData("Real");
            System.out.println("Real: "+cloneCheck.val);
        System.out.println("Cloned: "+ cloned.val);
        System.out.println("Real: "+cloneCheck.getData().size());
        System.out.println("Cloned: "+ cloned.getData().size());
        System.out.println("Real: "+cloneCheck.getObj().getData());
        System.out.println("Cloned: "+ cloned.getObj().getData());

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneCheck(this);
    }
}
