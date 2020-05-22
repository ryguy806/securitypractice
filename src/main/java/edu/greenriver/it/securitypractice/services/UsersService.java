package edu.greenriver.it.securitypractice.services;

import edu.greenriver.it.securitypractice.repositories.IUserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UsersService implements UserDetailsService {

    IUserRepository repo;

    public UsersService(IUserRepository repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsernameEquals(username);
    }
}
