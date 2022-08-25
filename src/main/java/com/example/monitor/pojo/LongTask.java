package com.example.monitor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LongTask {
    private String url;
    private String timestamp;
    private String browser;
    private String event_type;
    private String start_time;
    private String duration;
    private String selector;
}
