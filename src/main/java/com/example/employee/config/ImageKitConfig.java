package com.example.employee.config;


import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.config.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class ImageKitConfig {

    @Value("${imagekit.public.key}")
    private String publicKey;

    @Value("${imagekit.private.key}")
    private String privateKey;

    @Value("${imagekit.url.endpoint}")
    private String imageKitEndpoint;

    @Bean
    public ImageKit imageKit() {
        ImageKit imageKit = ImageKit.getInstance();
        Configuration config = new Configuration(publicKey, privateKey, imageKitEndpoint);
        imageKit.setConfig(config);
        return imageKit;
    }
}
