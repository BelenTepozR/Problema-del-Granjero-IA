package ProyectoIA_PGranjero.modelo;
import ProyectoIA_PGranjero.modelo.Nodo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author btepozromero
 */
public class BusquedaAnchura{
        private LinkedList<Nodo> sucesores;
        private ArrayList<Nodo>recorrido;
        private ArrayList<Nodo>solucion;
        LinkedList <Nodo> abiertos;
        private Nodo estadoActual,estadoInicial,estadoFinal;
        Reglas reglas;
        public BusquedaAnchura(Reglas reglas, String estadoInicial,String estadoFinal){
          this.reglas = reglas;      
          this.estadoInicial = new Nodo(crearEstado(estadoInicial));
          this.estadoFinal = new Nodo(crearEstado(estadoFinal));
          sucesores = new LinkedList<Nodo>();
          abiertos = new LinkedList<Nodo>();
          recorrido =  new ArrayList<Nodo>();
          solucion =  new ArrayList<Nodo>();
          
        }
        
        public void iniciarBusquedaAnchura(){
            abiertos.push(estadoInicial);
            estadoActual =abiertos.pop();
            estadoActual.setNodoPadre(estadoActual);
            recorrido.add(estadoActual);      
            while(!estadoActual.textNodo().equals(estadoFinal.textNodo())){
                 sucesores(estadoActual);
                 agregaSucesoresaAbiertos();
                 estadoActual =abiertos.pollLast();
                 recorrido.add(estadoActual);        
            }       
        }
        public ArrayList<Nodo> recorrido(){
                System.out.println("Anchura: ");
                for(Nodo r: recorrido){
                        System.out.println(crearEstado2(r.oNodo())+" -> ");                                    
                }                     
                System.out.println("");
                return recorrido;
        }
        
        public ArrayList<Nodo> solucion(){
               Stack<Nodo> aux1  = new Stack<>();
                Nodo aux =   recorrido.get(recorrido.size()-1).getNodoPadre();
                while(!aux.textNodo().equals(estadoInicial.textNodo())){
                        aux1.push(aux);
                       aux = aux.getNodoPadre();
                }  
                aux1.push(estadoInicial);           
                int j =  aux1.size();
                for(int i = 0 ; i < j; i++)
                        solucion.add(aux1.pop());
                solucion.add(estadoFinal);
             return solucion;
        }
      public void agregaSucesoresaAbiertos(){
         int n= sucesores.size();
         int i;
         for(int j=0; j<n; ++j){
               i=0;
               for(Nodo r : recorrido)
                  if(sucesores.peekFirst().textNodo().equals(r.textNodo()))
                     i++;
               if(i>0) 
                  sucesores.pollFirst();
               else{
                  int o =0;
                  for(Nodo t : abiertos)
                     if(sucesores.peekFirst().textNodo().equals(t.textNodo()))
                        o++;
                  if(o<1) {
                     abiertos.push(sucesores.pollFirst());
                  }
               }
         }         
      }

              
        public void sucesores(Nodo actual){
                Nodo n = new Nodo(actual);
                if(reglas.cruzaSolo(n)) {
                     Nodo aux=  reglas.cruzar(n, "granjero");
                     aux.setNodoPadre(actual);
                       sucesores.add(aux); 
                }
                n = new Nodo(actual);
                if(reglas.cruzaConLobo(n) ) {
                     Nodo aux=  reglas.cruzar(n, "lobo");
                     aux.setNodoPadre(actual);
                       sucesores.add(aux); 
                }
                n = new Nodo(actual);
                if(reglas.cruzaConCabra(n)) {
                     Nodo aux=  reglas.cruzar(n, "cabra");
                     aux.setNodoPadre(actual);
                     sucesores.add(aux); 
                }
                n = new Nodo(actual);
                if( reglas.cruzaConCol(n)) {
                     Nodo aux=  reglas.cruzar(n, "col");
                     aux.setNodoPadre(actual);
                       sucesores.add(aux);              
                }
        }
        private ArrayList<Integer> crearEstado(String estado){
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
         //       System.out.println(est);
                return est;
        }
        private String crearEstado2(String estado){
                String est =  " ";
                String[] parts = estado.split(",");
               if(parts[0].equals("1")) est+="d";
               else  est+="i";
               if(parts[1].equals("1")) est+="d";
               else  est+="i";
                if(parts[2].equals("1")) est+="d";
               else  est+="i";
               if(parts[3].equals("1")) est+="d";
               else est+="i";
                return est;
        }

      
}
