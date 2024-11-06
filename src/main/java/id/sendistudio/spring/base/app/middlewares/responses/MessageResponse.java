package id.sendistudio.spring.base.app.middlewares.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse extends WebResponse {
    private String message;

    public MessageResponse(int status, String message) {
        super(status);
        this.message = message;
    }
}
