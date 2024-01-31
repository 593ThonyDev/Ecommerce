package aristosoft.api.user.model;

import java.time.*;
import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "iduser")
    Integer idUsuario;

    @Basic
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "username", nullable = false)
    String username;

    @Column(name = "password")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String password;

    @Column(name = "role")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Enumerated(EnumType.STRING)
    Role role;

    @Column(name = "status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Enumerated(EnumType.STRING)
    Status estado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "created")
    ZonedDateTime created;

    @Column(name = "email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String usuEmail;

    public ZonedDateTime getFecha() {
        return ZonedDateTime.now(ZoneId.of("America/Guayaquil"));
    }

    // Sobreescritura de los metodos
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (estado == Status.ONLINE) {
            return true;
        }
        if (estado == Status.UPDATE_PASS) {
            return true;
        } else if (estado == Status.OFFLINE) {
            return false;
        } else {
            return false;
        }
    }

}
