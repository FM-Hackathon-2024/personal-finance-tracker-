// Expenses.java
package financetracker.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name="Expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    private double income;
    private double goal;

    // Constructors, getters, setters, and other methods...

    // If using the default value approach, you can set default values in the constructor:
    public Expenses() {
        // Default constructor
    }




}
