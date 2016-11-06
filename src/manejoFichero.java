
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
abstract class manejoFichero {

    String nombrefichero;
    File fichero;
    TreeMap mapa;

    public manejoFichero() {
        // this.nombrefichero = nombrefiche;

    }

    public void alta(Empleado emple) {

        fichero = new File(nombrefichero + ".dat");
        try {
            FileOutputStream fileout = new FileOutputStream(fichero);
            ObjectOutputStream datoOS = new ObjectOutputStream(fileout);
            datoOS.writeObject(emple);
            datoOS.close();
        } catch (FileNotFoundException e) {
            System.out.println(" no lo ha encontrado");
        } catch (IOException es) {
            System.out.println(" excepcion IOException");
        }
    }

    public void baja(String dni) {
        //cpm este if comprobamos si esta o no en el treemap
        if (mapa.containsKey(mapa.ceilingKey(dni))) {
            System.out.println("el archivo existe y vamos a proceder a darlo de baja");
            mapa.remove(dni);
        } else {
            System.out.println("lo siento no podemos dar de baja ese dni puesto que no existe en el fichero");
        }

    }

    public void modificacion(int salario, String dni) {
        if(mapa.containsKey(dni)){
            Empleado e = (Empleado) mapa.ceilingKey(dni);
            e.setSalario(salario);
            mapa.replace(dni, e);
            System.out.println("Registro con DNI: " + dni + " Actualizado");
        }else{
            System.out.println("El Registro no existe");
        }
    }

    public void lectura(String dni) {
        Empleado e = (Empleado) mapa.ceilingKey(dni);
        System.out.println(e.toString());
    }

    public void abrirfichero() {
        fichero = new File(this.nombrefichero + ".dat");
        try {

            DataOutputStream fic = new DataOutputStream(new FileOutputStream(fichero));

        } catch (FileNotFoundException e) {
            System.out.println("no se ha encontrado el fichero");
        }
    }

    public void cerrarfichero() {

    }

    public void crearTreeMap() {

        mapa = new TreeMap();

    }

    public void insertarEnTreeMap(Empleado emple, String dni) {

        if (mapa.containsKey(dni)) {
            System.out.println("No se puede insertar esta clave en el mapa porque ya existe");
        } else {
            mapa.put(dni, emple);
        }

    }

}
/*//todo esto debe ir en el insertaren tree map
        //esto devuelve true si en el mapa ya hay una clave con ese valor para poder denegar la opcion a insertar en mapa
        if (mapa.containsKey(mapa)) {//eto hay que cambiarlo por la clave que se guarda en el mapa
            System.out.println("no se puede insertar esta clave en el mapa pk ya existe");
        } else {
            mapa.put(mapa, mapa);//esto debe de ser  un k clave,String dni
        }*/
