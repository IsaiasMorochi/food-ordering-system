package bo.food.ordering.system.order.service.domain.entity;

import bo.food.ordering.system.domain.entity.BaseEntity;
import bo.food.ordering.system.domain.vo.Money;
import bo.food.ordering.system.domain.vo.ProductId;

public class Product extends BaseEntity<ProductId> {
    private final String name;
    private final Money price;

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

}
