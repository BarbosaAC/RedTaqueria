package com.generationc20.redtaqueriaweb.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.generationc20.redtaqueriaweb.model.Taqueria;

public class DatabaseManager {
	
	private Connection connection;
	
	public DatabaseManager (Connection conn) {
		this.connection = conn;
	}
	
	public void insertarTaqueria(Taqueria taqueria) {
		
		String queryInsert= "insert into taqueria"
				+ "(nombre, popularidad, nivelLimpieza, ubicacion, olor)"
				+ "values(?,?,?,?,?)";
		PreparedStatement chalan = null;
		int result =-1;
		
		try {
		
			chalan = connection.prepareStatement(queryInsert);
			chalan.setString(1, taqueria.getNombre());
			chalan.setInt(2, taqueria.getPopularidad());
			chalan.setInt(3, taqueria.getNivelLimpieza());
			chalan.setString(4, taqueria.getUbicacion());
			chalan.setInt(5, taqueria.getOlor());
			result = chalan.executeUpdate();
			
			if(result>0) {
				System.out.println("Se inserto");
			}else {
				System.out.println("No se inserto");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(chalan !=null) {
				try {
					chalan.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public List<Taqueria> consultarTaquerias(){
		
		String query = "SELECT * FROM taqueria;";
		Statement chalan = null;
		ResultSet cajaResultados = null;
		List<Taqueria> listaTaqueria = null;
		try {
			chalan = connection.createStatement();
			cajaResultados = chalan.executeQuery(query);
			listaTaqueria = new ArrayList<>();
			while(cajaResultados.next()){
				//Identificar, obtener, castear, almacenar
				Taqueria taqueria = new Taqueria();
				//Moldear y modelar datos
				taqueria.setId(cajaResultados.getInt("id"));
				taqueria.setNombre(cajaResultados.getString("nombre"));
				taqueria.setPopularidad(cajaResultados.getInt("popularidad"));
				taqueria.setNivelLimpieza(cajaResultados.getInt("nivelLimpieza"));
				taqueria.setUbicacion(cajaResultados.getString("ubicacion"));
				taqueria.setOlor(cajaResultados.getInt("olor"));
				taqueria.setFechaCreacion(cajaResultados.getDate("fechaCreacion"));
				listaTaqueria.add(taqueria);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(chalan !=null) {
				try {
					cajaResultados.close();
					chalan.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listaTaqueria;
		
	}
	
}
