/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;   
import javax.swing.ImageIcon;

/**
 *
 * @author ternu
 */
public class personaje {
    Juego jueguito;
    
    //variables que nos ayuda a saver si el personaje salta o no
    static boolean saltando=false;
    boolean sube=false;
    boolean baja=false;
    
    //variables que delimitan el area del objeto
    Area llantaDelantera,llantaTrasera,carroseria,nave;
    
    //variables de tamaño del personaje
    int anchoPersonaje=112;
    int altoPersonaje=78;
    
    //cordenadas iniciales de personaje
    static int x_inicial=50;
    static int y_inicial=270;
    
    //cordenadas para manipular personaje
    int x_auxiliar=0;
    int y_auxiliar=0;
    
    
    public personaje(Juego jueguito){
        this.jueguito=jueguito;
        
    }
    
    
    public void mover(){
        if(x_inicial+x_auxiliar>0 && x_inicial+x_auxiliar<jueguito.getWidth()-anchoPersonaje){
           x_inicial+=x_auxiliar; 
        }
        if(saltando){
            if(y_inicial==270){//si el personaje esta en el suelo (abajo)
                sube=true;
                y_auxiliar=-2;
                baja=false;
            }
            if(y_inicial==150){//si el personaje llega al limite del auto
                baja=true;
                y_auxiliar=2;
                sube=false;
            }
            
            if(sube){
                y_inicial+=y_auxiliar;
               
                    
                }
                 if(baja){
                  y_inicial+=y_auxiliar;
                 if(y_inicial==270){//si el auto llega al suelo
                     saltando=false;
                 }
            }
            }
        }
    
    
    
    public void paint(Graphics2D g){
        ImageIcon perso=new ImageIcon(getClass().getResource("/multimedia/personaje3.gif"));
        g.drawImage(perso.getImage(), x_inicial,y_inicial,anchoPersonaje,altoPersonaje,null);
    }
    
    public void KeyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            saltando=true;
        }
    }
    
    public Area getBounds(){
        Rectangle forma1=new Rectangle(x_inicial,y_inicial,95,62);
        carroseria=new Area(forma1);
        
        Ellipse2D forma2=new Ellipse2D.Double(x_inicial,y_inicial+28,48,48);
        llantaTrasera=new Area(forma2);
        
        Ellipse2D forma3=new Ellipse2D.Double(x_inicial+73,y_inicial+39,38,38);
        llantaDelantera=new Area(forma3);
        
        nave=carroseria;
        nave.add(carroseria);
        nave.add(llantaTrasera);
        nave.add(llantaDelantera);
        
        return nave;
        
        
    }
}

