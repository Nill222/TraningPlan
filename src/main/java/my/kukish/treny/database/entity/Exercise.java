package my.kukish.treny.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exercise")
public class Exercise {
    @Id
    @Column(name = "name_of_exercise")
    private String name;



}
