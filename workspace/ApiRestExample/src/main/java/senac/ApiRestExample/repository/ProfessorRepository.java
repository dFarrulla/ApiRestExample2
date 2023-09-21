package senac.ApiRestExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import senac.ApiRestExample.entity.Aluno;
import senac.ApiRestExample.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{


	
	
}