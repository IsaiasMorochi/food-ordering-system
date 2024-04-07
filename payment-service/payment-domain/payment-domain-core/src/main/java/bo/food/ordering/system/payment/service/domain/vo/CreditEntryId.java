package bo.food.ordering.system.payment.service.domain.vo;


import bo.food.ordering.system.domain.vo.BaseId;

import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {

    public CreditEntryId(UUID value) {
        super(value);
    }

}
