package server;

import lombok.Data;

import java.time.LocalDateTime;

@Data
class ServerData {
    String serverVersion;
    LocalDateTime creationTime;
}
