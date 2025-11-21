package br.com.global_solution.Global_Solution.service;

import br.com.global_solution.Global_Solution.model.MessageModel;
import br.com.global_solution.Global_Solution.repository.MessageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageModel create(MessageModel message) {
        return messageRepository.save(message);
    }

    public List<MessageModel> findAll() {
        return messageRepository.findAll();
    }

    public MessageModel findById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Mensagem não encontrada para o ID: " + id));
    }

    public MessageModel update(Long id, MessageModel data) {
        return messageRepository.findById(id).map(existing -> {

            existing.setMessageType(data.getMessageType());
            existing.setMessage(data.getMessage());
            existing.setLevel(data.getLevel());

            // dateTime é definido no PrePersist — não alterei aqui
            return messageRepository.save(existing);

        }).orElseThrow(() ->
                new EntityNotFoundException("Mensagem não encontrada para o ID: " + id));
    }


    public void delete(Long id) {
        try {
            messageRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Nenhuma mensagem encontrada para remoção.");
        }
    }
}
