package pl.pajco.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private final pl.pajco.entity.User user;

    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                       pl.pajco.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public pl.pajco.entity.User getUser() {
        return user;
    }
}
