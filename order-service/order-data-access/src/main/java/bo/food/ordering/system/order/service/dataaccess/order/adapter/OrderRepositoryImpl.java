package bo.food.ordering.system.order.service.dataaccess.order.adapter;

import bo.food.ordering.system.order.service.domain.vo.TrackingId;
import bo.food.ordering.system.order.service.dataaccess.order.mapper.OrderDataAccessMapper;
import bo.food.ordering.system.order.service.dataaccess.order.repository.OrderJpaRepository;
import bo.food.ordering.system.order.service.domain.entity.Order;
import bo.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository,
                               OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(orderJpaRepository
                .save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

    @Override
    public Optional<Order> findByTrackingId(TrackingId trackingId) {
        return orderJpaRepository.findByTrackingId(trackingId.getValue())
                .map(orderDataAccessMapper::orderEntityToOrder);
    }

}
