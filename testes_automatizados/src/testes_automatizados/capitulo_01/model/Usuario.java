package testes_automatizados.capitulo_01.model;

/**
 * Pessoa que fez um lance no leilao
 *
 */
public class Usuario {

   private String nome;

   public Usuario(String nome) {
      this.nome = nome;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

}
