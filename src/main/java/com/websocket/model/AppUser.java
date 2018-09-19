
package com.websocket.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Getter
@Setter
@Entity
public class AppUser implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String password;
    
    private Boolean isLoggedIn =Boolean.FALSE;
   

    
  

   
  
}
