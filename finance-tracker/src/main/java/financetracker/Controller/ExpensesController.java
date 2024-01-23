package financetracker.Controller;

import financetracker.domain.Expenses;
import financetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public List<Expenses> getAllExpenses() {
        return (List<Expenses>) expenseRepository.findAll();
    }

    @PostMapping
    public Expenses createExpense(@RequestBody Expenses expense) {
        return expenseRepository.save(expense);
    }


}
