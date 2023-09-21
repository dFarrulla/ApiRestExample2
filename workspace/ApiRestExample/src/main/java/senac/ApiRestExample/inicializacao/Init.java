package senac.ApiRestExample.inicializacao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import senac.ApiRestExample.entity.Aluno;
import senac.ApiRestExample.service.AlunoService;


@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	
	@Autowired
	private AlunoService alunoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		
		/*Aluno aluno1 = new Aluno();
		aluno1.setEmail("lucas@gmail.com");
		aluno1.setNome("Lucas");
		aluno1.setSobreNome("Silva");
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setEmail("gabriel@gmail.com");
		aluno2.setNome("Gabi");
		aluno2.setSobreNome("Silva");
		alunoService.salvar(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setEmail("Karen@gmail.com");
		aluno3.setNome("Ka");
		aluno3.setSobreNome("Silva");
		alunoService.salvar(aluno3);
		*/
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		listaAlunos.forEach(aluno -> System.out.println(aluno.getNome()));
		
	}
	//3 classes professor service, professor, professor repository

}