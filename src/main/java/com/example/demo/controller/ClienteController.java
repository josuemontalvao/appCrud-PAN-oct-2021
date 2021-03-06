package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ClienteModel;
import com.example.demo.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteReposity;
	
	@GetMapping("/listar/clientes")
	public List<ClienteModel> findAll(){
		return clienteReposity.findAll();
	}
	
	@PostMapping("/salvar/clientes")
	ResponseEntity<ClienteModel> post(@RequestBody ClienteModel clientinho) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteReposity.save(clientinho));
	}
	
	@GetMapping("/listar/pessoas/{tipo}")
	public ResponseEntity<List<ClienteModel>> filtroId(@PathVariable Integer tipo){
		return ResponseEntity.ok(clienteReposity.procuraTipoPessoas(tipo));
	}
	
//	@GetMapping("/listar/pessoas-juridicas/{tipo}")
//	public ResponseEntity<List<ClienteModel>> procuraPessoasJur√≠dicas(@PathVariable Integer tipo){
//		return ResponseEntity.ok(clienteReposity.procuraPessoasF√≠sicas(tipo));
//	}
	
	//
//	@GetMapping("/listar/pessoas-fisicas/{tipo}")
//	public ResponseEntity<List<ClienteModel>> filtroId(@PathVariable Integer tipo){
//		return ResponseEntity.ok(clienteReposity.procuraPessoasF√≠sicas(tipo)); 		
//	}

	@GetMapping("/listar/clientes/sql/alfabetico")
	public List<ClienteModel> procuraTodosAlfabetico() {
		return clienteReposity.procuraTodosAlfabetico();
	}
	
	@GetMapping("/listar/clientes/sql")
	public List<ClienteModel> procuraTodos() {
		return clienteReposity.procuraTodos();
	}
}
