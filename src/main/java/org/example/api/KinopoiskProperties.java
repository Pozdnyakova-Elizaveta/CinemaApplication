package org.example.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kp")
@Getter
@Setter
public class KinopoiskProperties {
    private String token;
}
