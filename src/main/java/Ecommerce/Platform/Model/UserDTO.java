package Ecommerce.Platform.Model;

import lombok.Data;

@Data
public class UserDTO extends BaseDTO{
    private String username;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String avatar;
    private boolean isActive;

}
