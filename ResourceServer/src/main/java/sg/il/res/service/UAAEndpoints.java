package sg.il.res.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UAAEndpoints {
    @Value("${sg.il.res.url.uaa}")
    private String uaaUrl;

    public String getAuthUrl() {
        return uaaUrl + "/auth";
    }
}
