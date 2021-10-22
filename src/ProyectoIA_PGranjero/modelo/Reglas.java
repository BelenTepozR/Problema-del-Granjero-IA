package ProyectoIA_PGranjero.modelo;

import java.util.ArrayList;


/**
 *
 * @author btepozromero
 */
public class Reglas {
        public Reglas(){  }
        
        public Nodo cruzar(Nodo nodo,String personaje){               
                switch(personaje){
                        case "granjero":
                                nodo.cambiarGranjero();
                                break;
                        case "lobo":
                                nodo.cambiarGranjero();
                                nodo.cambiarLobo();
                                break;
                       case "cabra":
                                nodo.cambiarGranjero();
                                nodo.cambiarCabra();
                                break;
                       case "col":
                                nodo.cambiarGranjero();
                                nodo.cambiarKol();
                                break;                       
                }
                return nodo;
        }
        //4 operadores
        public boolean cruzaSolo(Nodo nodo){         
                Nodo aux = new  Nodo(nodo);
                  aux.cambiarGranjero();
                return restricciones(aux);
        }
      
        public boolean cruzaConLobo(Nodo nodo){
                Nodo aux = new  Nodo(nodo);
                aux.cambiarLobo();
                aux.cambiarGranjero();
               return restricciones(aux);
        }
        public boolean cruzaConCabra(Nodo nodo){
                Nodo aux = new  Nodo(nodo);
                aux.cambiarCabra();
                aux.cambiarGranjero();
                return restricciones(aux);
        }
        public boolean cruzaConCol(Nodo nodo){
                Nodo aux = new  Nodo(nodo);
                aux.cambiarKol();
                aux.cambiarGranjero();
                return restricciones(aux);
        }
        
        public boolean restricciones(Nodo nodo){
           if( (nodo.getCabra() ==1 && nodo.getKol() == 1 && nodo.getGranjero() == 0) || 
                (nodo.getCabra() == 0 && nodo.getKol()==0 && nodo.getGranjero()==1))
                   return false;      
           if((nodo.getLobo()== 1 && nodo.getCabra()==1 && nodo.getGranjero()==0) || 
               (nodo.getLobo()== 0 && nodo.getCabra()==0 && nodo.getGranjero()==1))
                   return false;
            return true;
        }
     
     public ArrayList<Integer> crearEstado(String estado){
                ArrayList<Integer> est =  new ArrayList();
                String[] parts = estado.split(",");
               if(parts[0].equals("d")) est.add(1);
               else  est.add(0);
               if(parts[1].equals("d")) est.add(1);
               else  est.add(0);
                if(parts[2].equals("d")) est.add(1);
               else  est.add(0);
               if(parts[3].equals("d")) est.add(1);
               else  est.add(0);
                return est;
        }
}


