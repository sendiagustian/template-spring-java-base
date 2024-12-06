package id.sendistudio.spring.base.services;

import id.sendistudio.spring.base.data.responses.WebResponse;

public interface HealthCheckService {
    WebResponse healthCheck();
}
