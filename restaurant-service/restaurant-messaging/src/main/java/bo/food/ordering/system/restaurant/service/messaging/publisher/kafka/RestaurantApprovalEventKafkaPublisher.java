package bo.food.ordering.system.restaurant.service.messaging.publisher.kafka;

import bo.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel;
import bo.food.ordering.system.kafka.producer.KafkaMessageHelper;
import bo.food.ordering.system.kafka.producer.service.KafkaProducer;
import bo.food.ordering.system.restaurant.service.domain.config.RestaurantServiceConfigData;
import bo.food.ordering.system.restaurant.service.domain.event.OrderApprovedEvent;
import bo.food.ordering.system.restaurant.service.domain.ports.output.message.publisher.OrderApprovedMessagePublisher;
import bo.food.ordering.system.restaurant.service.messaging.mapper.RestaurantMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RestaurantApprovalEventKafkaPublisher implements OrderApprovedMessagePublisher {

    private final RestaurantMessagingDataMapper restaurantMessagingDataMapper;
    private final KafkaProducer<String, RestaurantApprovalResponseAvroModel> kafkaProducer;
    private final RestaurantServiceConfigData restaurantServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public RestaurantApprovalEventKafkaPublisher(RestaurantMessagingDataMapper dataMapper,
                                                 KafkaProducer<String, RestaurantApprovalResponseAvroModel>
                                                         kafkaProducer,
                                                 RestaurantServiceConfigData restaurantServiceConfigData,
                                                 KafkaMessageHelper kafkaMessageHelper) {
        this.restaurantMessagingDataMapper = dataMapper;
        this.kafkaProducer = kafkaProducer;
        this.restaurantServiceConfigData = restaurantServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }


    @Override
    public void publish(OrderApprovedEvent orderApprovedEvent) {

        String orderId = orderApprovedEvent.getOrderApproval().getOrderId().getValue().toString();

        log.info("Received OrderApprovedEvent for order id: {}", orderId);
        try {
            RestaurantApprovalResponseAvroModel restaurantApprovalResponseAvroModel =
                    restaurantMessagingDataMapper
                            .orderApprovedEventToRestaurantApprovalResponseAvroModel(orderApprovedEvent);

            kafkaProducer.send(restaurantServiceConfigData.getRestaurantApprovalResponseTopicName(),
                    orderId,
                    restaurantApprovalResponseAvroModel,
                    kafkaMessageHelper.getKafkaCallback(
                            restaurantServiceConfigData.getRestaurantApprovalResponseTopicName(),
                            restaurantApprovalResponseAvroModel,
                            orderId,
                            "RestaurantApprovalResponseAvroModel"));

            log.info("RestaurantApprovalResponseAvroModel sent to kafka at: {}, for order id: {}", System.nanoTime(),
                    restaurantApprovalResponseAvroModel.getOrderId());
        } catch (Exception e) {
            log.error("Error while sending RestaurantApprovalResponseAvroModel message" +
                    " to kafka with order id: {}, error: {}", orderId, e.getMessage());
        }
    }

}
