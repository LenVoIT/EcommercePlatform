package Ecommerce.Platform.Model;//package JwtAndSpringSecurity.demo.Model;
//
//import JwtAndSpringSecurity.demo.Entity.UserEntity;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Data
//public class UserInfoDetails implements UserDetails  {
//    private String username;
//    private String password;
//    private List<GrantedAuthority> authorities;
//    public UserInfoDetails(UserEntity userInfo) {
//        username = userInfo.getUsername();
//        password = userInfo.getPassword();
//        authorities = new ArrayList<>();
//        if (userInfo.getUsername().equals("admin")) {
//            authorities.add(new SimpleGrantedAuthority("ADMIN"));
//        } else if (userInfo.getUsername().equals("user")){
//            authorities.add(new SimpleGrantedAuthority("USER"));
//        } else {
//            authorities.add(new SimpleGrantedAuthority("HR"));
//        }
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
