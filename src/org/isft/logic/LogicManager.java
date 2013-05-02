package org.almacen.logic;

import java.sql.Connection;
import java.util.HashMap;
import org.almacen.jdbc.DataBase;

/**
 *
 * @author jcafferata
 */
public class LogicManager {
    String error="";
    protected Connection cn=null;
    protected DataBase db = null;

    public void create_connection(HashMap parameters) throws Exception{
        try{
            db=new DataBase(new HashMap());
            cn = db.getConnection();
        } catch(Exception exc){
            setError(exc.getMessage());
            throw new Exception(exc.getMessage());
        }
    }

    public void close_connection() throws Exception{
        try{
            if(db!=null){
                db.closeConection(cn);
            }
        }
        catch(Exception exc){
            setError(exc.getMessage());
        }
    }
     
    public String show_error(){
        String error_formated="";
        return "<table width=\"80%\"><tr><td>Error producido</td></tr><tr><td>"+error_formated+"</td></tr><tr><td><input type=\"button\" value=\"Volver\" onclick=\"window.history.back()\"></td></tr></table>";
    }
    
    public void setError(String error){
        this.error=error;
    }
    
}
