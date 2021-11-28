package org.goit.springhw8.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements BaseModel<Long> {

    private static final long serialVersionUID = 6007665773823540856L;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false,length = 15)
    private Long id;

    @Column(name = "name", length = 15)
    private String name;

    @Column(name = "price", length = 15)
    private Double price;

    @ManyToOne
    private Manufacturer manufacturer;
}
