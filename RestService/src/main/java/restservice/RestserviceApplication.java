package restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import microserviceSkel1.domain.Event;
import microserviceSkel1.domain.Stuff;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RestserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestserviceApplication.class, args);

    }

    @FeignClient("microserviceSkel1")
    public interface StuffClient {
        
        @RequestMapping(method = RequestMethod.GET, value = "/hi")
        Stuff getStuff();
        
    }
    
    @FeignClient("microserviceSkel1")
    public interface EventClient {
        
        @RequestMapping(method = RequestMethod.GET, value = "/get_event")
        Event getEvent();
        
        @RequestMapping(method = RequestMethod.POST, value = "/update_event", consumes = MediaType.APPLICATION_JSON_VALUE)
        Event updateEvent(@RequestBody Event event);
        
    }
}
