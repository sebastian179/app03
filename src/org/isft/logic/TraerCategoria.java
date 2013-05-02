package org.almacen.logic;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import org.almacen.domain.Categoria;

public class TraerCategoria extends LogicManager{

    public Categoria getCategoria(HashMap parametros) throws Exception{
        Categoria categoria = null;
        int cod_categoria=0;
        if(parametros!=null){
        	cod_categoria=(Integer)parametros.get("cod_categoria");
        }
        String cadenaDeBusqueda="SELECT * from Categoria where id_categoria=" +cod_categoria;

        System.out.println("CADENA DE BUSQUEDA DE CATEGORIA : " + cadenaDeBusqueda);
        try{
            create_connection(new HashMap());
            if(cn != null)
                {
                Statement s = cn.createStatement();
                ResultSet rst = s.executeQuery(cadenaDeBusqueda);
                while(rst.next()){
                    categoria=new Categoria();
		    categoria.setCodCategoria(rst.getInt("id_categoria"));
                    categoria.setDescripcion(rst.getString("descripcion_categoria"));
                }
            }
        }
        catch(Exception exc){
            show_error();
        }
        finally{
            try{
                close_connection();
            } catch(Exception exc){
                show_error();
            }
        }
        return categoria;
    }

    
    
}

