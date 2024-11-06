package id.sendistudio.spring.base.app.utils;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import id.sendistudio.spring.base.app.middlewares.responses.ErrorResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ErrorUtil {
    public ErrorResponse errorNotFound(DataAccessException e) {
        log.info("Data Error : " + e.getMessage());
        return new ErrorResponse(404, "Data not found");
    }

    public ErrorResponse errorData(DataAccessException e) {
        log.info("Data Error : " + e.getMessage());
        return new ErrorResponse(500, "Data error: " + e.getMessage());
    }

    public ErrorResponse errorServer(Exception e) {
        log.info("Data Error : " + e.getMessage());
        return new ErrorResponse(500, "Data error: " + e.getMessage());
    }
}
