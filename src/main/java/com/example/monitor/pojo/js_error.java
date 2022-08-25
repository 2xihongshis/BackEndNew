package com.example.monitor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class js_error {
    private String url;
    private String timestamp;
    private String browser;
    private String message;
    private String filename;
    private String position;
    private String stack;
    private String selector;
}
