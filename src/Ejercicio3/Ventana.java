
package Ejercicio3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Ventana extends JFrame{
    private JPanel panel;
    private JLabel etiquetaEscalaColor;
    private JButton rojo, verde, azul;
    private int pulsado=0;
    private int contadorRojo=0, contadorVerde=0, contadorAzul=0;    
    public Ventana(){
        setSize(600, 400);
        setTitle("Juega con los colores RGB");
        setLocationRelativeTo(null);
        
        iniciarComponentes();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentes(){
        panel();
        etiquetas();
        botones();
    }
    
    public void panel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
        eventoRuedaDelRaton(); 
    }
    
    public void etiquetas(){
        etiquetaEscalaColor = new JLabel("Color: Rojo, Verde, Azul");
        etiquetaEscalaColor.setBounds(100, 30, 400, 50);
        etiquetaEscalaColor.setFont(new Font("arial", 0, 20));
        etiquetaEscalaColor.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiquetaEscalaColor);
    }
    
    public void botones(){
        /*
             pulsado = 1 ->Rojo
             pulsado = 2 ->Verde
             Pulsado = 3 ->Azul
        */
        rojo = new JButton("ROJO");
        rojo.setBounds(50, 230, 130, 50);
        rojo.setForeground(Color.RED);
        rojo.setFont(new Font("Arial", 1, 20));
        panel.add(rojo);
        
        rojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 1;
            }
        });
        
        verde = new JButton("VERDE");
        verde.setBounds(230, 230, 130, 50);
        verde.setForeground(Color.GREEN);
        verde.setFont(new Font("Arial", 1, 20));
        panel.add(verde);
        
        verde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 2;
            }
        });
        
        azul = new JButton("AZUL");
        azul.setBounds(410, 230, 130, 50);
        azul.setForeground(Color.BLUE);
        azul.setFont(new Font("Arial", 1, 20));
        panel.add(azul);
        
        azul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 3;
            }
        });
    }
    
    public void eventoRuedaDelRaton(){
        MouseWheelListener eventoRueda = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(pulsado != 0){
                    if(pulsado == 1){ //Se ha pulsado el boton Rojo
                        contadorRojo += e.getWheelRotation();
                        if(contadorRojo < 0){
                            contadorRojo = 0;
                        }
                        else if(contadorRojo > 255){
                            contadorRojo = 255;
                        }
                    }
                    else if(pulsado == 2){ //Se ha pulsado el boton Verde
                        contadorVerde += e.getWheelRotation();
                        if(contadorVerde < 0){
                            contadorVerde = 0;
                        }
                        else if(contadorVerde> 255){
                            contadorVerde= 255;
                        }
                    }
                    else{ //Se ha pulsado el boton Azul
                        contadorAzul += e.getWheelRotation();
                        if(contadorAzul < 0){
                            contadorAzul = 0;
                        }
                        else if(contadorAzul > 255){
                            contadorAzul = 255;
                        }
                    }
                    etiquetaEscalaColor.setText("Color: Rojo= "+contadorRojo+", Verde= "+contadorVerde+", Azul= "+contadorAzul);
                    panel.setBackground(new Color(contadorRojo, contadorVerde, contadorAzul));
                }
            }
        };
        panel.addMouseWheelListener(eventoRueda);
    }
}
