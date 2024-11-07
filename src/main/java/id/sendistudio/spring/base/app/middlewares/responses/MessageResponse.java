package id.sendistudio.spring.base.app.middlewares.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponse extends WebResponse {
    private String message;

    public MessageResponse() {}

    public MessageResponse(int status, String message) {
        super(status);
        this.message = message;
    }
}
