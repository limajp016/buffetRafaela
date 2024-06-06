package com.fateczl.BuffetRafaela.endereco;

public record DadosListagemEndereco(Long id,
		String logradouro,
		String numero,
		String complemento,
		String bairro,
		String cidade,
		String estado,
		String cep) {
	
	public DadosListagemEndereco(Endereco endereco) {
		this(endereco.getId(),
				endereco.getLogradouro(),
				endereco.getComplemento(),
				endereco.getNumero(),
				endereco.getBairro(),
				endereco.getCidade(),
				endereco.getEstado(),
				endereco.getCep());
	}

}
