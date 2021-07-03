/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;


/**
 *
 * @author ternu
 */
public class enemigo {
    
    //objeto de la clase
    Juego jueguito;
    
    //variables que delimitan el area del enemigo
    Area cabeza,cuerpo,enemig;
    
    //variables de tamaño del personaje
    int anchoEnemigo=70;
    int altoEnemigo=70;
    
    //cordenadas iniciales donde se ubica el enemigo
    static int x_inicial=1300;
    static int y_inicial=270;
    
    //cordenadas para manipular enemigo
    static int x_auxiliar = -4;
    //int y_auxiliar=0;
    
      public enemigo(Juego jueguito){
        this.jueguito=jueguito;
        
    }

    public enemigo(Juego jueguito, Area cabeza, Area cuerpo, Area enemi) {
        this.jueguito = jueguito;
        this.cabeza = cabeza;
        this.cuerpo = cuerpo;
        this.enemig = enemi;
    }
      
      
   public void mover(){
      if(x_inicial<=-100){
          jueguito.puntos++;
          x_inicial=1300;
          if(jueguito.puntos==3 | jueguito.puntos==6 | jueguito.puntos==9 | jueguito.puntos==12){
             x_auxiliar+=-2;
             jueguito.nivel++;
          }
      }else{
          if(colision()){
              if(jueguito.vidas==0){
                  jueguito.finJuego();
              }else{
                  jueguito.pierdeVida();
              }
          }else{
          x_inicial+=x_auxiliar;
          
      } 
       
   }
   }
    
    public void paint(Graphics2D g){
        ImageIcon enemi=new ImageIcon(getClass().getResource("/multimedia/bomba.png"));
        g.drawImage(enemi.getImage(), x_inicial,y_inicial,anchoEnemigo,altoEnemigo,null);
  
    }
    
    
    public Area getBounds(){
        
        
        Ellipse2D forma1=new Ellipse2D.Double(x_inicial,y_inicial,40,40);
        Rectangle forma2=new Rectangle(x_inicial+12,y_inicial+16,50,53);
        
       cabeza=new Area(forma1);
       cuerpo=new Area(forma2);
     
       enemig=cabeza;
       enemig.add(cabeza);
       enemig.add(cuerpo);
        return enemig;
        
    }
    
    public boolean colision(){
        Area areA=new Area(jueguito.perso.getBounds());
        areA.intersect(getBounds());
        
        return !areA.isEmpty();
    }
}

    

    

