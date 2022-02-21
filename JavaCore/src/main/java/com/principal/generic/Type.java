package com.principal.generic;

public class Type<T> {
    private T t;
    public void set(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }
}
