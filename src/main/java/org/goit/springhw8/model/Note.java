package org.goit.springhw8.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.goit.springhw8.model.enums.AccessTypes;
import org.goit.springhw8.util.annotations.NameValid;
import org.goit.springhw8.util.annotations.PasswordMatches;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Note.
 */
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@NameValid
@PasswordMatches
@ApiModel
@Table(name = "notes")
public class Note implements BaseModel<String>{

    private static final long serialVersionUID = -2461011850166766986L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private User author;

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Enumerated(EnumType.STRING)
    private AccessTypes accessType;

}
