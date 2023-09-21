package senac.ApiRestExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import senac.ApiRestExample.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
