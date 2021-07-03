/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ternu
 */
public class principal {
    
  public static int reiniciarJuego=-1;
    

    
    public static void main(String[]args){
        
        JOptionPane.showMessageDialog(null, "¿Estas listo?");
        
        JFrame ventana = new JFrame("Jueguito");
        Juego jueguito=new Juego();
        ventana.add(jueguito);
        ventana.setSize(1300,400);
        //centramos la ventana con el location
        ventana.setLocation(70,200);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            if(jueguito.juegoFinalizado){
                reiniciarJuego=JOptionPane.showConfirmDialog(null, "Haz perdido. ¿Quieres jugar de nuevo?","Haz perdido",JOptionPane.YES_NO_OPTION);
                if(reiniciarJuego==0){
                    reiniciarValores();
                
            }else if(reiniciarJuego ==1){
                System.exit(0);
            }
        }else{
            jueguito.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(Juego.pierdeVida==true){
                JOptionPane.showMessageDialog(null, "Cuidado!!!");
                Juego.pierdeVida=false;
                Juego.vidas--;
                personaje.y_inicial=270;
                personaje.saltando=false;
                enemigo.x_inicial=1300;
            }
            
            
                }
      
        }
        
    }
    
    public static void reiniciarValores(){
        Juego.juegoFinalizado=false;
        enemigo.x_auxiliar=-4;
        Juego.puntos=0;
        Juego.nivel=1;
        Juego.vidas=3;
        reiniciarJuego=-1;
        enemigo.x_inicial=1300;
    }
}
