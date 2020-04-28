package jdbc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

}
