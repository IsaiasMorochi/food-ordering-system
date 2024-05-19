package bo.food.ordering.system.order.service.dataaccess.restaurant.mapper;

import bo.food.ordering.system.dataaccess.restaurant.entity.RestaurantEntity;
import bo.food.ordering.system.dataaccess.restaurant.exception.RestaurantDataAccessException;
import bo.food.ordering.system.domain.vo.Money;
import bo.food.ordering.system.domain.vo.ProductId;
import bo.food.ordering.system.domain.vo.RestaurantId;
import bo.food.ordering.system.order.service.domain.entity.Product;
import bo.food.ordering.system.order.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RestaurantDataAccessMapper {

    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
        return restaurant.getProducts().stream()
                .map(product -> product.getId().getValue())
                .toList();
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity =
                restaurantEntities.stream().findFirst().orElseThrow(() ->
                        new RestaurantDataAccessException("Restaurant could not be found!"));

        List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
                new Product(new ProductId(entity.getProductId()), entity.getProductName(),
                        new Money(entity.getProductPrice()))).toList();

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .products(restaurantProducts)
                .active(restaurantEntity.getRestaurantActive())
                .build();
    }

}
