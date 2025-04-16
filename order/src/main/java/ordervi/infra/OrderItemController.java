package ordervi.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import ordervi.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/orderItems")
@Transactional
public class OrderItemController {

    @Autowired
    OrderItemRepository orderItemRepository;

    @RequestMapping(
        value = "/orderItems/{id}/decreaseorderitem",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public OrderItem decreaseOrderitem(
        @PathVariable(value = "id") Long id,
        @RequestBody DecreaseOrderitemCommand decreaseOrderitemCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /orderItem/decreaseOrderitem  called #####");
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(
            id
        );

        optionalOrderItem.orElseThrow(() -> new Exception("No Entity Found"));
        OrderItem orderItem = optionalOrderItem.get();
        orderItem.decreaseOrderitem(decreaseOrderitemCommand);

        orderItemRepository.save(orderItem);
        return orderItem;
    }
}
//>>> Clean Arch / Inbound Adaptor
