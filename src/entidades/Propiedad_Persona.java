package entidades;

public class Propiedad_Persona {
	static int PUNTOS_INICIALES=200;
	static int EVASION_MAXIMOS=80;
	static int DEFENSA_MAXIMO=20;
	static int PUNTOS_X_PARTIDA_GANADA=10;
	
	private int codigo;
	private String nombre;
	private int vida;
	private int energia;
	private int defensa;
	private int evasion;
	private int puntos_Totales;
	
	private int usoEnergia;
	private int dato;
	
	public Propiedad_Persona(){
		this.vida=0;
		this.defensa=0;
		this.energia=0;
		this.evasion=0;
		this.puntos_Totales=PUNTOS_INICIALES;
		//?
		this.usoEnergia=0;
		this.dato=0;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	public int getPuntosTotales() {
		return puntos_Totales;
	}
	public void setPuntosTotales(int puntosTotales) {
		this.puntos_Totales = puntosTotales;
	}

	public boolean Controlar_no_pasar_limites_de_punto() {
		boolean rta;
		int suma=defensa+vida+energia+evasion;
		
		if (suma<=puntos_Totales && evasion<=EVASION_MAXIMOS && defensa<=EVASION_MAXIMOS) {
			rta=true;
		} else {
			rta=false;

		}
		return rta;
	}
	

	public int getUsoEnergia() {
		return usoEnergia;
	}

	public void setUsoEnergia(int usoEnergia) {
		this.usoEnergia = usoEnergia;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public boolean equals(String nombre){
		return  (nombre == this.getNombre());
	}
	
	public boolean equals(Object p){
		return ((p instanceof Propiedad_Persona) && ((Propiedad_Persona)p).getNombre().equals(this.getNombre()) );
	}
	
		
	public boolean evadeAtaque(){
	    boolean respuesta;
		double numAleatorio=Math.random();
		
		if ((numAleatorio*100)>this.getEvasion()) {
			respuesta=true;
		} else {
			respuesta=false;
		}
	    
	    return respuesta;
	}
	
	
	public int getEnergiaActual(){
		return energia-usoEnergia;
	}
	
	
	public int getVidaActual(){
		return vida-dato;
	}
	
	public void recibirAtaque(int puntosAtaque){
		if(!evadeAtaque()){
		dato=dato+puntosAtaque;
		}
	}
	
	
	public void atacar(int puntosAtaque){
		usoEnergia=usoEnergia+puntosAtaque;
	}
	
	
	public void aumentaPuntosTotales(){
		puntos_Totales=puntos_Totales+PUNTOS_X_PARTIDA_GANADA;
	}

}
