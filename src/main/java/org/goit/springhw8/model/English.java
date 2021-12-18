package org.goit.springhw8.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "english")
public class English implements BaseModel<String> {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "ukr")
    private String ukr;

    //Later
//    @Column("pronunciation")
//    private String pronunciation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        English english = (English) o;
        return id != null && Objects.equals(id, english.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUkr());
    }
}
