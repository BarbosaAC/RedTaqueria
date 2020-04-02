<%@page import="com.generationc20.redtaqueriaweb.model.Taqueria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Taquerits - Lista taquerias</title>
</head>
<body>
	<h2>Lista de taquerias</h2>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Popularidad</th>
				<th>Nivel de limpieza</th>
				<th>Ubicacion</th>
				<th>Olor</th>
				<th>Fecha de creacion</th>
			</tr>
		</thead>
				<!-- Ejecutar instucciones java  Scriplet -->
		
		<tbody>
			<%
			//Identificar, obtener, castear y almacenar
				List<Taqueria> taquerias = (List<Taqueria>) request.getAttribute("listaTaqueria");
			//Procesamiento
				for (Taqueria taqueria: taquerias) {
					out.write("<tr>");
					out.write("<td>" + taqueria.getId()+"</td>");
					out.write("<td>" + taqueria.getNombre()+"</td>");
					out.write("<td>" + taqueria.getPopularidad()+"</td>");
					out.write("<td>" + taqueria.getNivelLimpieza()+"</td>");
					out.write("<td>" + taqueria.getUbicacion()+"</td>");
					out.write("<td>" + taqueria.getOlor()+"</td>");
					out.write("<td>" + taqueria.getFechaCreacion()+"</td>");
					out.write("<tr>");
					
				}
			%>
		</tbody>
	</table>
	<a href="taquerias.html">Regresar</a>
</body>
</html>