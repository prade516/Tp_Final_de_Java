package data;

import java.sql.*;
import entidades.*;
import utils.ApplicationException;

public class Data_Personas {


	public void Save(Propiedad_Persona p){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=Factory_Conexion.getInstancia().getConn().prepareStatement(
					"insert into jugadormatias(nombre,vida,energia,evasion,defensa)"+
					" values(?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			// PreparedStatement.RETURN_GENERATED_KEYS to be able to retrieve id generated on the db
			// by the autoincrement column. Otherwise don't use it
						
			stmt.setString(1,p.getNombre());
			stmt.setInt(2,p.getVida());
			stmt.setInt(3,p.getEnergia());
			stmt.setInt(4,p.getEvasion());
			stmt.setInt(5,p.getDefensa());
			stmt.execute();
			
			//after executing the insert use the following lines to retrieve the id
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setCodigo(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				Factory_Conexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
	public void update(Propiedad_Persona p){
		PreparedStatement stmt=null;
		
		try {
			stmt= Factory_Conexion.getInstancia().getConn().prepareStatement(
					"update jugadormatias set vida=?,energia=?,evasion=?,defensa=?,puntosTotales=?"+
					" where nombre=?");

			stmt.setInt(1,p.getVida());
			stmt.setInt(2,p.getEnergia());
			stmt.setInt(3,p.getEvasion());
			stmt.setInt(4,p.getDefensa());
			stmt.setInt(5,p.getPuntosTotales());
			stmt.setString(6,p.getNombre());


            stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				Factory_Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	public void delete(Propiedad_Persona p){
		PreparedStatement stmt=null;
		
		try {
			stmt = Factory_Conexion.getInstancia().getConn().prepareStatement(
					"delete from jugadormatias where nombre=?");
			stmt.setString(1, p.getNombre());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				Factory_Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}

	public Propiedad_Persona getByNombre(Propiedad_Persona per){
		Propiedad_Persona Persona=null;
		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = Factory_Conexion.getInstancia().getConn().prepareStatement(
					"select codigo,nombre,vida,energia,evasion,defensa,puntos_totales from jugadormatias where nombre=?");
			stmt.setString(1, per.getNombre());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				Persona=new Propiedad_Persona();
				Persona.setCodigo(rs.getInt("codigo"));
				Persona.setVida(rs.getInt("vida"));
				Persona.setNombre(rs.getString("nombre"));
				Persona.setDefensa(rs.getInt("defensa"));
				Persona.setEvasion(rs.getInt("evasion"));
				Persona.setPuntosTotales(rs.getInt("puntos_totales"));
				Persona.setEnergia(rs.getInt("energia"));
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				Factory_Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return Persona;
	}

	
	
}
