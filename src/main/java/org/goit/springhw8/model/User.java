package org.goit.springhw8.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseModel<String>  {

    private static final long serialVersionUID = -558_820_640_269_434_517L;

    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @Size(min = 1,max = 50,message = "min = 1, max = 50")
    private String id;

    @Column(name = "name")
    @Size(min = 2,max = 25,message = "min = 2, max = 25")
    private String name;

    @Column(name = "last_name")
    @Size(min = 2,max = 25,message = "min = 2, max = 25")
    private String lastName;

    @Column(name = "gender", insertable = false)
    @Enumerated(EnumType.STRING)
    @Size(min = 4,max = 10,message = "min = 4, max = 10")
    private Gender gender;

    @Column(name = "email")
    @Size(min = 6,max = 35,message = "min = 6, max = 35")
    private String email;

    @Column(name = "password")
    @Size(min = 6,max = 100,message = "min = 6, max = 100")
    private String password;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "role_id")
    @Size(min = 2,max = 20,message = "min = 2, max = 20")
    private Role role;

    @Transient
    private boolean active;

    @Transient
    private String passwordConfirm;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (getPasswordConfirm() != null ? getPasswordConfirm().hashCode() : 0);
        return result;
    }
}
