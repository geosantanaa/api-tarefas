package br.com.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.start.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
}
