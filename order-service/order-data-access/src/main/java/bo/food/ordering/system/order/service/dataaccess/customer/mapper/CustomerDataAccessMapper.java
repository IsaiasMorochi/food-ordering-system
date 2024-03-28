package bo.food.ordering.system.order.service.dataaccess.customer.mapper;

import bo.food.ordering.system.domain.vo.CustomerId;
import bo.food.ordering.system.order.service.dataaccess.customer.entity.CustomerEntity;
import bo.food.ordering.system.order.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }

}
