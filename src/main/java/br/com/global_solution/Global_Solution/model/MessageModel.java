package br.com.global_solution.Global_Solution.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private MessageType messageType;

    @NotEmpty(message = "A mensagem não pode estar vazia")
    private String message;

    @PositiveOrZero
    private double level ;

    private LocalDateTime dateTime;

    @PrePersist
    public void PrePersist(){
        if(dateTime == null ){
            dateTime = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(@NotNull MessageType messageType) {
        this.messageType = messageType;
    }

    public @NotEmpty(message = "A mensagem não pode estar vazia") String getMessage() {
        return message;
    }

    public void setMessage(@NotEmpty(message = "A mensagem não pode estar vazia") String message) {
        this.message = message;
    }

    @PositiveOrZero
    public double getLevel() {
        return level;
    }

    public void setLevel(@PositiveOrZero double level) {
        this.level = level;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}