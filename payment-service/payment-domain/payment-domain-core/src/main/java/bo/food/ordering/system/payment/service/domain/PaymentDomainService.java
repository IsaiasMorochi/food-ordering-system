package bo.food.ordering.system.payment.service.domain;

import bo.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import bo.food.ordering.system.payment.service.domain.entity.CreditEntry;
import bo.food.ordering.system.payment.service.domain.entity.CreditHistory;
import bo.food.ordering.system.payment.service.domain.entity.Payment;
import bo.food.ordering.system.payment.service.domain.event.PaymentCancelledEvent;
import bo.food.ordering.system.payment.service.domain.event.PaymentCompletedEvent;
import bo.food.ordering.system.payment.service.domain.event.PaymentEvent;
import bo.food.ordering.system.payment.service.domain.event.PaymentFailedEvent;

import java.util.List;

public interface PaymentDomainService {

    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages,
                                            DomainEventPublisher<PaymentCompletedEvent>
                                                    paymentCompletedEventDomainEventPublisher,
                                            DomainEventPublisher<PaymentFailedEvent>
                                                    paymentFailedEventDomainEventPublisher);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages,
                                          DomainEventPublisher<PaymentCancelledEvent>
                                                  paymentCancelledEventDomainEventPublisher,
                                          DomainEventPublisher<PaymentFailedEvent>
                                                  paymentFailedEventDomainEventPublisher);
}
