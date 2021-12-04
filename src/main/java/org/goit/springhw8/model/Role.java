package org.goit.springhw8.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role implements BaseModel<String> {

    private static final long serialVersionUID = 1909791726526791370L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @Size(min = 1,max = 50,message = "min = 1, max = 50")
    private String id;

    @Column(name = "name", nullable = false)
    @Size(min = 2,max = 25,message = "min = 2, max = 25")
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return id != null && Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
        return result;
    }

    public Role(String id, String name) {
        this.id=id;
        this.name=name;
    }
}
