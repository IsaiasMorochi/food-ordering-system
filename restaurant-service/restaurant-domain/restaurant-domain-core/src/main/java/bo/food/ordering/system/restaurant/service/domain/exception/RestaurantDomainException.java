package bo.food.ordering.system.restaurant.service.domain.exception;

import bo.food.ordering.system.domain.exception.DomainException;

public class RestaurantDomainException extends DomainException {
    public RestaurantDomainException(String message) {
        super(message);
    }

    public RestaurantDomainException(String message, Throwable cause) {
        super(message, cause);
    }

}
