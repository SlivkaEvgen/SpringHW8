package org.goit.springhw8.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import javax.annotation.security.RolesAllowed;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

//@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
//@AllArgsConstructor
@Entity
//@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
@Table(name = "role")
public class Role implements BaseModel<Long> {

    private static final long serialVersionUID = 1909791726526791370L;

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 15)
    private Long id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<User> users;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Long getId() {
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
}
