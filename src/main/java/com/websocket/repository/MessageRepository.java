
package com.websocket.repository;

import com.websocket.model.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author root
 */
public interface MessageRepository extends JpaRepository<Message, Long>{
    
    List<Message> findBySendByIdAndRecivedByIdOrSendByIdAndRecivedById(Long sendById,Long recivedById,Long recivedById1,Long sendById1);
    
}
