package com.example.monitor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
    private String url;
    private String timestamp;
    private String browser;
    private String path_name;
    private String duration;
    private String encoded_body_size;
    private String parse_dns_time;
    private String connect_time;
    private String ttfb_time;
    private String response_time;

}
