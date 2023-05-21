package testes_automatizados.capitulo_01;

import org.junit.Test;

import junit.framework.Assert;
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

      Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
      Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

   }
   
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

      Assert.assertEquals(3000, leiloeiro.getMaiorLance(), 0.0001);
      Assert.assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
   }

   @Test
   public void deveEntenderLeilaoComApenasUmLance() {
      
      Usuario joao = new Usuario("João");
      
      Leilao leilao = new Leilao("Playstation 3 Novo");
      
      leilao.propor(new Lance(joao, 1000.0));
      
      Avaliador leiloeiro = new Avaliador();
      leiloeiro.avaliar(leilao);
      
      Assert.assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
      Assert.assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
   }

}
