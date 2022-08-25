package com.example.monitor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paint {
    private String url;
    private String timestamp;
    private String browser;
    private String first_paint;
    private String first_content_paint;
    private String first_meaningful_paint;
    private String largest_contentful_paint;
}
