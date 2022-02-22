package userService.src.main.java.com.SofeiAndreiPOC.userService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userService.src.main.java.com.SofeiAndreiPOC.userService.entity.User;
import userService.src.main.java.com.SofeiAndreiPOC.userService.repository.IUserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository UserRepository;

    public User saveUser(User user) {
        return UserRepository.saveUser(user);
    }
    /*
    public User getUserById(Long userId) {
        return UserRepository.findById(userId);
    }
     */
}
