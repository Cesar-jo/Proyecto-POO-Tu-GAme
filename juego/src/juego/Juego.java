/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.JPanel;

/**
 *
 * @author ternu
 */
public class Juego  extends JPanel{
    
    //sonido del juego
    URL direccionSonidoSalto,direccionSonidoChoque;
    AudioClip sonidoChoque,sonidoSalto;
    
    
    //objetos de las clases personaje, enemigo y fondo
    personaje perso=new personaje(this);
    enemigo enem=new enemigo(this);
    fondo fond= new fondo(this);
    
    
    //variables del juego
    public static boolean juegoFinalizado=false;
    public static boolean pierdeVida=false;
    public static int vidas=3;
    //inicializamos desde 0 los puntos
    public static int puntos=0;
    public static int nivel=1;
    
    
    public Juego(){
        //direccionSonidoChoque=getClass().getResource("");
        //sonidoChoque=Applet.newAudioClip(direccionSonidoChoque);
        
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                perso.KeyPressed(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //EL SALTO SE ACTIVA CUANDO PRECIONEMOS LA TECLA ESPACIO
               if(e.getKeyCode()==KeyEvent.VK_SPACE){
                //sonidoSalto.play();
                perso.KeyPressed(e);
                    
            }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        setFocusable(true);
    }
    
    public void mover(){
        enem.mover();
        perso.mover();
        fond.mover(); 
    }

    @Override
  public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 =(Graphics2D)g;
      dibujar(g2);
      dibujarPuntaje(g2);
  }

    private void dibujar(Graphics2D g) {
        fond.paint(g);
        perso.paint(g);
        enem.paint(g);
        mover();
        
    }

    private void dibujarPuntaje(Graphics2D g) {
        Graphics2D g1=g, g2=g;
        Font score=new Font("Arial",Font.BOLD,30);
        g.setFont(score);
        g.setColor(Color.green);
        g1.drawString("Puntaje: " + puntos,1100,30);
        g1.drawString("Vidas: " + vidas,20,30);
        g1.drawString("Nivel: " + nivel,560,30);
        
        if(juegoFinalizado){
            g2.setColor(Color.red);
            g2.drawString(" ¡¡¡ Haz perdido !!! ",((float)getBounds().getCenterX()/2)+170,70);
            
        }
        
    }
    
    public void finJuego(){
        juegoFinalizado=true;
        //sonidoChoque.play();
    }
    
    public void pierdeVida(){
        //sonidoChoque.play();
        pierdeVida=true;
    }

}

