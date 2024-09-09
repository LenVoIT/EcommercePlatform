package Ecommerce.Platform.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
@Data
@NoArgsConstructor
public class UserEntity extends BaseEntity implements UserDetails {
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String avatar;

    @Column
    private boolean isActive;

    @Transient
    Set<GrantedAuthority> authorities;

    public UserEntity(UserEntity userEntity) {
        username = userEntity.getUsername();
        password = userEntity.getPassword();
        authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));
        authorities = new HashSet<>();
        if (userEntity.getRole().equals("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        } else if (userEntity.getRole().equals("USER")){
            authorities.add(new SimpleGrantedAuthority("USER"));
        } else {
            authorities.add(new SimpleGrantedAuthority("SHOP"));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
