package bo.food.ordering.system.restaurant.service.domain.ports.output.repository;

import bo.food.ordering.system.restaurant.service.domain.entity.OrderApproval;

public interface OrderApprovalRepository {
    OrderApproval save(OrderApproval orderApproval);
}
