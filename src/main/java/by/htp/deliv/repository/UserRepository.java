package by.htp.deliv.repository;

import java.util.Optional;

import by.htp.deliv.entity.User;

public interface UserRepository {

    Optional<User> findUserByLogin(String username);

    Optional<User> findUserById(long userId);

    
}

    
    
    
    
