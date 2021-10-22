package ProyectoIA_PGranjero.modelo;


import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author btepozromero
 */
public class Nodo {
        private int granjero,lobo,cabra,kol ;
        Nodo nodoPadre;   
        public Nodo(int granjero, int lobo, int cabra, int col){
              this.granjero=granjero;
              this.lobo = lobo;
              this.cabra = cabra;
              this.kol = col;
               
        } 
        public Nodo(Nodo nodo){
              this.granjero=nodo.granjero;
               this.lobo = nodo.getLobo();
               this.cabra = nodo.getCabra();
               this.kol = nodo.getKol();
         }
      public Nodo(ArrayList<Integer> nodo){
              this.granjero = nodo.get(0);
              this.lobo = nodo.get(1);
              this.cabra = nodo.get(2);
              this.kol = nodo.get(3);
              
      }
      public  ArrayList<Integer> getNodo(){
              return new ArrayList<Integer> (Arrays.asList(granjero, lobo, cabra,kol));
      }
      public void setNodo(int granjero, int lobo, int cabra, int col){
              this.granjero=granjero;
              this.lobo = lobo;
              this.cabra = cabra;
              this.kol = col;
      }
      public ArrayList<Integer> hacerMoviemiento(int granjero, int lobo, int cabra, int col){
              this.granjero=granjero;
              this.lobo = lobo;
              this.cabra = cabra;
              this.kol = col;
              return new ArrayList<Integer> (Arrays.asList(granjero, lobo, cabra,kol));

      }
        public int getGranjero() {
                return granjero;
        }
        public void cambiarGranjero() {
                if(this.granjero ==1)
                   this.granjero = 0;
                else
                   this.granjero=1;   
        }
        public void cambiarLobo() {
                if(this.lobo ==1)
                   this.lobo = 0;
                else
                   this.lobo=1;
        }
        public int getLobo() {
                return lobo;
        }
        

        public int getCabra() {
                return cabra;
        }

        public void cambiarCabra() {
                if(this.cabra ==1)
                   this.cabra = 0;
                else
                   this.cabra =1;
        }
        public int getKol() {
                return kol;
        }
        public void cambiarKol() {
                if(kol==1)
                   this.kol = 0;
                else
                   this.kol =1;
        }
        public String textNodo(){
                return this.granjero+""+this.lobo+""+this.cabra+""+this.kol;
        }
        
         public String oNodo(){
                return this.granjero+","+this.lobo+","+this.cabra+","+this.kol;
        }

        public Nodo getNodoPadre() {
                return nodoPadre;
        }

        public void setNodoPadre(Nodo nodoPadre) {
                this.nodoPadre = nodoPadre;
        }
         
         
}
