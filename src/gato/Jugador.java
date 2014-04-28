/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

/**
 *
 * @author alberto
 */
public class Jugador {
    int njugador;
    int status;
  public Jugador(int njugador,int estado){
      this.njugador=njugador;
      this.status=estado;
  }  
  public int getNJugador(){
      return this.njugador;
  }
  public int getstatus(){
      return this.status;
  }
  public void setstatus(int status){
      this.status=status;
  }
}
