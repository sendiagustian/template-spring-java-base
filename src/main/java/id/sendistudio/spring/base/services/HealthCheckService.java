package id.sendistudio.spring.base.services;

import id.sendistudio.spring.base.app.middlewares.responses.WebResponse;

public interface HealthCheckService {
    WebResponse healthCheck();
}
