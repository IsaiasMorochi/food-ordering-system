package bo.food.ordering.system.order.service.domain.ports.output.message.publisher.payment;

import bo.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import bo.food.ordering.system.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
