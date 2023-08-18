package ifrs.com.br.aula.model;

import jakarta.persistence.*;

@Entity
public class Endereco {

  public Endereco() {

  }

  public Endereco(String rua, Integer numero, Usuario usuario) {

    this.usuario = usuario;
    this.rua = rua;
    this.numero = numero;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  private String rua;
  private Integer numero;

  @ManyToOne
  @JoinColumn(name = "usuario_id") // Cria a coluna na tabela Endereco que faz referência à tabela usuario
  private Usuario usuario;

}
