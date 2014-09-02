package Aterrizar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;



public class Conector {

	Connection conn;
	PreparedStatement ps;

	public Conector(){
		
		this.conn = null;
		this.ps = null;
		
	}
	
	public void insertar(String tabla, List<String> columnas, Object... valores) throws Exception
	{
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
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
			}
	
	}
	
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/Epers_Ej1","root","root");
	}
	
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
				nombre = rs.getString(condicion);
			}
			ps.close();
		}finally{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}
		return nombre ;
	}

	public void limpiarTabla() throws Exception {
		try {
			conn = this.getConnection();
		ps = conn.prepareStatement(" DELETE FROM Aterrizar");
		ps.execute();
	}finally{
		if(ps != null)
			ps.close();
		if(conn != null)
			conn.close();
	}
		
	}

	public void modificar(String tabla, String columna,String valorCol,String campo, String codigo) throws Exception {
		try{
		conn= this.getConnection();
		ps = conn.prepareStatement("UPDATE " + tabla +" SET"+ columna + " = " + valorCol+ "WHERE"+ campo+ "=" + codigo);
		ps.execute();
		ps.close();
	}finally{
		if(ps != null)
			ps.close();
		if(conn != null)
			conn.close();
	}

	}
}	

