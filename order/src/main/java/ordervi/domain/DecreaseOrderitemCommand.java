package ordervi.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DecreaseOrderitemCommand {

    private Integer qty;
}
