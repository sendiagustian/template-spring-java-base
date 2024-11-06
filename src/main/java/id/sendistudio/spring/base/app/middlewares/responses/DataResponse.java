package id.sendistudio.spring.base.app.middlewares.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponse<T> extends WebResponse {
    private T data;

    public DataResponse(int status, T data) {
        super(status);
        this.data = data;
    }
}
