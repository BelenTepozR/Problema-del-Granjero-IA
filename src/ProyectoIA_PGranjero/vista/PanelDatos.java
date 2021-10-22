package ProyectoIA_PGranjero.vista;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import ProyectoIA_PGranjero.Controlador;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelDatos extends JPanel {
    private Controlador controlador;
    private JTextField txtEstadoInicial, txtEstadoFinal;
    private JLabel lbEstadoInicial, lbEstadoFinal;
    private JButton btAnimacion,botonReiniciar,botonAumentarV,botonDisminuirV,botonPause;
    private Ventana ventana;
    private JRadioButton rbProfundidad, rbAnchura;
    private ButtonGroup bgBusquedas;

    private final Font placeholder = new Font("Calibri Light",Font.PLAIN, 25);
    private final Font rb = new Font("Calibri Light",Font.PLAIN, 25);
    private final Color colorFondo = new Color(150, 236, 239);
    PanelDatos(Controlador controlador,Ventana ventanaPrincipal) {
        this.setLayout(null);
        this.controlador = controlador;
        init();
        this.ventana = ventanaPrincipal;
        this.setSize(100, this.getWidth());
    }
    private void init(){
        this.setBackground(colorFondo);
        this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        colocarBotones();
        initEvents();
    }
    private void colocarBotones(){       
        lbEstadoInicial = new JLabel("Estado Inicial ");
        lbEstadoInicial.setFont(placeholder);
        lbEstadoInicial.setBounds(100,20,150, 40);
        this.add(lbEstadoInicial);
        txtEstadoInicial = new JTextField(100);
        txtEstadoInicial.setEditable(true);
        txtEstadoInicial.setBackground(Color.white);
        txtEstadoInicial.setFont(placeholder);
        txtEstadoInicial.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        txtEstadoInicial.setBounds(103,65,150, 40);
        this.add(txtEstadoInicial);
        lbEstadoFinal = new JLabel("Estado Final ");
        lbEstadoFinal.setFont(placeholder);
        lbEstadoFinal.setBounds(330,20,150, 40);
        this.add(lbEstadoFinal);
        txtEstadoFinal = new JTextField(100);
        txtEstadoFinal.setEditable(true);
        txtEstadoFinal.setBackground(Color.white);
        txtEstadoFinal.setFont(placeholder);
        txtEstadoFinal.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        txtEstadoFinal.setBounds(330,65,150, 40);
        this.add(txtEstadoFinal);
        
        
        rbProfundidad = new JRadioButton("B. Profundidad") ;
        rbProfundidad.setFont(rb);
        rbProfundidad.setBounds(530,40,200, 30);
        rbProfundidad.setBackground(colorFondo);
      
        this.add(rbProfundidad);
        rbAnchura = new JRadioButton("B. Anchura") ;
        rbAnchura.setFont(rb);
        rbAnchura.setBounds(530,75,200, 40);
        rbAnchura.setBackground(colorFondo);
        
        this.add(rbAnchura);
        bgBusquedas = new ButtonGroup();
        bgBusquedas.add(rbAnchura);
        bgBusquedas.add(rbProfundidad);
        
        
        btAnimacion =new JButton ();
        btAnimacion.setBackground(colorFondo);
        ImageIcon clik5 = new ImageIcon("animacion.png");
        btAnimacion.setIcon(new ImageIcon(clik5.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        this.add(btAnimacion);
        btAnimacion.setEnabled(false);
        btAnimacion.setBounds(800,20,45, 45);
        btAnimacion.setBorderPainted(false);
        btAnimacion.setToolTipText("Iniciar Animacion");
             
        botonReiniciar =new JButton ();
        botonReiniciar.setBackground(colorFondo);
        ImageIcon clik2 = new ImageIcon("reiniciar.png");
        botonReiniciar.setIcon(new ImageIcon(clik2.getImage().getScaledInstance(52, 52, Image.SCALE_SMOOTH)));
        botonReiniciar.setBounds(800,65,52, 52);
        botonReiniciar.setEnabled(false);
        this.add(botonReiniciar); 
        botonReiniciar.setBorderPainted(false);
        botonReiniciar.setToolTipText("Reiniciar");
        
          botonAumentarV =new JButton ();
        botonAumentarV.setBackground(colorFondo);
        ImageIcon clik3 = new ImageIcon("mas.png");
        botonAumentarV.setIcon(new ImageIcon(clik3.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
        botonAumentarV.setBounds(390,118,30, 30);
        this.add(botonAumentarV); 
        botonAumentarV.setBorderPainted(false);
        botonAumentarV.setToolTipText("Aumentar la Velocidad");
        
        botonDisminuirV =new JButton ();
        botonDisminuirV.setBackground(colorFondo);
        ImageIcon clik7 = new ImageIcon("menos.png");
        botonDisminuirV.setIcon(new ImageIcon(clik7.getImage().getScaledInstance(33, 33, Image.SCALE_SMOOTH)));
        botonDisminuirV.setBounds(280,120,30, 30);
        this.add(botonDisminuirV); 
        botonDisminuirV.setBorderPainted(false);
        botonDisminuirV.setToolTipText("Disminuir Velocidad");
        
      botonAumentarV.setVisible(false);
       botonDisminuirV.setVisible(false);
      
       botonPause =new JButton ();
        botonPause.setBackground(colorFondo);
        ImageIcon clik1 = new ImageIcon("pauseplay.png");
        botonPause.setIcon(new ImageIcon(clik1.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        botonPause.setBounds(330,115,40, 40);
        botonPause.setVisible(false);
        this.add(botonPause); 
        botonPause.setBorderPainted(false);
        botonPause.setToolTipText("Pausar");  
    }
    
    
    private void initEvents(){
         rbProfundidad.addActionListener((ActionEvent e) -> {       
                         btAnimacion.setEnabled(true);
         });
          rbAnchura.addActionListener((ActionEvent e) -> {   
                         btAnimacion.setEnabled(true);
         });
        btAnimacion.addActionListener((ActionEvent e) -> {
            if(!controlador.verificarEstadoInicial(txtEstadoInicial.getText()) || !controlador.verificarEstadoFinal(txtEstadoFinal.getText())){
                if(!controlador.verificarEstadoInicial(txtEstadoInicial.getText()) && !controlador.verificarEstadoFinal(txtEstadoFinal.getText()))
                  JOptionPane.showMessageDialog(null,  "Los estados ingresados no son válidos");
                else{
                  if(!controlador.verificarEstadoInicial(txtEstadoInicial.getText()))
                    JOptionPane.showMessageDialog(null,  "El estado inicial no es válido");        
                  if(!controlador.verificarEstadoFinal(txtEstadoFinal.getText()))
                    JOptionPane.showMessageDialog(null,  "El estado final no es válido");
                }
            }else{
                if((!rbProfundidad.isSelected() && !rbAnchura.isSelected()) )
                       JOptionPane.showMessageDialog(null,  "Seleccione alguna búsqueda");   
                else{
                        btAnimacion.setEnabled(false);
                         botonReiniciar.setEnabled(true);
                         botonPause.setVisible(true);
                         botonAumentarV.setVisible(true);
                         botonDisminuirV.setVisible(true);
                        if(rbProfundidad.isSelected())  {
                                try {
                                        controlador.iniciarBusquedaProfundidad(txtEstadoInicial.getText(),txtEstadoFinal.getText());
                                } catch (InterruptedException ex) {
                                        Logger.getLogger(PanelDatos.class.getName()).log(Level.SEVERE, null, ex);
                                }
                           
                        }
                        if(rbAnchura.isSelected())  {
                                try {
                                        controlador.iniciarBusquedaAnchura(txtEstadoInicial.getText(),txtEstadoFinal.getText());
                                } catch (InterruptedException ex) {
                                        Logger.getLogger(PanelDatos.class.getName()).log(Level.SEVERE, null, ex);
                                }
                           
                        }
                }
                       
            }
           
        });  
          botonReiniciar.addActionListener((ActionEvent e) -> {
           txtEstadoInicial.setText("");
           txtEstadoFinal.setText("");
           bgBusquedas.clearSelection();
            botonPause.setVisible(false);
           rbProfundidad.setSelected(false);
           btAnimacion.setEnabled(false);
           botonReiniciar.setEnabled(false);
            botonAumentarV.setVisible(false);
           botonDisminuirV.setVisible(false);
           rbAnchura.setSelected(false);
           controlador.reiniciar();
           
        });
          botonPause.addActionListener((ActionEvent e) -> {
                if(botonPause.getToolTipText()=="Pausar"){
                   controlador.pausar();
                   botonPause.setToolTipText("Reanudar");  
                }else{
                   controlador.renaudar();
                   botonPause.setToolTipText("Pausar");  
                }

        }); 
        botonDisminuirV.addActionListener((ActionEvent e) -> {
          controlador.disminuirVelocidad();
        }); 
        botonAumentarV.addActionListener((ActionEvent e) -> {
          controlador.aumentarVelocidad();
        });
    }
}
