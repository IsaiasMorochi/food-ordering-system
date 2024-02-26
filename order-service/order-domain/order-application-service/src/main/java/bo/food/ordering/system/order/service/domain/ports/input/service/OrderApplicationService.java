package bo.food.ordering.system.order.service.domain.ports.input.service;

import bo.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import bo.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import bo.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import bo.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
