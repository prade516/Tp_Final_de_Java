package negocio;

import data.Data_Personas;
import entidades.Propiedad_Persona;
import utils.ApplicationException;

public class MetodoJuego {

	private data.Data_Personas dataP;
	private Propiedad_Persona jugador1,jugador2,jugador_Turno_Actual;
	private boolean terminal_Combate;
	
	
	public boolean isFinCombate() {
		return terminal_Combate;
	}


	public void setFinCombate(boolean finCombate) {
		this.terminal_Combate = finCombate;
	}


	public MetodoJuego(){
		dataP=new Data_Personas();
	}
	
	
    public Propiedad_Persona getJugadorTurnoActual() {
		return jugador_Turno_Actual;
	}
  
        
    public void generarNuevoTurno(){

    		if(jugador1.equals(jugador_Turno_Actual)){
    			jugador_Turno_Actual=jugador2;
    		}else{
    			jugador_Turno_Actual=jugador1;
    		}
    }
    	
    
    	
	public void Primer_Turno_Aleatorio() {
		double numeroAleatorio;
		do {
    		numeroAleatorio=Math.random();
    		
			if (numeroAleatorio > 0.5) {
				jugador_Turno_Actual=jugador1;
			} else {
				jugador_Turno_Actual=jugador2;
			} 
		} while (numeroAleatorio==0.5);
	}
    
	
    public void ataque(int puntos_Ataque) throws ApplicationException{

		if(jugador1==null || jugador2==null){
			throw new ApplicationException("Primero ingrese lo personajes y luego genere una nueva partida");
		}
    	
    	if(jugador_Turno_Actual.equals(jugador1)){
    		
    		if(jugador1.getEnergiaActual()<puntos_Ataque){
    			throw new ApplicationException("Puntos ataque deben ser menor que energia actual del atacante");
    		}
    		
    		jugador1.atacar(puntos_Ataque);
    		jugador2.recibirAtaque(puntos_Ataque);
    		if(jugador2.getVidaActual()<=0){
    			terminal_Combate=true;
    			combateGanado(jugador1);
    		}
    	}else{
    		
    		if(jugador2.getEnergiaActual()<puntos_Ataque){
    			throw new ApplicationException("Puntos ataque deben ser menor que energia actual del atacante");
    		}
    		
    		jugador1.recibirAtaque(puntos_Ataque);
    		jugador2.atacar(puntos_Ataque);
    		if(jugador1.getVidaActual()<=0){
    			terminal_Combate=true;
    			combateGanado(jugador2);
    		}
    	}
    	
    	if(!terminal_Combate){
    		generarNuevoTurno();
    	}
    	
    }

    
    public void combateGanado(Propiedad_Persona j){
    	j.aumentaPuntosTotales();
    	dataP.update(j);
    }
    
    public void defensa(Propiedad_Persona j){
    	
    }


	public void setJugador1(Propiedad_Persona personas) {
		jugador1=personas;
	}


	public void setJugador2(Propiedad_Persona personas) {
		jugador2=personas;
	}
	
	

	public Propiedad_Persona getJugador1() {
		return jugador1;
	}


	public Propiedad_Persona getJugador2() {
		return jugador2;
	}


	public void setJugadorTurnoActual(Propiedad_Persona jugadorTurnoActual) {
		this.jugador_Turno_Actual = jugadorTurnoActual;
	}
	public Propiedad_Persona getByNombre(String nombre) throws ApplicationException{
		Propiedad_Persona personas = new Propiedad_Persona();
		Propiedad_Persona respuesta = new Propiedad_Persona();
		personas.setNombre(nombre);
		respuesta=dataP.getByNombre(personas);
		if(respuesta==null) throw new ApplicationException();
		return respuesta;
		
	}
	
	public void Partido_Nuevo(Propiedad_Persona jugador1,Propiedad_Persona jugador2) throws ApplicationException{
			
		if(jugador1==null || jugador2==null){
			throw new ApplicationException("Ingrese personajes para jugar");
		}else{
			if(jugador1.equals(jugador2)){
				throw new ApplicationException("Ingrese dos personajes diferentes");
			}else{				
				  
			      setJugador1(jugador1);
			      setJugador2(jugador2);
		          terminal_Combate=false;
		          Primer_Turno_Aleatorio();
			}
		}
	}
			
    
}
