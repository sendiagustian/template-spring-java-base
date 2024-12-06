package id.sendistudio.spring.base.services.impl;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.sendistudio.spring.base.data.responses.DataResponse;
import id.sendistudio.spring.base.data.responses.ErrorResponse;
import id.sendistudio.spring.base.data.responses.WebResponse;
import id.sendistudio.spring.base.services.HealthCheckService;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    @Autowired
    private DataSource dataSource;

    @Override
    public WebResponse healthCheck() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                return new DataResponse<String>(200, "Connection is reachable!");
            } else {
                return new ErrorResponse(500, "Database connection is not reachable!");
            }
        } catch (Exception e) {
            return new ErrorResponse(500, "Database connection error: " + e.getMessage());
        }
    }

}
