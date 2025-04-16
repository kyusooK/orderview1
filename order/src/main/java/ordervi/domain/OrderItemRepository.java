package ordervi.domain;

import java.util.Date;
import java.util.List;
import ordervi.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "orderItems",
    path = "orderItems"
)
public interface OrderItemRepository
    extends PagingAndSortingRepository<OrderItem, Long> {
    @Query(
        value = "select orderItem " +
        "from OrderItem orderItem " +
        "where(:productName is null or orderItem.productName like %:productName%) and (:price is null or orderItem.price = :price)"
    )
    OrderItem getOrderItem(String productName, Double price);
}
