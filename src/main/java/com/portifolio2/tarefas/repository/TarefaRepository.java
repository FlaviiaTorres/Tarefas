package com.portifolio2.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portifolio2.tarefas.models.TarefaModel;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {

}
