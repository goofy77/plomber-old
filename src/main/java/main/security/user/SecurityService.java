package main.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    private final SecurityUserDao securityUserDao;

    @Autowired
    public SecurityService(SecurityUserDao securityUserDao) {
        this.securityUserDao = securityUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return securityUserDao.findByUsername(email);
    }
}
