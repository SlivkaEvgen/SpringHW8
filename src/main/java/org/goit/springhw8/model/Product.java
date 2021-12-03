package org.goit.springhw8.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

//@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
//@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements BaseModel<Long> {

    private static final long serialVersionUID = 6007665773823540856L;

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 15)
    private Long id;

    @Column(name = "name", length = 15)
    private String name;

    @Column(name = "price", length = 15)
    private Double price;

    @ManyToOne
    private Manufacturer manufacturer;

    public Product(Long id, String name, Double price, Manufacturer manufacturer) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.manufacturer=manufacturer;
    }

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
