package com.funcionarios.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funcionarios.apirest.models.Funcionario;

//feito isso temos uma intreface que importa o JPA repository
//maneira de facilitar a criação de métodos prontos para a criação no banco de dados
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
