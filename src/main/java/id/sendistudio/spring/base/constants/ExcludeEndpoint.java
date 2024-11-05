package id.sendistudio.spring.base.constants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ExcludeEndpoint {

    private List<String> tokenExcludes = new ArrayList<>();
    private List<String> logExcludes = new ArrayList<>();

    public ExcludeEndpoint() {

        // Health Check
        tokenExcludes.add("/api/v1/health-check");
        logExcludes.add("/api/v1/health-check");

        // Auth
        tokenExcludes.add("/api/v1/auth/login");
        tokenExcludes.add("/api/v1/auth/register");
        tokenExcludes.add("/api/v1/auth/logout");

        // tokenExcludes.add("/api/v1/user/gets");
    }

}
