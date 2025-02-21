package ca.qaguru.shop.controllers;
import ca.qaguru.shop.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (userDetails != null && "{noop}".concat(password).equals(userDetails.getPassword())) {
            return jwtTokenUtil.generateToken(username, userDetails.getAuthorities().toString());
        }
        System.out.println("Invalid " + username);
        return "Invalid credentials";
    }
}