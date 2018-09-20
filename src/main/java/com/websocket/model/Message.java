
package com.websocket.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Getter
@Setter
@Entity
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String message;
    @ManyToOne
    private AppUser sendBy;
    @ManyToOne
    private AppUser recivedBy;
    private Date createDate;
    private Date updatedDate;
    private Boolean isSeen=Boolean.FALSE;
     
     
}
