package com.example.wc.entity;

import javax.validation.constraints.NotNull;

public class Greeting {

    @NotNull
    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
