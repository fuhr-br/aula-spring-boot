package ifrs.com.br.aula.controller;

import ifrs.com.br.aula.dto.UsuarioDTO;
import ifrs.com.br.aula.model.Endereco;
import ifrs.com.br.aula.model.Usuario;
import ifrs.com.br.aula.repository.EnderecoRepository;
import ifrs.com.br.aula.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PessoaController {

  private final UsuarioRepository usuarioRepository;
  private final EnderecoRepository enderecoRepository;

  public PessoaController(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) {

    this.usuarioRepository = usuarioRepository;
    this.enderecoRepository = enderecoRepository;
  }

  @GetMapping("/pessoa/{nome}")
  public ResponseEntity<String> getPessoa(@PathVariable final String nome
  ) {

//		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//		headers.add("Nome-header", "Conteudo do header");

    return new ResponseEntity<>(nome, HttpStatus.OK);
  }

  @GetMapping("/pessoa")
  public ResponseEntity<String> getPessoaByQueryParam(@RequestParam String nome) {

    return new ResponseEntity<>("Nome da pessoa da consulta: " + nome, HttpStatus.OK);
  }

  @PostMapping("/pessoa")
  public ResponseEntity<UsuarioDTO> postPessoa(@RequestBody(required = false) final UsuarioDTO usuarioDTO) {

    UsuarioDTO novaUsuarioDTO = usuarioDTO == null ? new UsuarioDTO("nova pessoa", "Rua B", 123) : usuarioDTO;
    return new ResponseEntity<>(novaUsuarioDTO, HttpStatus.CREATED);
  }

  @PatchMapping("/pessoa/{nome}")
  public ResponseEntity<String> patchPessoa(@PathVariable String nome, @RequestBody UsuarioDTO novoNome) {

    return new ResponseEntity<>("Nome atualizado para: " + novoNome, HttpStatus.OK);
  }

  @PutMapping("/pessoa/{nome}")
  public ResponseEntity<String> putPessoa(@PathVariable String nome, @RequestBody UsuarioDTO usuarioDTO) {

    return new ResponseEntity<>("Detalhes da pessoa atualizados.", HttpStatus.OK);
  }

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "sucesso"),
      @ApiResponse(responseCode = "201", description = "created")
  })
  @PostMapping("/usuario")
  public ResponseEntity<UsuarioDTO> postUser(@RequestBody @Validated final UsuarioDTO usuarioDTO) {

    Usuario usuario = new Usuario(usuarioDTO.nome());
    usuarioRepository.save(usuario);

    Endereco endereco = new Endereco(usuarioDTO.rua(), usuarioDTO.numero(), usuario);
    enderecoRepository.save(endereco);
    return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
  }

}