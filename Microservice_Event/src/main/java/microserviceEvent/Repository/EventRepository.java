/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent.Repository;



import java.util.List;
import Domain.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ronni
 */


public interface EventRepository extends CrudRepository<Event, Integer>{
    
    @Query("SELECT e FROM Event e where e.title like %?1%")
    List<Event> findEventsByTitle(String title);
}
