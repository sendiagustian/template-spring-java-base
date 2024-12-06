package id.sendistudio.spring.base.data.responses;

import id.sendistudio.spring.base.data.views.PagingView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataPaginationResponse<T> extends WebResponse {
    private T data;
    private PagingView paging;

    public DataPaginationResponse() {}

    public DataPaginationResponse(int status, T data, PagingView paging) {
        super(status);
        this.data = data;
        this.paging = paging;
    }
}
