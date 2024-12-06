package id.sendistudio.spring.base.data.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataResponse<T> extends WebResponse {
    private T data;

    public DataResponse() {}

    public DataResponse(int status, T data) {
        super(status);
        this.data = data;
    }
}
