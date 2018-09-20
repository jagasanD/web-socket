package com.websocket.bean;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageBean {

    private Long sendBy;
    private Long reciviedBy;
    private String message;
    private Date createDate;
    private Date updatedDate;
    private Boolean isSeen = Boolean.FALSE;

}
