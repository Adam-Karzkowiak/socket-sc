package server.projection;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MessageWriteModel {

    String recipient;
    String body;
}
