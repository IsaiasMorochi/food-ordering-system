package bo.food.ordering.system.order.service.domain.entity;

import bo.food.ordering.system.domain.entity.AggregateRoot;
import bo.food.ordering.system.domain.vo.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}
