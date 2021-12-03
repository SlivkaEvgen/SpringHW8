package org.goit.springhw8.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Objects;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseModel<Long>  {

    private static final long serialVersionUID = -558_820_640_269_434_517L;

    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 15)
    private Long id;

    @Length(min = 2)
    @Column(name = "name", length = 15)
    private String name;

    @Column(name = "last_name", length = 15)
    private String lastName;

    @Column(name = "gender", length = 15, insertable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "role_id")
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
