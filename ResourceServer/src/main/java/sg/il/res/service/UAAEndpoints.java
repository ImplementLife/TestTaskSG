package sg.il.res.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UAAEndpoints {
    @Value("${sg.il.res.url.uaa}")
    private String uaaUrl;
    private String authUrl;

    @PostConstruct
    private void postConstruct() {
        authUrl = uaaUrl + "/auth";
    }

    public String getAuthUrl() {
        return authUrl;
    }
}
