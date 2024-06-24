package projet.SystemePointage.Salaire.Modele;

import lombok.*;
import projet.SystemePointage.Salaire.Modele.Enum.CategorieEnum;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Employee  {
    private String name;
    private int matircule;
    private LocalDate birtdhay;
    private LocalDate startDate;
    private LocalDate endContrat;
    private Salary salaryBrut;
    private Category category;


}
