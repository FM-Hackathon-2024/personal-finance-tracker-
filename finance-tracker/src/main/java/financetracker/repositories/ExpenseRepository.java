package financetracker.repositories;

import financetracker.domain.Expenses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<Expenses, Long> {
}
