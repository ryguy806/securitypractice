package edu.greenriver.it.securitypractice.repositories;

import edu.greenriver.it.securitypractice.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {

    User findByUsernameEquals(String username);
}
