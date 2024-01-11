package hoangquochthai.chatapp.dto;

import hoangquochthai.chatapp.dto.requestDTO.UserRequestDTO;
import hoangquochthai.chatapp.dto.responseDTO.UserResponseDTO;
import hoangquochthai.chatapp.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
   private UserResponseDTO user;
   private Message message;
}
