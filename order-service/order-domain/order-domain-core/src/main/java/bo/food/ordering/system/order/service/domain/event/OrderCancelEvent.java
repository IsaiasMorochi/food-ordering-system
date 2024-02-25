package bo.food.ordering.system.order.service.domain.event;

import bo.food.ordering.system.domain.event.DomainEvent;
import bo.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelEvent implements DomainEvent<Order> {
    private final Order order;
    private final ZonedDateTime createdAt;

    public OrderCancelEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
