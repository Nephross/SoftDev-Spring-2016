/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_User_DBWrapper;
import Domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Hisayo
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    
    List<User> findByUserName(String userName);
}

