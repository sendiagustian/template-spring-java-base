package id.sendistudio.spring.base.app.middlewares.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class WebResponse {
    private int status;
}
