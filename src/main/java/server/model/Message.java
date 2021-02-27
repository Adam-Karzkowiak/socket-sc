package server.model;


import server.projection.MessageWriteModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

class Message {

    @NotNull
    String recipient;
    @Min(1)
    @Max(255)
    String body;
    LocalDateTime createdOn;

    private Message(String recipient, String body, LocalDateTime createdOn) {
        this.recipient = recipient;
        this.body = body;
        this.createdOn = createdOn;
    }


    public static Message createMsg(MessageWriteModel entity) {
        return new Message(
                entity.getRecipient(),
                entity.getBody(),
                LocalDateTime.now()
        );
    }
}
