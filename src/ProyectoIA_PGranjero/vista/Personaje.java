package ProyectoIA_PGranjero.vista;

public class Personaje extends Thread{
    private PanelAnimacion panel;
    private String nombre;  
    boolean suspender=false; 
    int velocidad = 5;
    
    Personaje( PanelAnimacion panel, String nombre) throws InterruptedException{
        this.panel=panel;
        this.nombre = nombre;
        crearEstadoInicial();
    }
   
    
    public  void run(){   
        while(true){ 
            cargar();
        }         
    }
    
    
   public void cargar(){                
     try {  
       synchronized (this) {
           while (suspender) {
               wait();
           }
       }
             
             
        panel.hacerRecorrido();
        if(panel.getIndex() <= panel.recorrido.size()){
            switch(this.nombre){
                case  "granjero":
                        moverGranjero();
                        break;
                case  "cabra":
                         moverCabra();
                        break;                     
                case  "col":
                         moverCol();
                        break;                     
                case  "lobo":
                         moverLobo();
                        break;
         }
        }else{                                   
                try {
                      join();
                } catch (InterruptedException ex) {
                       System.out.println(ex.getMessage());
                }
         } 
        panel.repaint();
        synchronized (this) {
            Thread.sleep(velocidad);
        }
       
        } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
        }
   }
   
        void moverGranjero(){
          if(panel.aux.getGranjero() == 1 ){
                panel.setxGranjero(panel.getxGranjero()+1);
                if(panel.getxCanoa()<= panel.derecha-150)
                       panel.setxCanoa(panel.getxGranjero());

                if(panel.getxGranjero()>= panel.derecha)
                              panel.setIndex(panel.getIndex()+1);                       
              }else{   
                  panel.setxGranjero(panel.getxGranjero()-1);
                  if(panel.getxCanoa()>= panel.izquierda+80)
                        panel.setxCanoa(panel.getxGranjero());

                  if(panel.getxGranjero() <= panel.izquierda)
                                 panel.setIndex(panel.getIndex()+1);                 
              }                              
         }
        void moverLobo(){             
                if(panel.aux.getLobo()== 1){
                  if( panel.getxLobo() < panel.derecha){
                        panel.setxLobo(panel.getxLobo()+1);

                  }
                }else{
                  if( panel.getxLobo() > panel.izquierda){
                        panel.setxLobo(panel.getxLobo()-1);

                  }
                }                              
         }
           void moverCabra(){
                if(panel.aux.getCabra()== 1){
                  if( panel.getxCabra() < panel.derecha){
                        panel.setxCabra(panel.getxCabra()+1);
                           
                  }
                }else{
                  if( panel.getxCabra() > panel.izquierda){
                        panel.setxCabra(panel.getxCabra()-1);
                              
                  }
                }                              
         }
             void moverCol(){              
                if(panel.aux.getKol()== 1){
                  if( panel.getxCol() < panel.derecha){
                        panel.setxCol(panel.getxCol()+1);
                           
                  }
                }else{
                  if( panel.getxCol() > panel.izquierda){
                        panel.setxCol(panel.getxCol()-1);
                              
                  }
                }                              
         }
        private void crearEstadoInicial() throws InterruptedException {
            switch(this.nombre){
                case  "granjero":
                          if( panel.recorrido.get(0).getGranjero()==1){
                                panel.setxGranjero(panel.derecha);
                                 panel.setxCanoa(panel.derecha-80);
                          }
                         else {
                                  panel.setxGranjero(panel.izquierda);
                                   panel.setxCanoa(panel.izquierda+80);
                          }
                        break;
                case  "cabra":
                             if( panel.recorrido.get(0).getCabra()==1)
                      panel.setxCabra(panel.derecha);
              else panel.setxCabra(panel.izquierda);
                        break;                     
                case  "col":
                        
              if( panel.recorrido.get(0).getKol()==1)
                      panel.setxCol(panel.derecha);
              else panel.setxCol(panel.izquierda);    
                        break;                     
                case  "lobo":
                         if( panel.recorrido.get(0).getLobo()==1)
                      panel.setxLobo(panel.derecha);
              else panel.setxLobo(panel.izquierda);
                        break;
           
           
       }
                      panel.repaint();
    }

    synchronized void suspenderhilo(){
        suspender=true;
    }

    synchronized void renaudarhilo(){
        suspender=false;
        notify();
    }
    synchronized void aumentar(){
        this.velocidad= this.velocidad + 1;
        notify();
    }
   synchronized void disminuir(){
       this.velocidad= this.velocidad - 1;
        notify();
    }
    
}
    
    