package br.com.start.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.start.model.Tarefa;
import br.com.start.model.dto.TarefaEntradaDto;
import br.com.start.model.dto.TarefaSaidaDto;
import br.com.start.repository.TarefaRepository;

@org.springframework.stereotype.Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;

	@Autowired
	private ModelMapper mapper;

	public TarefaSaidaDto criar(TarefaEntradaDto tarefaEntrada) {

		// MAPPER CONVERTE O OBJ TarefaEntradaDto PARA UM OBJ TAREFA
		Tarefa tarefa = mapper.map(tarefaEntrada, Tarefa.class);

		// SALVA O OBJ TAREFA NO BANCO DE DADOS USANDO O SAVE DO REPOSITORIO
		repository.save(tarefa);

		// UTULIZANDO O MAPPER PARA CONVERTER a TAREFA EM TarefaSaidaDto, E RETORNA A
		// SAIDA
		TarefaSaidaDto saida = mapper.map(tarefa, TarefaSaidaDto.class);

		return saida;
	}

	public boolean alterar(Long id, TarefaEntradaDto tarefaEntrada) {
		// VERIFICANDO NO BANCO DE DADOS SE EXISTE UMA TAREFA COM O ID PROCURADO
		// (findById)
		Optional<Tarefa> buscandoTarefa = repository.findById(id);

		// SE EXISTIR > PEGA A TAREFA > ATUALIZA OS DADOS > SALVA NO REPOSITORIO >
		// RETORNA TRUE/ SENÃO RETORNA FALSE
		if (buscandoTarefa.isPresent()) {
			Tarefa tarefa = buscandoTarefa.get();
			mapper.map(tarefaEntrada, tarefa);
			repository.save(tarefa);
			return true;
		}
		return false;
	}

	public TarefaSaidaDto pegarUm(Long id) {
		// PROCURA A TAREFA PELO ID, SE EXISTIR ELE TRANSFORMA A TAREFA EM TAREFASAIDADTO E
		// RETORNA/ SENÃO RETORNA NULL
		Optional<Tarefa> buscandoTarefa = repository.findById(id);
		if (buscandoTarefa.isPresent()) {
			Tarefa tarefa = buscandoTarefa.get();
			TarefaSaidaDto saida = mapper.map(tarefa, TarefaSaidaDto.class);
			return saida;

		}
		return null;
	}

	public boolean excluir(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<TarefaSaidaDto> listar() {

		// RECUPERAR TODOS OS OBJETOS TAREFAS NO BANCO UTILIZANDO O METODO findAll,
		// MAPEANDO CADA UM DELES PARA TarefaSaidaDto,
		// PARA RETORNAR UMA LISTA
		List<Tarefa> listaTarefas = repository.findAll();
		return listaTarefas.stream().map(filme -> mapper.map(filme, TarefaSaidaDto.class)).collect(Collectors.toList());
	}

}
