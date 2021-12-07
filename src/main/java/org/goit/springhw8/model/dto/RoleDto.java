package org.goit.springhw8.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.goit.springhw8.model.BaseModel;
import org.goit.springhw8.model.Role;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Transient;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto extends Role implements  GrantedAuthority {

    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    private String id;

    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private String name;

    @Transient
    @ToString.Exclude
    private Set<UserDto> userDtoSet;

    public RoleDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

}
