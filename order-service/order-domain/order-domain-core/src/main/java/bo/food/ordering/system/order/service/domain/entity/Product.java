package bo.food.ordering.system.order.service.domain.entity;

import bo.food.ordering.system.domain.entity.BaseEntity;
import bo.food.ordering.system.domain.vo.Money;
import bo.food.ordering.system.domain.vo.ProductId;

public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;

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

    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }

}
