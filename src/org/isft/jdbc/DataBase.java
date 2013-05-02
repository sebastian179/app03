package org.almacen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataBase {
    private String usr;
    private String pwd;
    private String origen_datos;
    private Connection cn=null;
    
    public DataBase(HashMap parameters) throws Exception{
    	setUsr((String)(parameters.get("usr")==null?"":parameters.get("usr")));
    	setPwd((String)(parameters.get("pwd")==null?"":parameters.get("pwd")));
    	setOrigen_datos((String)(parameters.get("origen_datos")==null?"almacen_db":parameters.get("origen_datos")));    	
    	String motor=(String)(parameters.get("motor")==null?"access":parameters.get("motor"));
    	if(motor.equals("access")){
	    		try{
	    			access_connect();
	    		} catch(Exception exc){
	    			throw new Exception(exc.getMessage());
	    		}
    	} else if(motor.equals("mysql")){
	    		try{
	    			mysql_connect();
	    		} catch(Exception exc){
	    			throw new Exception(exc.getMessage());
	    		}
    	} else{
    		//TODO tratamiento de otros motores
    	}
    }
    
    public void access_connect() throws Exception{
       String url = "jdbc:odbc:"+getOrigen_datos();
       try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn = DriverManager.getConnection(url,getUsr(),getPwd());     
            System.out.println("Conexion establecida exitosamente a base de datos");
        }catch(SQLException e){ throw new Exception(e.getMessage()); }
         catch(Exception e){ throw new Exception(e.getMessage()); }      
    }
    
    public void mysql_connect() throws Exception{
    	try{
        //Cargar clase de controlador de base de datos
        Class.forName("com.mysql.jdbc.Driver");
        //Crear el objeto de conexion a la base de datos
        cn = DriverManager.getConnection("jdbc:mysql://localhost/"+getOrigen_datos()+"?user="+getUsr()+"&amp;password="+getPwd());
       }catch(SQLException e){ throw new Exception(e.getMessage());}
        catch(Exception e){ throw new Exception(e.getMessage()); }
    }
    
    public void closeConection(Connection cn) throws Exception{
        try{
           cn.close();
           System.out.println("Conexion cerrada con exito");
        }
        catch(Exception exc){
           throw new Exception(exc.getMessage());
        }
    }

		public Connection getConnection(){
			return this.cn;
		}
    /**
     * @return the usr
     */
    public String getUsr() {
        return usr;
    }

    /**
     * @param usr the usr to set
     */
    public void setUsr(String usr) {
        this.usr = usr;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the origen_datos
     */
    public String getOrigen_datos() {
        return origen_datos;
    }

    /**
     * @param origen_datos the origen_datos to set
     */
    public void setOrigen_datos(String origen_datos) {
        this.origen_datos = origen_datos;
    }
    
    
    
}
