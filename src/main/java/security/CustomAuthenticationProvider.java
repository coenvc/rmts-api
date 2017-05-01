package security;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import repository.user.HibernateUserRepository;
import service.user.DefaultUserService;
import service.user.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BonoIJpelaar on 24-04-17.
 */

@Component
@ComponentScan("repository.user")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    HibernateUserRepository userService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        User user = userService.login(username, password);
        if(user == null) {
            throw new BadCredentialsException("Invalid username/password");
        }

        if(!user.isActive()) {
            throw new DisabledException("User is inactive");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
