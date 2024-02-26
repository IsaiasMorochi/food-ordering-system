package bo.food.ordering.system.order.service.domain.ports.output.message.publisher.restaurantapproval;

import bo.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import bo.food.ordering.system.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
