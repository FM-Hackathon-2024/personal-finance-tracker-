package financetracker.Controller;

import financetracker.domain.Expenses;
import financetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Home {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/testing.html")
    public String testing(){return "testing.html";}


    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/expenses")
    public String listExpenses(Model model) {
        List<Expenses> expenses = (List<Expenses>) expenseRepository.findAll();
        model.addAttribute("expenses", expenses);
        return "index.html";
    }
}
