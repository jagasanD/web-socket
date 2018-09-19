
package com.websocket.repository;

import com.websocket.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author root
 */


public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    
    public AppUser findByEmailIgnoreCaseAndPassword(String email,String password);
    
}
