package com.crud.demo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
public class StandardResponseDTO {
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message = null;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data = null;
    private int cout;

    public StandardResponseDTO fullSuccess(Object data){
        this.success = true;
        this.data = data;
        this.cout = 1;
        return this;
    }

    public StandardResponseDTO failSuccess(String message){
        this.success = false;
        this.message = message;
        this.cout = 1;
        return this;
    }
}