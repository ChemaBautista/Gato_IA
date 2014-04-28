/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

/**
 *
 * @author alberto
 */
public class TablerodelJuego {
    int panel[]={0,0,0,0,0,0,0,0,0};
    public void dibujarTablero(){
                 System.out.print("  "+panel[0] + "  |  " + panel[1] + "  |  " + panel[2] +  "         "+1+ "  |  " +2 + "  |  " + 3 );
                 System.out.println("\n-----------------");
                 System.out.print("  "+panel[3] + "  |  " + panel[4] + "  |  " + panel[5] +  "         "+4+ "  |  " +5 + "  |  " + 6);
                 System.out.println("\n-----------------");
                 System.out.print("  "+panel[6] + "  |  " + panel[7] + "  |  " + panel[8] +  "         "+7+ "  |  " +8 + "  |  " + 9); 
                 System.out.println("\n");
    }
    public void limpiartablero(){
       for(int i=0;i<panel.length;i++)
       {
           this.panel[i]=0;
       }
    }
    public boolean casillalibre(int posicion){//si la casillla es igual con cero, esta disponible
        if(this.panel[posicion]==0){
            return true;
        }
        return false;
    }
    public void marcar(int jugador,int posicion){
        this.panel[posicion]=jugador;
    }
    
    public boolean Ganador(int jugador){
      //HORIZONTAL
        boolean bool=(this.panel[0] == jugador && this.panel[1] == jugador && this.panel[2]==jugador);
        bool=bool || (this.panel[3] == jugador && this.panel[4] == jugador && this.panel[5]==jugador);
        bool=bool || (this.panel[6] == jugador && this.panel[7] == jugador && this.panel[8]==jugador);
        //VERTical
        bool=bool || (this.panel[0] == jugador && this.panel[3] == jugador && this.panel[6]==jugador);
        bool=bool || (this.panel[1] == jugador && this.panel[4] == jugador && this.panel[7]==jugador);
        bool=bool || (this.panel[2] == jugador && this.panel[5] == jugador && this.panel[8]==jugador);
        //DIAGONAl
        bool=bool || (this.panel[0] == jugador && this.panel[4] == jugador && this.panel[8]==jugador);
        bool=bool || (this.panel[2] == jugador && this.panel[4] == jugador && this.panel[6]==jugador);
        return bool;  
    }
    
    public boolean Hayceldas(){
        for (int i=0;i<panel.length;i++)
        {
            if (this.panel[i]==0)
            {
                return true;
            }
        }
        return false; 
    }
    
    
}


