package testes_automatizados.capitulo_01;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import testes_automatizados.capitulo_01.model.Lance;
import testes_automatizados.capitulo_01.model.Leilao;
import testes_automatizados.capitulo_01.model.Usuario;

/**
 * 
 * @since 1.1
 * @version 1.8
 *
 */
@SuppressWarnings("deprecation")
public class AvaliadorTest {

   /**
    * 1.4 p.11
    */
   @Test
   public void deveEntenderLancesEmOrdemCrescente() {

      Usuario joao = new Usuario("João");
      Usuario jose = new Usuario("José");
      Usuario maria = new Usuario("Maria");

      Leilao leilao = new Leilao("Playstation 3 Novo");

      leilao.propor(new Lance(maria, 250.0));
      leilao.propor(new Lance(joao, 300.0));
      leilao.propor(new Lance(jose, 400.0));

      Avaliador leiloeiro = new Avaliador();
      leiloeiro.avaliar(leilao);

      // testando valores esperados
      double maiorEsperado = 400;
      double menorEsperado = 250;

      assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
      assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

   }
   
   /**
    * 1.7 p.18
    */
   @Test
   public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {

      Usuario joao = new Usuario("João");
      Usuario jose = new Usuario("José");
      Usuario maria = new Usuario("Maria");

      Leilao leilao = new Leilao("Playstation 3 Novo");

      leilao.propor(new Lance(maria, 1000.0));
      leilao.propor(new Lance(joao, 2000.0));
      leilao.propor(new Lance(jose, 3000.0));

      Avaliador leiloeiro = new Avaliador();
      leiloeiro.avaliar(leilao);

      assertEquals(3000, leiloeiro.getMaiorLance(), 0.0001);
      assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
   }

   /**
    *1.8 p.20 
    */
   @Test
   public void deveEntenderLeilaoComApenasUmLance() {
      
      Usuario joao = new Usuario("João");
      
      Leilao leilao = new Leilao("Playstation 3 Novo");
      
      leilao.propor(new Lance(joao, 1000.0));
      
      Avaliador leiloeiro = new Avaliador();
      leiloeiro.avaliar(leilao);
      
      assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
      assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
   }
   
   /**
    * 1.10 p.23
    */
   @Test
   public void deveEncontrarOsTresMaioresLances() {
      
      Usuario joao = new Usuario("João");
      Usuario maria = new Usuario("Maria");
      
      Leilao leilao = new Leilao("Playstation 3 Novo");
      
      leilao.propor(new Lance(joao, 100.0));
      leilao.propor(new Lance(maria, 200.0));
      leilao.propor(new Lance(joao, 300.0));
      leilao.propor(new Lance(maria, 400.0));
      
      Avaliador leiloeiro = new Avaliador();
      leiloeiro.avaliar(leilao);
      
      List<Lance> maiores = leiloeiro.getTresMaiores();
      
      assertEquals(3, maiores.size());
   }
   
   

}
