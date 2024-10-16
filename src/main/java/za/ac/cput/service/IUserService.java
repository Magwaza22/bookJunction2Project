package za.ac.cput.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import za.ac.cput.domain.User;

import java.util.List;

public interface IUserService <User, Integer> {

   User saveUser(User user);

    <UserDetails> UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
