/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_User.Repository;
import Domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Hisayo
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    
    
    List<User> findByUserName(String userName);
}

