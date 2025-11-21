package br.com.global_solution.Global_Solution.repository;

import br.com.global_solution.Global_Solution.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageModel, Long> {
}