package org.goit.springhw8.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    private String id;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users;

    @Override
    public String getId() {
        return id;
    }

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
