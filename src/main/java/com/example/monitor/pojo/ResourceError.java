package com.example.monitor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceError {
    private String url;
    private String timestamp;
    private String browser;
    private String file_name;
    private String tag_name;
    private String trigger_timestamp;
    private String selector;
}
