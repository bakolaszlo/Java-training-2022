package com.principal.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StudentEnum {
    BUDGET("budget"), TAX("tax");

    private String type;

}
