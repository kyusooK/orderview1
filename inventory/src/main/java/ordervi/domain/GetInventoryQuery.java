package ordervi.domain;

import java.util.Date;
import lombok.Data;

@Data
public class GetInventoryQuery {

    private String productName;
    private String stock;
}
