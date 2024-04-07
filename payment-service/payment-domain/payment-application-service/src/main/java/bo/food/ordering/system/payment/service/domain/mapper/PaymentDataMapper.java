package bo.food.ordering.system.payment.service.domain.mapper;

import bo.food.ordering.system.domain.vo.CustomerId;
import bo.food.ordering.system.domain.vo.Money;
import bo.food.ordering.system.domain.vo.OrderId;
import bo.food.ordering.system.payment.service.domain.dto.PaymentRequest;
import bo.food.ordering.system.payment.service.domain.entity.Payment;
import bo.food.ordering.system.payment.service.domain.event.PaymentEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaymentDataMapper {

    public Payment paymentRequestModelToPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .orderId(new OrderId(UUID.fromString(paymentRequest.getOrderId())))
                .customerId(new CustomerId(UUID.fromString(paymentRequest.getCustomerId())))
                .price(new Money(paymentRequest.getPrice()))
                .build();
    }

}
