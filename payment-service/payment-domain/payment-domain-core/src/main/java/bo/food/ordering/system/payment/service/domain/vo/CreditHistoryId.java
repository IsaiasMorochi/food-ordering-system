package bo.food.ordering.system.payment.service.domain.vo;

import bo.food.ordering.system.domain.vo.BaseId;

import java.util.UUID;

public class CreditHistoryId extends BaseId<UUID> {
    public CreditHistoryId(UUID value) {
        super(value);
    }
}
