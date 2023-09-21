package senac.ApiRestExample.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import senac.ApiRestExample.dto.AlunoDTO;
import senac.ApiRestExample.entity.Aluno;
import senac.ApiRestExample.service.AlunoService;

@RestController
@RequestMapping("alunos")
public class AlunoResource {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AlunoService alunoService;
	
	
	@PostMapping
	public ResponseEntity<AlunoDTO> cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
		
		Aluno aluno = mapper.map(alunoDTO,Aluno.class);
		
		aluno = alunoService.salvar(aluno);
		
		AlunoDTO alunoNovo = mapper.map(aluno, AlunoDTO.class);
		
		return ResponseEntity.ok().body(alunoNovo);
		
		
		
		
	}
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> buscarTodosAlunos() {
		List<Aluno> listaALunos = alunoService.buscarTodosAlunos();
		
		List<AlunoDTO> listaAlunoDTO = listaALunos.stream().map(aluno -> mapper.map(aluno, AlunoDTO.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaAlunoDTO);
	}
	
	

}
