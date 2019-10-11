package com.funcionarios.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funcionarios.apirest.repository.FuncionarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.funcionarios.apirest.models.Funcionario;


//Essa é a classe que vai receber as requisições http
@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Funcionarios")
//pra liberar todos os dominios para acessar minha API
@CrossOrigin(origins="*")
public class FuncionarioResource {

	//ponto de injecao do repository que havia criado
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	//método para listar todos os funcionarios
	@GetMapping("/funcionarios")
	@ApiOperation(value="Retorna uma lista de funcionarios")
	public List<Funcionario> listaFuncionario() {
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/funcionario/{id}")
	@ApiOperation(value="Retorna uma lista de funcionarios")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
        Optional<Funcionario> funcionario =  funcionarioRepository.findById(id);

        if(funcionario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionario.get());
	}
	
	@PostMapping("/funcionario")
	@ApiOperation(value="Retorna um funcionario unico e retorna mensagens de erro por status")
	public Funcionario salvaFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@DeleteMapping("/funcionario")
	@ApiOperation(value="Deleta um valor")
	public void deletaFuncionario(@RequestBody Funcionario funcionario) {
	     funcionarioRepository.delete(funcionario);
	}
	
	@PutMapping("/funcionario")
	@ApiOperation(value="Insere um valor")
	public Funcionario insereFuncionario(@RequestBody Funcionario funcionario) {
	    return funcionarioRepository.save(funcionario);
	}
	
}
