package hoangquochthai.chatapp.ws;

import hoangquochthai.chatapp.dto.MessageDTO;
import hoangquochthai.chatapp.entity.Message;
import hoangquochthai.chatapp.repository.MessageRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) {
        new Thread(()->{
            try {
                Gson g = new Gson();

                MessageDTO messageResponseDTO = g.fromJson(textMessage.getPayload(), MessageDTO.class);
                Message messageSave = messageRepository.save(messageResponseDTO.getMessage());
                MessageDTO messageDTO = new MessageDTO(messageResponseDTO.getUser(), messageSave);

                session.sendMessage(new TextMessage(g.toJson(messageDTO)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
