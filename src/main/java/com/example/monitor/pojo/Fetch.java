package com.example.monitor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fetch {
    private String url;
    private String timestamp;
    private String browser;
    private String path_name;
    private String status;
    private String duration;
    private String response;
    private String params;
}
