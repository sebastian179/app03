package org.almacen.logic.updater;

import java.util.HashMap;

/**
 *
 * @author jcafferata
 */
public class AbmCategoria extends UpdaterManager implements UpdaterInterface{

    @Override
    public void insert(HashMap parameters) throws Exception {
        try{
            String sql_insert="INSERT INTO Categoria (id_categoria, descripcion_categoria) values("+(String)parameters.get("id_categoria")+",'"+(String)parameters.get("descripcion_categoria")+"')";
            System.out.println("Cadena de insercion: " + sql_insert);
            execute(sql_insert);
        }
        catch(Exception exc){
            show_error();
        }       
    }

    @Override
    public void delete(HashMap parameters) throws Exception {
        try{
            String sql_insert="DELETE FROM Categoria WHERE id_categoria="+(String)parameters.get("id_categoria");
            execute(sql_insert);
        }
        catch(Exception exc){
            show_error();
        }        
    }

    @Override
    public void update(HashMap parameters) throws Exception {
        try{
            String sql_insert="UPDATE Categoria set descripcion_categoria='"+(String)parameters.get("descripcion_categoria")+" where id_categoria="+(String)parameters.get("id_categoria")+"'";
            execute(sql_insert);
        }
        catch(Exception exc){
            show_error();
        }       
    }

}
