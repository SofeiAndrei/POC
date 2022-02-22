package userService.src.main.java.com.SofeiAndreiPOC.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import userService.src.main.java.com.SofeiAndreiPOC.userService.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

    User saveUser(User user);

    @Query("{id:'?0'}")
    User getUserById(Long userId);
    @Query("{username:'?0'}")
    User getUserByUsername(String username);
    @Query("{email:'?0'}")
    User getUserByEmail(String email);
}
