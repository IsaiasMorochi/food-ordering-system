package bo.food.ordering.system.restaurant.service.domain;

import bo.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import bo.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import bo.food.ordering.system.restaurant.service.domain.event.OrderApprovalEvent;
import bo.food.ordering.system.restaurant.service.domain.event.OrderApprovedEvent;
import bo.food.ordering.system.restaurant.service.domain.event.OrderRejectedEvent;

import java.util.List;

public interface RestaurantDomainService {

    OrderApprovalEvent validateOrder(Restaurant restaurant,
                                     List<String> failureMessages,
                                     DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher,
                                     DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher);

}
