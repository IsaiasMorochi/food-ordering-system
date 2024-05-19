package bo.food.ordering.system.payment.service.dataaccess.credithistory.mapper;

import bo.food.ordering.system.domain.vo.CustomerId;
import bo.food.ordering.system.domain.vo.Money;
import bo.food.ordering.system.payment.service.dataaccess.credithistory.entity.CreditHistoryEntity;
import bo.food.ordering.system.payment.service.domain.entity.CreditHistory;
import bo.food.ordering.system.payment.service.domain.vo.CreditHistoryId;
import org.springframework.stereotype.Component;

@Component
public class CreditHistoryDataAccessMapper {

    public CreditHistory creditHistoryEntityToCreditHistory(CreditHistoryEntity creditHistoryEntity) {
        return CreditHistory.builder()
                .creditHistoryId(new CreditHistoryId(creditHistoryEntity.getId()))
                .customerId(new CustomerId(creditHistoryEntity.getCustomerId()))
                .amount(new Money(creditHistoryEntity.getAmount()))
                .transactionType(creditHistoryEntity.getType())
                .build();
    }

    public CreditHistoryEntity creditHistoryToCreditHistoryEntity(CreditHistory creditHistory) {
        return CreditHistoryEntity.builder()
                .id(creditHistory.getId().getValue())
                .customerId(creditHistory.getCustomerId().getValue())
                .amount(creditHistory.getAmount().getAmount())
                .type(creditHistory.getTransactionType())
                .build();
    }

}
