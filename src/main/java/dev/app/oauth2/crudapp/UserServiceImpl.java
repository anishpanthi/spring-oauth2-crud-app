package dev.app.oauth2.crudapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anish Panthi
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        log.info("Fetching all users...");
        var users = userRepository.findAll();
        log.info("Total users found: {}", users.size());
        return users;
    }

    @Override
    public void save(User user) {
        log.info("Saving user: {}", user);
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
