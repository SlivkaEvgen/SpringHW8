package org.goit.springhw8.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "manufacturer")
public class Manufacturer implements BaseModel<Long> {

    private static final long serialVersionUID = -2363992291788316414L;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 15)
    private Long id;

    public Manufacturer(){

    }

    @Column(name = "name", length = 15)
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Product> products;

    public Manufacturer(long id, String name) {
    }
}
