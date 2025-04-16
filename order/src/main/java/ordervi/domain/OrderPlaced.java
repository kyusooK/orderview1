package ordervi.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ordervi.domain.*;
import ordervi.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productName;
    private String qty;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
