package ordervi.domain;

import ordervi.domain.OrderPlaced;
import ordervi.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name="Order_table")
@Data

//<<< DDD / Aggregate Root
public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String productName;
    
    
    
    
    private Integer qty;

    @PostPersist
    public void onPostPersist(){
        OrderItemRepository orderItemRepository = OrderItem.repository();
        Repository Repository = .repository();
        
        // Map the data and fields to be retrieved from the query. 
        // ex) searchProductName = this.getProductName();

         search = Repository.order();
        
        if(){
            throw new IllegalArgumentException("No data found for search: " + );
        }
       

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        ordervi.external.DecreaseOrderitemCommand decreaseOrderitemCommand = new ordervi.external.DecreaseOrderitemCommand();
        // mappings goes here
        OrderApplication.applicationContext.getBean(ordervi.external.OrderItemService.class)
            .decreaseOrderitem(/* get???(), */ decreaseOrderitemCommand);



        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
//>>> DDD / Aggregate Root
