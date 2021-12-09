package org.goit.springhw8.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "role")
public class Role implements BaseModel<String>  {//GrantedAuthority

    private static final long serialVersionUID = 1909791726526791370L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<User> users;

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
