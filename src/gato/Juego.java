/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import java.util.Scanner;

/**
 *
 * @author alberto
 */
public final class Juego {
    int partidas;
    TablerodelJuego tablero;

    Jugador pc=new Jugador(2,1);
    public Juego(){
     this.partidas=0;
        this.tablero=new TablerodelJuego();      
        this.reset() ;  
    }
    public void reset(){
        this.tablero.limpiartablero();
        this.tablero.dibujarTablero();
        if (this.partidas%2==1)
        {
            pc.setstatus(1);
            System.out.println("Turno del jugador 2");
            this.tablero.marcar(pc.getNJugador(),(int)(Math.random()*8));
            this.tablero.dibujarTablero();
        }
        this.partidas++;
        pc.setstatus(0);
         System.out.println("Turno del jugador 1");
    
        this.muevehumano();
        this.tablero.dibujarTablero();
    }
    public void muevehumano()
   {
       System.out.println("Elige una casilla diponible ");
       Scanner sc = new Scanner(System.in);
           int casilla = sc.nextInt();
           if(casilla>9 || casilla <1)
           {
              System.out.println("Elige una casilla valida"); 
              muevehumano();
           }    
           Juegolog(casilla-1); 
   
   }
    
    
     public  void  Juegolog(int posicion){
        if (this.pc.getstatus()==0)
        {
            if (this.tablero.casillalibre(posicion))
            {
                this.tablero.marcar(1,posicion);

                if (this.tablero.Ganador(1))
                {
                    this.pc.setstatus(2);
                    System.out.println("¡HAS GANADO!");
                    this.reset();
                }
                else if (!this.tablero.Hayceldas())
                {
                    this.pc.setstatus(2);
                     System.out.println("¡Empate!");
                     this.tablero.dibujarTablero();
                     this.reset();
                }
                else 
                {
                    this.pc.setstatus(1);
                    System.out.println("Turno de PC");
                    this.maquina();

                    if (this.tablero.Ganador(2))
                    {
                        this.pc.setstatus(2);
                        System.out.println("Gana PC");
                        this.reset();
                    }
                    else if (!this.tablero.Hayceldas())
                    {
                        this.pc.setstatus(2);
                        System.out.println("Empate");
                        this.tablero.dibujarTablero();
                        this.reset();
                    }
                    else
                    {
                       // System.out.println("tU Turno");
                        this.pc.setstatus(0);
                        this.muevehumano();
                    }
                }
            }
            else{
                System.out.println("Casilla ocupada elige otra");
                this.muevehumano();
            }
            //this.tablero.dibujarTablero();
        }
        else if (this.pc.getstatus()==2)
        {
            this.reset();
        }
    }
    public void maquina(){
        int posicion=0;
        int aux, mejor=-100;
        for (int i=0;i<9;i++)
        {
            if (this.tablero.casillalibre(i))
            {
                this.tablero.marcar(2,i);
                
                aux=this.minmax(2);
                if (aux>mejor)
                {
                    mejor=aux;
                    posicion=i;
                }
                this.tablero.marcar(0,i);
            }
        }
        this.tablero.marcar(2,posicion);
        this.tablero.dibujarTablero();
    }
    
   public  int minmax(int njugador){
       int mejor;
       int  aux;
       if (!this.tablero.Hayceldas()) return 0;
       if(njugador==2){
        if (this.tablero.Ganador(njugador)) return 1;
        mejor=100;
        for (int i=0;i<9;i++)
        {
            if (this.tablero.casillalibre(i))
            {
                this.tablero.marcar(1,i);
                aux=this.minmax(1);
                if (aux<mejor)
                {
                    mejor=aux;
                }
                this.tablero.marcar(0,i);
            }
        }
       }
        else{
             if (this.tablero.Ganador(njugador)) return -1;    
             mejor=-100;
        for (int i=0;i<9;i++)
        {
            if (this.tablero.casillalibre(i))
            {
                this.tablero.marcar(2,i);
                aux=this.minmax(2);
                if (aux>mejor)
                {
                    mejor=aux;
                }
                this.tablero.marcar(0,i);
            }
        }   
        }
        return mejor; 
    }
    
    public static void main(String []arg){
 Juego j=new Juego();
}
}
