package org.goit.springhw8.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements BaseModel<String> {

    private static final long serialVersionUID = 6007665773823540856L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @Size(min = 1,max = 50,message = "min = 1, max = 50")
    private String id;

    @Column(name = "name")
    @Size(min = 2,max = 25,message = "min = 2, max = 25")
    private String name;

    @Column(name = "price")
    @Size(max = 20,message = "max = 20")
    private Double price;

    @ManyToOne
    private Manufacturer manufacturer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        return result;
    }
}
