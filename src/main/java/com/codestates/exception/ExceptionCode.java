package com.codestates.exception;

import lombok.Getter;


public enum ExceptionCode {
    MEMBER_NOT_FOUND(404,"Member not found"),
    COFFEE_NOT_FOUND(404, "Coffee not found"),
    ORDER_NOT_FOUND(404, "Order not found"),
    MEMBER_EXISTS(409,"Email are already exist"),
    COFFEE_CODE_EXISTS(409,"CoffeeCode are already exist"),
    CANNOT_CHANGE_ORDER(403, "Order can not change"),
    NOT_IMPLEMENTATION(501,"Not Implementation");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
