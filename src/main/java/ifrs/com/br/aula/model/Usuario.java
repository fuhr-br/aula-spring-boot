package ifrs.com.br.aula.model;

import ifrs.com.br.aula.model.Endereco;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

  public Usuario() {

  }

  public Usuario(String nome) {

    this.nome = nome;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nome;

  @OneToMany(mappedBy = "usuario")
  private List<Endereco> enderecos;

  public Long getId() {

    return id;
  }

  public String getNome() {

    return nome;
  }

  public List<Endereco> getEnderecos() {

    return enderecos;
  }
}