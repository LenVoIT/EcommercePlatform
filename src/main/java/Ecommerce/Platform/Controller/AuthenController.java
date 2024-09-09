package Ecommerce.Platform.Controller;

import Ecommerce.Platform.Entity.UserEntity;
import Ecommerce.Platform.Model.UserDTO;
import Ecommerce.Platform.Security.JwtService;
import Ecommerce.Platform.Service.UserInfoService;
import Ecommerce.Platform.Util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthenController {
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok("ahihi");
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserEntity userEntity) {
        try {
            UserEntity user = userInfoService.createUser(userEntity);
            return ResponseHandler
                    .generateResponse(HttpStatus.OK, false, "Register Success !", userEntity);
        } catch (Exception e) {
            return ResponseHandler
                    .generateResponse(HttpStatus.OK, true, e.getMessage(), "");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO){
        UserEntity userEntity = userInfoService.authenticateUser(userDTO.getUsername(), userDTO.getPassword());
        if (userEntity != null) {
            String token = jwtService.generateToken(userEntity);
            return ResponseHandler
                    .generateResponse(HttpStatus.OK, false, "Login success !", token);
        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            return ResponseHandler
                    .generateResponse(HttpStatus.UNAUTHORIZED, true, "Unauthorized", "" );
        }
    }

}
