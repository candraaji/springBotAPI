package com.candra.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<T> {

    private boolean status;
    private int code;
    private List<String> messages = new ArrayList<>();
    private T data;

    
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public List<String> getMessages() {
        return messages;
    }
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }


    
    
    
    

    
    
}
