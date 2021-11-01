package com.example.mypackage;

public class Labrador extends Dog {

    public Labrador(String name) {
        super(name);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)    // referential comparison (by memory address)
//            return true;
//
//        if (obj instanceof Labrador) {
//            String objName = ((Labrador) obj).getName();
//            return this.getName().equals(objName);
//        }
//
//        return false;
//    }
}
