package id.sendistudio.spring.base.app.middlewares.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class WebResponse {
    private int status;

    public WebResponse(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
