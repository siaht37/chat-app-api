package hoangquochthai.chatapp.ws;

import hoangquochthai.chatapp.entity.Message;
import hoangquochthai.chatapp.repository.GroupChatRepository;
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

    @Autowired
    private GroupChatRepository groupChatRepository;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        Message message = new Message();
        message.setContent(textMessage.getPayload());
        Message messageSave = messageRepository.save(message);

        Gson g = new Gson();
        session.sendMessage(new TextMessage(g.toJson(messageSave)));
    }
}
