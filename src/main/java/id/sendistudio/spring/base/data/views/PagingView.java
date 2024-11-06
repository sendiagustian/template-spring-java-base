package id.sendistudio.spring.base.data.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingView {
    private Integer size;
    private Integer totalData;
    private Integer currentPage;
    private Integer totalPage;
}
