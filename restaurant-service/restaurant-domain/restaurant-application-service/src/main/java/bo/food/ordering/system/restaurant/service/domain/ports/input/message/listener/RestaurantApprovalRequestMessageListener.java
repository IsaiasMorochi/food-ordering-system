package bo.food.ordering.system.restaurant.service.domain.ports.input.message.listener;

import bo.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;

public interface RestaurantApprovalRequestMessageListener {
    void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest);

}
