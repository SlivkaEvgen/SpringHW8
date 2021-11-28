package org.goit.springhw8.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.annotation.security.RolesAllowed;
import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
@Table(name = "role")
public class Role implements BaseEntity<Long>, GrantedAuthority {

    private static final long serialVersionUID = 1909791726526791370L;

    //  @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 15)
    private Long id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<User> users;

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public Long getId() {
        return id;
    }
}
