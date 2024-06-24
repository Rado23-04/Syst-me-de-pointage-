package projet.SystemePointage.Salaire.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import projet.SystemePointage.Salaire.Modele.Enum.CategorieEnum;
@Data
@AllArgsConstructor
public class Category {
    private CategorieEnum NameCategory;
    private int workDuration;
    private Salary salary;
    private double indemnity;
}
