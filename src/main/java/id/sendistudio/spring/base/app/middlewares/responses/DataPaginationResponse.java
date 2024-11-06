package id.sendistudio.spring.base.app.middlewares.responses;

import id.sendistudio.spring.base.data.views.PagingView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataPaginationResponse<T> extends WebResponse {
    private T data;
    private PagingView paging;

    public DataPaginationResponse(int status, T data, PagingView paging) {
        super(status);
        this.data = data;
        this.paging = paging;
    }
}
