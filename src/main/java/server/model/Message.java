package server.model;

import javax.validation.constraints.Max;
import java.time.LocalDateTime;

class Message {
    String recipient;
    @Max(255)
    String message;
    LocalDateTime sentDate;
}
