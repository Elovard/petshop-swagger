package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotEmpty
    @Size(min = 1)
    private long petId;

    @NotBlank
    @NotEmpty
    @Size(min = 1)
    private int quantity;

    private String shipDate;

    @NotEmpty
    @NotEmpty
    private String status;

    private boolean complete;
    private OrderStatus orderStatus;
}
