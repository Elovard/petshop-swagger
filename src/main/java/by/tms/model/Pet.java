package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    @NotEmpty
    @Size(min = 1)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;

    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String name;

    private String status;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    private PetStatusEnum petStatusEnum;
}
