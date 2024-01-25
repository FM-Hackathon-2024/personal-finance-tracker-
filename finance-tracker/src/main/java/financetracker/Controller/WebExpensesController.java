// WebExpensesController.java
package financetracker.Controller;

import financetracker.domain.Expenses;
import financetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/expenses")
public class WebExpensesController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public String showExpenses(Model model) {
        List<Expenses> expenses = (List<Expenses>) expenseRepository.findAll();
        model.addAttribute("expenses", expenses);
        model.addAttribute("newExpense", new Expenses());
        return "expenses"; // Assuming you have an expenses.html Thymeleaf template
    }

    @PostMapping("/add")
    public String addExpense(@ModelAttribute Expenses newExpense) {
        expenseRepository.save(newExpense);
        return "redirect:/web/expenses";
    }

    @PostMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/web/expenses";
    }
}
