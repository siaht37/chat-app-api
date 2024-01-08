package hoangquochthai.chatapp.ws;

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
    MessageRepository messageRepository;
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        Message message = new Message();
        message.setContent(textMessage.getPayload());
        messageRepository.save(message);
        //có thể lưu vô db
        //xử lý logic....
        Gson g = new Gson();
        Message message1 = new Message();
        message1.setContent("tao la trum");
        session.sendMessage(new TextMessage(g.toJson(message1)));
    }
}
