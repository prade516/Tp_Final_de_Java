package negocio;

import data.Data_Personas;
import entidades.Propiedad_Persona;

public class Metodo_Personas {	
	private data.Data_Personas Data_per;
	
	public Metodo_Personas(){
		Data_per=new Data_Personas();
	}
	
	public void Save(Propiedad_Persona persona) {
		Data_per.Save(persona);	
	}

	public void update(Propiedad_Persona persona){
		Data_per.update(persona);
	}
	
	public Propiedad_Persona getByNombre(Propiedad_Persona persona){
		Propiedad_Persona Personas = new Propiedad_Persona();
		Personas=Data_per.getByNombre(persona);
		return Personas;
	}
	
	public void delete(Propiedad_Persona persona){
		Data_per.delete(persona);
	}
}
