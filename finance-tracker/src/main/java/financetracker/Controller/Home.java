package financetracker.Controller;

import financetracker.domain.Expenses;
import financetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")  // Updated endpoint path to avoid conflicts
public class Home {

    @GetMapping("/")
    public String welcome_page() {
        return "welcome_page.html";
    }

//    @GetMapping("/transactions.html")
//    public String transactions(){
//        return "transactions.html";
//    }

//    @GetMapping("/transactions")
//    public String showTransactionsPage(Model model) {
//        // Add necessary data to the model, including newExpense
//        model.addAttribute("newExpense", new Expense()); // Assuming Expense is the class for newExpense
//        // Add other necessary attributes to the model
//        return "transactions"; // Return the name of your Thymeleaf template without ".html"
//    }

    @GetMapping("/budget.html")
    public String budget(Model model){
        List<Expenses> expenses = (List<Expenses>) expenseRepository.findAll();
        model.addAttribute("expenses", expenses);
        return "budget.html";
    }

    @GetMapping("/savings_goals.html")
    public String savings_goals(){
        return "savings_goals.html";
    }

    @GetMapping("/settings.html")
    public String settings(){
        return "settings.html";
    }

    @GetMapping("/index.html")
    public String index() { return "index.html";}

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/transactions.html")
    public String listExpenses(Model model) {
        List<Expenses> expenses = (List<Expenses>) expenseRepository.findAll();
        model.addAttribute("expenses", expenses);
        model.addAttribute("newExpense", new Expenses()); // Add newExpense to the model
        return "transactions.html";
    }
}
