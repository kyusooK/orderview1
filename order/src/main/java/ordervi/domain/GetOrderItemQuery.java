package ordervi.domain;

import java.util.Date;
import lombok.Data;

@Data
public class GetOrderItemQuery {

    private String productName;
    private Double price;
}
