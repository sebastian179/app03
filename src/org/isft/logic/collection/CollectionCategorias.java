package org.almacen.logic.collection;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

import org.almacen.domain.Categoria;
import org.almacen.logic.AccessManager;
import org.almacen.logic.AccessInterface;


public class CollectionCategorias extends AccessManager implements AccessInterface{

        public Vector select(HashMap parametros) throws Exception{
	        Categoria categoria = null;
	        String cod_categoria="";
	        Vector categorias = new Vector();
	        
	        String cadenaDeBusqueda="SELECT * from Categoria where id_categoria is not null";
	        if(parametros!=null && parametros.get("cod_categoria")!=null && !parametros.get("cod_categoria").equals("")){
	        	cadenaDeBusqueda+=" and id_categoria="+(String)parametros.get("cod_categoria");
	        }	         
		System.out.println("CADENA DE BUSQUEDA DE CATEGORIA : " + cadenaDeBusqueda);
	        try{
	            ResultSet rst = execute(cadenaDeBusqueda);
	            while(rst.next()){
	            	categoria=new Categoria();
								categoria.setCodCategoria(rst.getInt("id_categoria"));
	              categoria.setDescripcion(rst.getString("descripcion_categoria"));
	              categorias.add(categoria);
	            }            
	        }catch(Exception exc){
	            setError(exc.getMessage());
	            throw new Exception(exc.getMessage());
	        }finally{
	            try{
	                close_connection();
	            }
	            catch(Exception exc){
	                setError(exc.getMessage());
	                throw new Exception(exc.getMessage());
	            }
	        }
	        return categorias;
    	}
    
}

