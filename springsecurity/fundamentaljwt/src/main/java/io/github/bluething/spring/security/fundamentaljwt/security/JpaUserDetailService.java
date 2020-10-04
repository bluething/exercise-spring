package io.github.bluething.spring.security.fundamentaljwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class JpaUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public JpaUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUserUser = userRepository.findUserByUsername(username);
        User user = optionalUserUser.orElseThrow(() -> new UsernameNotFoundException("Not Found"));
        return null;
    }
}
