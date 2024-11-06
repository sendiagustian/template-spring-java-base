package id.sendistudio.spring.base.app.middlewares.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends WebResponse {
    private String error;

    public ErrorResponse(int status, String error) {
        super(status);
        this.error = error;
    }
}