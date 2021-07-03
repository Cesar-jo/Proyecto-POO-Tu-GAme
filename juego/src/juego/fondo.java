/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author ternu
 */
public class fondo {
    //objeto de la clase juego
      Juego jueguito;
      
      //variables del tamaño del fondo
      int AnchoFondo=1300;
      int alto_Fondo=400;
      
      //cordenadas iniciales para mover el fondo
      int x1=1300;
      int y1=0;
      
      //coordenadas auxiliares que mueven otro fondo
      int x2=0;
      int y2=0;
    
      
    public fondo(Juego jueguito){
        this.jueguito=jueguito;
        
       
    
    }
    
    
    public void mover(){
        x1-=2;
        x2-=2;
        if(x1==0 && x2==-1300){
            x1=1300;
            x2=0;
        }
        
    }
    
      public void paint(Graphics2D g){
        ImageIcon imagenFondo=new ImageIcon(getClass().getResource("/multimedia/fondo5.gif"));
        g.drawImage(imagenFondo.getImage(), x1,y1,AnchoFondo,alto_Fondo,null);
        g.drawImage(imagenFondo.getImage(), x2,y2,AnchoFondo,alto_Fondo,null);
        
    }
    
    
}

    

