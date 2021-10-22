package ProyectoIA_PGranjero;
import ProyectoIA_PGranjero.modelo.BusquedaAnchura;
import ProyectoIA_PGranjero.modelo.BusquedaProfundidad;
import ProyectoIA_PGranjero.modelo.Nodo;
import ProyectoIA_PGranjero.modelo.Reglas;
import ProyectoIA_PGranjero.vista.Ventana;
import java.util.ArrayList;

public class Controlador {
    private Ventana ventana;
    private Reglas reglas;
    Controlador(){
       reglas = new Reglas();
       ventana = new Ventana(this);
        ventana.setVisible(true);
    } 
    
       public void iniciarBusquedaProfundidad(String estadoInicial, String estadoFinal) throws InterruptedException{
                BusquedaProfundidad bp=new BusquedaProfundidad(reglas, estadoInicial,estadoFinal);             
                bp.iniciarBusquedaProfundidad(); 
                ventana.IniciarAnimacion(bp.solucion());
       }
       public void iniciarBusquedaAnchura(String estadoInicial, String estadoFinal) throws InterruptedException{
                BusquedaAnchura ba=new BusquedaAnchura(reglas, estadoInicial,estadoFinal);   
                ba.iniciarBusquedaAnchura();
                ventana.IniciarAnimacion(ba.solucion());

       }
    public void pausar(){
      ventana.suspenderhilo();
    }
    public void renaudar(){
      ventana.renaudarhilo();
    }
    public void aumentarVelocidad(){
      ventana.aumentarV();
    }
    public void disminuirVelocidad(){
      ventana.disminuirV();
    }
       public void reiniciar(){
               ventana.reiniciar();
       }
        public boolean verificarEstadoInicial(String estado){
            return reglas.restricciones(new Nodo(reglas.crearEstado(estado)));
        }
        public boolean verificarEstadoFinal(String estado){
            return reglas.restricciones(new Nodo(reglas.crearEstado(estado)));
        }
   
    
    
}
