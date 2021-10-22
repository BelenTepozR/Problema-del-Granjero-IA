package ProyectoIA_PGranjero.vista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ProyectoIA_PGranjero.Controlador;
import ProyectoIA_PGranjero.modelo.Nodo;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ventana extends JFrame{
    private Controlador controlador;
    private PanelDatos pEncabezado;
    private PanelAnimacion pAnimacion ;
    private JScrollPane panelRecorrido;
    private JTextArea areaRecorrido;
    private JPanel panelBase;
    private int panel=800;
    private boolean ver = true;
    private final Font rb = new Font("Calibri Light",Font.BOLD, 15);
   Personaje  granjero, lobo,cabra,col;
    public Ventana(Controlador controller){   
        super("Problema del Granjero");
        
        this.controlador = controller;
        panelBase = new JPanel();
        panelBase.setLayout(new BorderLayout());
         this.setContentPane(panelBase);    this.setLayout(null);
        init();
    }
    
 
    public void init(){
         this.setResizable(false);
        this.setMinimumSize(new Dimension(1000,700));
      
        pEncabezado = new PanelDatos(this.controlador,this);
        pEncabezado.setBounds(0, 0, 1000, 150);
        panelBase.add (pEncabezado);
      
        pAnimacion = new PanelAnimacion(this.controlador,this);
        pAnimacion.setBounds(0, 0, panel, 670);
        panelBase.add(pAnimacion);
            
        
        areaRecorrido = new JTextArea();
        areaRecorrido.setEditable(false);
        areaRecorrido.setFont(rb);
        panelRecorrido = new JScrollPane( areaRecorrido);
        panelRecorrido.setBounds(800,150 , 180, 570);
        panelRecorrido.setVisible(ver);
        
        panelBase.add(panelRecorrido);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public PanelAnimacion getPanelTabla(){
        return this.pAnimacion;
    }
    public static void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }


    public void IniciarAnimacion(ArrayList<Nodo> ver) throws InterruptedException{
        pAnimacion.setRecorrido(ver);
        granjero = new Personaje(pAnimacion,"granjero");
        lobo = new Personaje(pAnimacion,"lobo");
        cabra = new Personaje(pAnimacion,"cabra");
        col = new Personaje(pAnimacion,"col");
        granjero.start();
        lobo.start();
        cabra.start();
        col.start();
       
    }
public void suspenderhilo(){
        granjero.suspenderhilo();
        lobo.suspenderhilo();
        cabra.suspenderhilo();
        col.suspenderhilo();
    }
    public void renaudarhilo(){
        granjero.renaudarhilo();
        lobo.renaudarhilo();
        cabra.renaudarhilo();
        col.renaudarhilo();
    }
    public void disminuirV(){
        granjero.aumentar();
        lobo.aumentar();
        cabra.aumentar();
        col.aumentar();
    }
     public void aumentarV(){
        granjero.disminuir();
        lobo.disminuir();
        cabra.disminuir();
        col.disminuir();
    }
    public void reiniciar(){
            areaRecorrido.setText("");
            pAnimacion.reiniciar();
    }
    public void agregarR(String recorrido){
            areaRecorrido.setText(areaRecorrido.getText() +" \n" +recorrido);
    
    }
  
}
