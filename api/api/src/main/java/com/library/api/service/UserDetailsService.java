package com.library.api.service;

import com.library.api.repository.UserRepository;
import com.library.api.util.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    private final UserRepository repository;

    public UserDetailsService(UserRepository repository){
        this.repository = repository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return repository.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
