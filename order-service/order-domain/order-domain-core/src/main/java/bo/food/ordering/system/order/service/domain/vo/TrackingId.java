package bo.food.ordering.system.order.service.domain.vo;

import bo.food.ordering.system.domain.vo.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
