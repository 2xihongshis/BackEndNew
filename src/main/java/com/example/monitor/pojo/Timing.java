package com.example.monitor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timing {
    private String url;
    private String timestamp;
    private String browser;
    private String parse_dns_time;
    private String connect_time;
    private String ttfb_time;
    private String response_time;
    private String parse_dom_time;
    private String dom_contentloaded_time;
    private String time_to_interactive;
    private String load_time;
}
