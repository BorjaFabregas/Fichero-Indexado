
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Fiche extends ManejoFichero{
    
    
    
    public void modificarEmple(Empleado emple){
        String dni = emple.getDni();
        
    }
    
    public void lecturadni(){ // este tendra que recorrerlo segun la clave dni en el tree map
        File fichero=new File(nombrefichero +".dat");
         Empleado emple;
       try{ 
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream datoIs = new ObjectInputStream(filein);
            //aqui hace falta una repetitiva o similar para sacar todos los emples(no se muy bien como se lee con esto la verdad)
                 emple = (Empleado) datoIs.readObject();
                 System.out.println(emple.toString());
                 
            datoIs.close();
       }catch(ClassNotFoundException cnf){
           System.out.println("clase no encontrada");
       }catch(IOException ex){
           System.out.println(" excepcion general");
       }
    }
    
    public void lecturaordenada(){// este tiene que recorrer por orden de introduccion es decir tal como se ha ido guardando em el fichero 
        File fichero=new File(nombrefichero +".dat");
         Empleado emple;
       try{ 
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream datoIs = new ObjectInputStream(filein);
            //aqui hace falta una repetitiva o similar para sacar todos los emples(no se muy bien como se lee con esto la verdad)
                 emple = (Empleado) datoIs.readObject();
                 System.out.println("nombre y apellidos: " + emple.getNombreYApellidos());
                 System.out.println("sexo: " + emple.getSexo());
                 System.out.println("salario: "+ emple.getSalario());
                 System.out.println("anio ingreso: "+ emple.getAnioingreso());
                 System.out.println("mes ingreso: " + emple.getMesingreso());
                 System.out.println("dia ingreso: "+ emple.getDiaingreso());
                 System.out.println("tipo de empleado: "+ emple.getTipoemple());
                 System.out.println("provincia: "+ emple.getProvincia());
                 
            datoIs.close();
       }catch(ClassNotFoundException cnf){
           System.out.println("clase no encontrada");
       }catch(IOException ex){
           System.out.println(" excepcion general");
       }
    }
    
    public void buscaremple(String dni){
        
    }
    
    public void crearfichero(String nombrefichero){
        this.nombrefichero=nombrefichero;
        File fichero=new File(nombrefichero +".dat");
    }
}
