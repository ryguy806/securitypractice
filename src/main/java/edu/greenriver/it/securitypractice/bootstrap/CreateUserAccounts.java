package edu.greenriver.it.securitypractice.bootstrap;

import edu.greenriver.it.securitypractice.entities.Authority;
import edu.greenriver.it.securitypractice.entities.User;
import edu.greenriver.it.securitypractice.repositories.IUserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CreateUserAccounts implements ApplicationListener<ContextRefreshedEvent> {

    private IUserRepository repo;
    private BCryptPasswordEncoder encoder;

    public CreateUserAccounts(IUserRepository repo, BCryptPasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //create a few test users
        User user = User.builder()
                .authorities(new ArrayList<>())
                .username("user")
                .password(encoder.encode("password"))
                .build();

        Authority userAuth = new Authority("ROLE_USER");
        user.getAuthorities().add(userAuth);
        userAuth.setUser(user);

        repo.save(user);

        User admin = User.builder()
                .authorities(new ArrayList<>())
                .username("admin")
                .password(encoder.encode("password"))
                .build();

        Authority adminUserAuth = new Authority("ROLE_USER");
        Authority adminAdminAuth = new Authority("ROLE_ADMIN");
        admin.getAuthorities().add(adminAdminAuth);
        admin.getAuthorities().add(adminUserAuth);

        adminAdminAuth.setUser(admin);
        adminUserAuth.setUser(admin);

        //add some roles

        //save them to the DB on startup.
    }
}
