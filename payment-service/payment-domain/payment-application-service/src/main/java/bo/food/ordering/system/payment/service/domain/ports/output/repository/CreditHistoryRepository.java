package bo.food.ordering.system.payment.service.domain.ports.output.repository;

import bo.food.ordering.system.domain.vo.CustomerId;
import bo.food.ordering.system.payment.service.domain.entity.CreditHistory;

import java.util.List;
import java.util.Optional;

public interface CreditHistoryRepository {

    CreditHistory save(CreditHistory creditHistory);

    Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId);

}
