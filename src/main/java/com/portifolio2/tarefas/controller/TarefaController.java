package com.portifolio2.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portifolio2.tarefas.models.TarefaModel;
import com.portifolio2.tarefas.repository.TarefaRepository;

@RestController
@RequestMapping(value="/tarefa")
public class TarefaController {
	
	@Autowired
	TarefaRepository repository;
	
	@PostMapping
	public TarefaModel salvarTarefa(@RequestBody TarefaModel tarefa) {
		return repository.save(tarefa);
	}
	
	@GetMapping
	public List<TarefaModel> listaAllTarefas(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public TarefaModel listarTarefaById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void deletarTarefa(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TarefaModel> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaModel newTarefa){
		return repository.findById(id)
				.map(tarefa ->{
					tarefa.setTitulo(newTarefa.getTitulo());
					tarefa.setDescricao(newTarefa.getDescricao());
					TarefaModel tarefaUpdate = repository.save(tarefa);
					return ResponseEntity.ok().body(tarefaUpdate);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	

}
