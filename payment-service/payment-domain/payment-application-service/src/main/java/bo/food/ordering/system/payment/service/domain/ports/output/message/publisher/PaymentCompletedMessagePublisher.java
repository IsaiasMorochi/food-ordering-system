package bo.food.ordering.system.payment.service.domain.ports.output.message.publisher;

import bo.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import bo.food.ordering.system.payment.service.domain.event.PaymentCompletedEvent;

public interface PaymentCompletedMessagePublisher extends DomainEventPublisher<PaymentCompletedEvent> {
}
