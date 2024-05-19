package bo.food.ordering.system.restaurant.service.domain.mapper;

import bo.food.ordering.system.domain.vo.Money;
import bo.food.ordering.system.domain.vo.OrderId;
import bo.food.ordering.system.domain.vo.OrderStatus;
import bo.food.ordering.system.domain.vo.RestaurantId;
import bo.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;
import bo.food.ordering.system.restaurant.service.domain.entity.OrderDetail;
import bo.food.ordering.system.restaurant.service.domain.entity.Product;
import bo.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantDataMapper {

    public Restaurant restaurantApprovalRequestToRestaurant(RestaurantApprovalRequest
                                                                    restaurantApprovalRequest) {
        return Restaurant.builder()
                .restaurantId(new RestaurantId(UUID.fromString(restaurantApprovalRequest.getRestaurantId())))
                .orderDetail(
                        OrderDetail.builder()
                                .orderId(new OrderId(UUID.fromString(restaurantApprovalRequest.getOrderId())))
                                .products(
                                        restaurantApprovalRequest.getProducts().stream().map(
                                                        product -> Product.builder()
                                                                .productId(product.getId())
                                                                .quantity(product.getQuantity())
                                                                .build())
                                                .collect(Collectors.toList()))
                                .totalAmount(new Money(restaurantApprovalRequest.getPrice()))
                                .orderStatus(OrderStatus.valueOf(restaurantApprovalRequest.getRestaurantOrderStatus().name()))
                                .build())
                .build();
    }

}
