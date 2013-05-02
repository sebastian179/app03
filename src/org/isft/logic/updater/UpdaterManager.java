package org.almacen.logic.updater;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import org.almacen.logic.LogicManager;

/**
 *
 * @author jcafferata
 */
public class UpdaterManager extends LogicManager{

    public void execute(String sql_statement) throws Exception{
        try{
            create_connection(new HashMap());
            Statement statementInsercion = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int resultado = statementInsercion.executeUpdate(sql_statement);            
        } catch(Exception exc){
            setError(exc.getMessage());
            throw new Exception(exc.getMessage());
        }
        finally{
            try{
                close_connection();
            }
            catch(Exception exc){
                setError(exc.getMessage());
                throw new Exception(exc.getMessage());
            }
        }   
    }    

}
