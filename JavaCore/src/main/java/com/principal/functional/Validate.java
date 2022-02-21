package com.principal.functional;

@FunctionalInterface
public interface Validate {
    boolean isValid(boolean rule);
    //SAM -> Single abstract method
}
