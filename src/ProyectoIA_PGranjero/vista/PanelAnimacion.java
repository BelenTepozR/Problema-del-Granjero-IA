package ProyectoIA_PGranjero.vista;
import java.awt.Color;
import javax.swing.JPanel;
import ProyectoIA_PGranjero.Controlador;
import ProyectoIA_PGranjero.modelo.Nodo;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

public class PanelAnimacion extends JPanel {
    private final Controlador controlador;
    private Ventana gUI;
    public  int index=1;
    public   int izquierda=20, derecha=700;
    private int xCol =0, xLobo = 50 , xCabra = 25,xGranjero = 80,xCanoa = 110;
    ArrayList<Nodo>recorrido;
    Nodo aux ;
    Image imagenInterna = new ImageIcon(getClass().getResource("fondo.jpg")).getImage();
    Image col = new ImageIcon(getClass().getResource("col.png")).getImage();
    Image cabra = new ImageIcon(getClass().getResource("cabra.png")).getImage();
    Image lobo = new ImageIcon(getClass().getResource("lobo.png")).getImage();
    Image granjero = new ImageIcon(getClass().getResource("granjero.png")).getImage();
     Image canoa = new ImageIcon(getClass().getResource("canoa.png")).getImage();

    
    public PanelAnimacion(Controlador controlador, Ventana gUI){
        recorrido = new ArrayList<>();
        this.controlador = controlador;
        this.gUI = gUI;
        init();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);  
        g.drawImage(imagenInterna, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(col, xCol, 350, 80, 80, this); 
        g.drawImage(cabra, xCabra, 350, 80, 80, this);      
        g.drawImage(lobo, xLobo, 350, 80, 80, this);
        g.drawImage(granjero, xGranjero, 350, 100, 100, this);
        g.drawImage(canoa, xCanoa, 400, 150, 150, this);
        setOpaque(false);    
    }

    
        private void init(){ 
            this.setLayout(null);
            this.setBackground(new Color(255, 255, 255));
            this.getPreferredSize();
        }  
        public void hacerRecorrido(){
                if(index < recorrido.size()){
                   aux = recorrido.get(index);                 
                }
        }

        public int getxGranjero() {
                return xGranjero;
        }

        public void setxGranjero(int xGranjero) {
                this.xGranjero = xGranjero;
        }

        public int getxCol() {
                return xCol;
        }

        public void setxCol(int xCol) {
                this.xCol = xCol;
        }

        public int getxLobo() {
                return xLobo;
        }

        public void setxLobo(int xLobo) {
                this.xLobo = xLobo;
        }

        public int getxCabra() {
                return xCabra;
        }

        public void setxCabra(int xCabra) {
                this.xCabra = xCabra;
        }

        public int getxCanoa() {
                return xCanoa;
        }

        public void setxCanoa(int xCanoa) {
                this.xCanoa = xCanoa;
        }

        public ComponentUI getUi() {
                return ui;
        }

        public void setUi(ComponentUI ui) {
                this.ui = ui;
        }

        public EventListenerList getListenerList() {
                return listenerList;
        }

        public void setListenerList(EventListenerList listenerList) {
                this.listenerList = listenerList;
        }



        public ArrayList<Nodo> getRecorrido() {
                return recorrido;
        }

        public void setRecorrido(ArrayList<Nodo> recorrido) {
                this.recorrido = recorrido;
                gUI.agregarR("SOLUCIÓN ENCONTRADA: \n\nCruza Granjero "+hacerR(recorrido.get(0),recorrido.get(1)));
        }

        public int getIndex() {
                return index;
        }

        public void setIndex(int index) {
               if((index) < recorrido.size())
                          gUI.agregarR("Cruza Granjero " +   hacerR(recorrido.get(index-1),recorrido.get(index)));
                this.index = index;
        }

        public Nodo getAux() {
                return aux;
        }

        public void setAux(Nodo aux) {
                this.aux = aux;
        }
        public String hacerR(Nodo inicio, Nodo fin){
                    if(inicio.getLobo()== 1 && fin.getLobo() == 0)
                        return "Con Lobo \n  a la Izquierda\n";
                    if(inicio.getLobo() == 0 && fin.getLobo() == 1)
                        return "Con Lobo \n  a la Derecha\n";
                    if(inicio.getCabra()== 1 && fin.getCabra() == 0)
                        return "Con Cabra \n a la Izquierda\n";
                    if(inicio.getCabra() == 0 && fin.getCabra() == 1)
                        return "Con Cabra\n a la Derecha\n";
                    if(inicio.getKol()== 1 && fin.getKol() == 0)
                        return  "Con Col\n a la Izquierda\n";
                    if(inicio.getKol() == 0 && fin.getKol() == 1)
                        return  "Con Col \na la Derecha\n";
                return " Solo \n";
        }

        void reiniciar() {
             recorrido = new ArrayList<>();
             index=1;
             izquierda=20;
             derecha=700;
             xCol =0;
             xLobo = 50;
             xCabra = 25;
             xGranjero = 80;
             xCanoa = 110;
             this.repaint();
        } 
  
}
   
