package com.example.monitor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PvUv {
    private String kind;
    private String type;
    private String timestamp;
    private String source;
    private String effectiveType;
    private String rtt;
    private String uuid;
    private String screen;
}
