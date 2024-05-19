package bo.food.ordering.system.restaurant.service.dataaccess.restaurant.adapter;

import bo.food.ordering.system.restaurant.service.dataaccess.restaurant.mapper.RestaurantDataAccessMapper;
import bo.food.ordering.system.restaurant.service.dataaccess.restaurant.repository.OrderApprovalJpaRepository;
import bo.food.ordering.system.restaurant.service.domain.entity.OrderApproval;
import bo.food.ordering.system.restaurant.service.domain.ports.output.repository.OrderApprovalRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderApprovalRepositoryImpl implements OrderApprovalRepository {

    private final OrderApprovalJpaRepository orderApprovalJpaRepository;
    private final RestaurantDataAccessMapper restaurantDataAccessMapper;

    public OrderApprovalRepositoryImpl(OrderApprovalJpaRepository orderApprovalJpaRepository,
                                       RestaurantDataAccessMapper restaurantDataAccessMapper) {
        this.orderApprovalJpaRepository = orderApprovalJpaRepository;
        this.restaurantDataAccessMapper = restaurantDataAccessMapper;
    }

    @Override
    public OrderApproval save(OrderApproval orderApproval) {
        return restaurantDataAccessMapper
                .orderApprovalEntityToOrderApproval(orderApprovalJpaRepository
                        .save(restaurantDataAccessMapper.orderApprovalToOrderApprovalEntity(orderApproval)));
    }

}
