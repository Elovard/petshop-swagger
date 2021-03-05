package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    private long id;
    private String name;
    private PetStatusEnum status;
}
