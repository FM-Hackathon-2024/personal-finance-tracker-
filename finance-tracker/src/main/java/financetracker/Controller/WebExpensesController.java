package financetracker.Controller;

import financetracker.domain.Expenses;
import financetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class WebExpensesController {

    @Autowired
    private ExpenseRepository expenseRepository;

    //...

    @GetMapping
    public String showExpenses(Model model) {
        // Retrieve expenses from the database
        List<Expenses> expenses = (List<Expenses>) expenseRepository.findAll();

        // Calculate total expenses
        double totalExpenses = expenses.stream().mapToDouble(Expenses::getPrice).sum();
        model.addAttribute("totalExpenses", totalExpenses);

        // Retrieve income and savings goal from the database
        List<Expenses> latestRecords = expenseRepository.findLatestRecord();

        // Use the modified query to get a list of records
        Double income = latestRecords.isEmpty() ? 0.0 : latestRecords.get(0).getIncome();
        Double savingsGoal = latestRecords.isEmpty() ? 0.0 : latestRecords.get(0).getGoal();

        // Set values in the model
        model.addAttribute("income", income);
        model.addAttribute("savingsGoal", savingsGoal);

        // Calculate remaining budget after expenses
        double remainingBudget = income - totalExpenses;

        // Check if savings goal has been met
        boolean savingsGoalMet = remainingBudget >= savingsGoal;
        model.addAttribute("remainingBudget", remainingBudget);
        model.addAttribute("savingsGoalMet", savingsGoalMet);

        // Add expenses to the model
        model.addAttribute("expenses", expenses);
        model.addAttribute("newExpense", new Expenses());

        return "transactions.html";
    }

    @PostMapping("/add")
    public String addExpense(@ModelAttribute("newExpense") Expenses newExpense) {
        expenseRepository.save(newExpense);
        return "redirect:/expenses";
    }

    @PostMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/expenses";
    }

    @PostMapping("/setBudget")
    public String setBudget(@RequestParam("income") double income, @RequestParam("savingsGoal") double savingsGoal, Model model) {
        // Create a new Expenses entity
        Expenses expenses = new Expenses();
        expenses.setIncome(income);
        expenses.setGoal(savingsGoal);

        // Save the entity to the repository
        expenseRepository.save(expenses);

        // Update the model with the new values (if needed)
        model.addAttribute("income", income);
        model.addAttribute("savingsGoal", savingsGoal);

        return "redirect:/expenses";
    }
}
