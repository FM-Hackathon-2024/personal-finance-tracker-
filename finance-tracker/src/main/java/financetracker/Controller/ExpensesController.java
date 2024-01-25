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

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        try {
            expenseRepository.findById(id).get();
            expenseRepository.deleteById(id);
            return "Expense deleted successfully";
        } catch (Exception e) {
            return "Expense not found";
        }
    }


}
