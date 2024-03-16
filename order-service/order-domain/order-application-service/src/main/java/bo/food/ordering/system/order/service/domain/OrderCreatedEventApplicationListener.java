package bo.food.ordering.system.order.service.domain;

import bo.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import bo.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class OrderCreatedEventApplicationListener {

    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    public OrderCreatedEventApplicationListener(OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher) {
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
    }

    /**
     * La anotación TransactionalEventListener, permite ser llamado,cuando se completa el método que publica el editor de eventos
     * de la aplicación (ApplicationDomainEventPublisher) y la transacción este completada.
     * Se queda en modo escucha hasta que se complete createOrder y la transaccion.
     * @param orderCreatedEvent
     */
    @TransactionalEventListener
    void process(OrderCreatedEvent orderCreatedEvent) {
        this.orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent);
    }
}
