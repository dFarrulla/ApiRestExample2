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

import senac.ApiRestExample.dto.ProfessorDTO;
import senac.ApiRestExample.entity.Professor;
import senac.ApiRestExample.service.ProfessorService;

@RestController
@RequestMapping("professores")
public class ProfessorResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> cadastrarProfessor(@RequestBody ProfessorDTO professorDTO) {

        Professor professor = mapper.map(professorDTO, Professor.class);

        professor = professorService.salvar(professor);

        ProfessorDTO professorNovo = mapper.map(professor, ProfessorDTO.class);

        return ResponseEntity.ok().body(professorNovo);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> buscarTodosProfessores() {
        List<Professor> listaProfessores = professorService.buscarTodosProfessores();

        List<ProfessorDTO> listaProfessorDTO = listaProfessores.stream()
                .map(professor -> mapper.map(professor, ProfessorDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listaProfessorDTO);
    }
}
