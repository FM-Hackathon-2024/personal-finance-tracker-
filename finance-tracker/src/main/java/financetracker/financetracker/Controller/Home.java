package financetracker.financetracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/")
    public String welcome_page() {
        return "welcome_page.html";
    }

    @GetMapping("/transactions.html")
    public String transactions(){
        return "transactions.html";
    }

    @GetMapping("/budget.html")
    public String budget(){
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
}