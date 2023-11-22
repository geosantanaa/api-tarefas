package br.com.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.start.model.dto.TarefaEntradaDto;
import br.com.start.model.dto.TarefaSaidaDto;
import br.com.start.service.TarefaService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("tarefa")
@Log4j2
public class TarefaController {

	@Autowired
	private TarefaService service;

	@PostMapping
	public TarefaSaidaDto criar(@RequestBody TarefaEntradaDto tarefaEntrada) {
		log.info("tarefa criada: {}", tarefaEntrada);
		return service.criar(tarefaEntrada);
	}

	@PutMapping("/{id}")
	public boolean alterar(@PathVariable("id") Long id, @RequestBody TarefaEntradaDto tarefaEntrada) {
		log.info("Alteração tarefa: {} {}", id, tarefaEntrada);
		return service.alterar(id, tarefaEntrada);
	}

	@GetMapping("/{id}")
	public TarefaSaidaDto pegarUm(@PathVariable("id") Long id) {
		log.info("Tarefa procurada: {}", id);
		return service.pegarUm(id);
	}

	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable("id") Long id) {
		log.info("Tarefa excluida: {}", id);
		return service.excluir(id);
	}

	@GetMapping
	public List<TarefaSaidaDto> listar() {
		log.info("Lista de tarefas:");
		return service.listar();
	}

}
