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
public class Manufacturer implements BaseEntity<Long> {

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


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Manufacturer)) return false;
//
//        Manufacturer that = (Manufacturer) o;
//
//        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
//        if (!getName().equals(that.getName())) return false;
//        return getProducts() != null ? getProducts().equals(that.getProducts()) : that.getProducts() == null;
//    }

//    @Override
//    public int hashCode() {
//        int result = getId() != null ? getId().hashCode() : 0;
//        result = 31 * result + getName().hashCode();
//        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
//        return result;
//    }
}