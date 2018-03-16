/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enoloxianeodatismongo;

import java.util.List;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


public class Metodos {
  ODB odb; 
  
  public void conextar(){
      odb = ODBFactory.open("vinho");
      
  }
  
  public void cerrar(){
      
      odb.close();
     
  }
  
  public void mostrarDatos(){
      
      /*recogemos el analisis que tiene el tipo de uva  igual a L
        
        IQuery queryTipo = new CriteriaQuery(Analisis.class, Where.equal("tipouva", "l"));
        Objects<Analisis> analisis = odb.getObjects(queryTipo);
              */
        // display each object
       Objects<Analisis> analisis = odb.getObjects(Analisis.class);
        Analisis anl = null;
        while (analisis.hasNext()) {
            anl = analisis.next();
            System.out.println(anl.toString());
        }
  }
  
  public void updatear(){
      
      //De esta forma actualizamos todos los campos que tengan L en tipouva
      //updateamos cantidade en este caso

      
       IQuery queryTipo = new CriteriaQuery(Analisis.class, Where.equal("tipouva", "l"));
       Objects<Analisis> analisis = odb.getObjects(queryTipo);
       Analisis tipoL = null;
       while(analisis.hasNext()){
           //si quisiesemos un solo update prescidiriamos del next y hariamos esto :
          // tipoL = analisis.getFirst(); con esto recogemos solo un campo
        tipoL= analisis.next();
       tipoL.setCantidade(30);
       odb.store(tipoL);
       odb.commit();
       }
       
       
       
      
  }
  
  public void incrementarDatos(){
      
       IQuery queryTipo = new CriteriaQuery(Analisis.class, Where.equal("codigoa", "a4"));
       Objects<Analisis> analisis = odb.getObjects(queryTipo);
       
       Analisis tipos = null;
       
       
       while(analisis.hasNext()){
           
           tipos =  analisis.next();
            
           if(tipos.getTipouva().equals("a")){
               tipos.setAcidez(tipos.getAcidez()+1);
               odb.store(tipos);
               odb.commit();
           }
      
           
           
       }
      
      
  }
  
  
  
}
