package id.sendistudio.spring.base.data.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse extends WebResponse {
    private String error;

    public ErrorResponse() {}

    public ErrorResponse(int status, String error) {
        super(status);
        this.error = error;
    }
}