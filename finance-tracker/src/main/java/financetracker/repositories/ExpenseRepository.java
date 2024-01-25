package financetracker.repositories;

import financetracker.domain.Expenses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExpenseRepository extends CrudRepository<Expenses, Long> {
    @Query("SELECT e FROM Expenses e ORDER BY e.id DESC")
    List<Expenses> findLatestRecord();

}