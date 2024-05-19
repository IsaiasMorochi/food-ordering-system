package bo.food.ordering.system.payment.service.dataaccess.creditentry.mapper;

import bo.food.ordering.system.domain.vo.CustomerId;
import bo.food.ordering.system.domain.vo.Money;
import bo.food.ordering.system.payment.service.dataaccess.creditentry.entity.CreditEntryEntity;
import bo.food.ordering.system.payment.service.domain.entity.CreditEntry;
import bo.food.ordering.system.payment.service.domain.vo.CreditEntryId;
import org.springframework.stereotype.Component;

@Component
public class CreditEntryDataAccessMapper {

    public CreditEntry creditEntryEntityToCreditEntry(CreditEntryEntity creditEntryEntity) {
        return CreditEntry.builder()
                .creditEntryId(new CreditEntryId(creditEntryEntity.getId()))
                .customerId(new CustomerId(creditEntryEntity.getCustomerId()))
                .totalCreditAmount(new Money(creditEntryEntity.getTotalCreditAmount()))
                .build();
    }

    public CreditEntryEntity creditEntryToCreditEntryEntity(CreditEntry creditEntry) {
        return CreditEntryEntity.builder()
                .id(creditEntry.getId().getValue())
                .customerId(creditEntry.getCustomerId().getValue())
                .totalCreditAmount(creditEntry.getTotalCreditAmount().getAmount())
                .build();
    }

}
