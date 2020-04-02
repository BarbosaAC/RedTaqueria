package com.generationc20.redtaqueriaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import com.generationc20.redtaqueriaweb.db.DatabaseConnection;
import com.generationc20.redtaqueriaweb.db.DatabaseManager;
import com.generationc20.redtaqueriaweb.model.Taqueria;

@WebServlet(name = "TaqueriaServlet", urlPatterns ="/taqueria")
public class TaqueriaServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		Connection puenteConnection = null;
		DatabaseManager dbManager = null;
		List<Taqueria> listaTaqueria = null;
		RequestDispatcher dispatcher = null;
		
		//Delegacion de la vista(jsp) or otro servlet
		puenteConnection = DatabaseConnection.getConnection();
		dbManager = new DatabaseManager(puenteConnection);
		listaTaqueria = dbManager.consultarTaquerias();
		DatabaseConnection.closeConnection(puenteConnection);
		
		
		//Cargar una vista
		dispatcher = req.getRequestDispatcher("listTaqueria.jsp");
		//Establecer datos para la vista
		req.setAttribute("listaTaqueria", listaTaqueria);
		//Cargar la vista con lo datos
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Taqueria taqueria = null;
		Connection puenteConn = null;
		DatabaseManager chalanDB = null;
		
		
		//Obtencion de datos
		String nombre = req.getParameter("txtNombre");
		int popularidad = Integer.parseInt(req.getParameter("txtPopularidad"));
		int nivelLimpieza = Integer.parseInt(req.getParameter("txtNivelLimpieza"));
		String ubicacion = req.getParameter("txtUbicacion");
		int olor = Integer.parseInt(req.getParameter("txtOlor"));
		
		//Moldear datos - pojo
		taqueria = new Taqueria();
		
		taqueria.setNombre(nombre);
		taqueria.setPopularidad(popularidad);
		taqueria.setUbicacion(ubicacion);
		taqueria.setNivelLimpieza(nivelLimpieza);
		taqueria.setOlor(olor);
		
		//Procesar los datos - almacenarlos en la base de datos
		puenteConn = DatabaseConnection.getConnection();
		chalanDB = new DatabaseManager(puenteConn);
		
		chalanDB.insertarTaqueria(taqueria);
		DatabaseConnection.closeConnection(puenteConn);
		
		//Configurar respuesta
		resp.setContentType("text/html");
		resp.setStatus(HttpServletResponse.SC_CREATED);
		PrintWriter salida = resp.getWriter();
		salida.write("<!DOCTYPE html>");
		salida.write("<html>");
		salida.write("<head>");
		salida.write("<title>Resultado</title>");
		salida.write("</head>");
		salida.write("<body>");
		salida.write("<h1>Se creo con exito</h1>");
		salida.write("<a href=\"formTaqueria.html\">Regresar</a>");
		salida.write("</body>");
		salida.write("</html>");
		}
}
