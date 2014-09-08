package Aterrizar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class Conector {

	Connection conn;
	PreparedStatement ps;
	
	/*
	 * La clase conector la usamos como template para hacer
	 * consultas del estilo CRUD como ademas brindar opciones
	 * para limpiar la tabla y cerrar la conexion.
	 * Seria una implementacion de un DAO.
	 */

	public Conector(){
		
		this.conn = null;
		this.ps = null;
		
	}
	/**
	 * 
	 * @param tabla es la tabla a la cual le quiero hacer inserciones
	 * @param columnas son las columnas de la tabla en cuestion a las cuales le 
	 * quiero agregar los valores en cuestion
	 * @param valores son los valores que deseo ingresar en la tabla
	 * @throws Exception
	 */
	public void insertar(String tabla, List<String> columnas, Object... valores) throws Exception{
		
		try{
			StringBuffer stringBuffer = new StringBuffer(tabla + " ( ");
					
				for (String columna : columnas){
					stringBuffer.append(columna);
					stringBuffer.append(" , ");
				}
				stringBuffer.replace(stringBuffer.length()-2, stringBuffer.length(), " ");
				stringBuffer.append(") VALUES ( ");	
				
				for (Object valor : valores) {
					
				stringBuffer.append("'" +valor 
						+ "'");
				stringBuffer.append(", ");
			}
			stringBuffer.replace(stringBuffer.length()-2, stringBuffer.length(), "");
			stringBuffer.append(")");
			
			conn = this.getConnection();
			ps = conn.prepareStatement("INSERT INTO " + stringBuffer.toString());
			ps.execute();
			ps.close();
			
		}finally{
			cerrarConexion();
			}
	}

	/**
	 * 
	 * @param campos son los campos de interes que quiero seleccionar de una tabla, 
	 * @param tabla es la tabla en cuestion
	 * @param condicion es el criterio bajo el cual quiero hacer la seleccion de campos
	 * @param valorBuscado aporta para la busqueda bajo la condicion requerida
	 * @return los campos de la tabla los cuales cumplen con el valor buscado
	 * bajo la condicion requerida
	 * @throws Exception
	 */
	public String seleccionar(List<String> campos, String tabla, String condicion, String valorBuscado) throws Exception{
		
		String nombre = "";
		try{
			StringBuffer stringBuffer = new StringBuffer("(");
			
			for(String campo : campos){
				stringBuffer.append(campo);
				stringBuffer.append(" , ");
			}
			stringBuffer.replace(stringBuffer.length()-2, stringBuffer.length(), ")");
			
			stringBuffer.append(" FROM " + tabla + " WHERE ");
			stringBuffer.append(condicion + " = '"+ valorBuscado +"'");
			conn = this.getConnection();
			ps = conn.prepareStatement("SELECT " + stringBuffer.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				nombre = rs.getString(1);
			}
			ps.close();
		}finally{
			cerrarConexion();
			}
		return nombre ;
	}

	/**
	 * La usamos para poder borrar todos los datos de una tabla
	 * @throws Exception
	 */
	public void limpiarTabla() throws Exception {
		try {
			conn = this.getConnection();
		ps = conn.prepareStatement(" DELETE FROM Aterrizar");
		ps.execute();
		}finally{
			cerrarConexion();
			}
		}
	/**
	 * @param tabla es la tabla a la cual le quiero hacer modificaciones
	 * @param columnas son las columnas de la tabla en cuestion a las cuales le 
	 * quiero agregar los valores en cuestion
	 * @param valorCol son los valores que deseo ingresar en la tabla
	 * @param campo bajo el cual se aplica la modificacion
	 * @param codigo que debe ser igual a nivel instancia al campo
	 * @throws Exception
	 */
	public void modificar(String tabla, String columna,String valorCol,String campo, String codigo) throws Exception {
		try{
		conn= this.getConnection();
		ps = conn.prepareStatement("UPDATE " + tabla +" SET "+ columna + " = " + valorCol + " WHERE "+ campo + " = '" + codigo +"'");
		ps.execute();
		ps.close();
		}finally{
			cerrarConexion();
			}
	}
	
	private void cerrarConexion() throws SQLException {
		if(ps != null)
			ps.close();
		if(conn != null)
			conn.close();
	}
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/Epers_Ej1","root","root");
	}
}	


