package financetracker;

import financetracker.repositories.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanceTrackerApplication implements CommandLineRunner {

	private final ExpenseRepository expenseRepository;

    public FinanceTrackerApplication(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    public static void main(String[] args) {
		SpringApplication.run(FinanceTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		expenseRepository.findAll().forEach(expense -> {
			System.out.println(expense.toString());
		});
	}

}
