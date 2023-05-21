package testes_automatizados.capitulo_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import testes_automatizados.capitulo_01.model.Lance;
import testes_automatizados.capitulo_01.model.Leilao;

/**
 * 
 * @since 1.1 pp.1-2
 * @version 1.2
 * s
 */
public class Avaliador {

   private double maiorDeTodos = Double.NEGATIVE_INFINITY;
   private double menorDeTodos = Double.POSITIVE_INFINITY;
   private List<Lance> maiores;

   /**
    * p.1
    * @param leilao
    */
   public void avaliar(Leilao leilao) {

      for (Lance lance : leilao.getLances()) {
         if (lance.getValor() > maiorDeTodos) {
            maiorDeTodos = lance.getValor();
         } 
         if (lance.getValor() < menorDeTodos) {
            menorDeTodos = lance.getValor();
         }
      }
      
      pegaOsMaioresNo(leilao);
   }

   /**
    * 1.10 p.22
    * @param leilao
    */
   private void pegaOsMaioresNo(Leilao leilao) {
      
      maiores = new ArrayList<>(leilao.getLances());

      Collections.sort(maiores, new Comparator<Lance>() {

         @Override
         public int compare(Lance o1, Lance o2) {
            if(o1.getValor() < o2.getValor()) {
               return 1;
            }
            if(o1.getValor() > o2.getValor()) {
               return -1;
            }
            return 0;
         }
      });
      
      maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
   }
   
   public List<Lance> getTresMaiores(){
      return this.maiores;
   }

   public double getMaiorLance() {
      return this.maiorDeTodos;
   }

   public double getMenorLance() {
      return this.menorDeTodos;
   }

}
