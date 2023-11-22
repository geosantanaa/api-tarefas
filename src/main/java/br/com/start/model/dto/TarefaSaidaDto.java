package br.com.start.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TarefaSaidaDto {

	private Long id;
	private String descricao;
	private Boolean feito;


}
