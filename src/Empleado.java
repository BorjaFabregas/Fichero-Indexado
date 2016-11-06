
import java.io.Serializable;

/**
 *
 * @author Mateo Salmeron
 */
public class Empleado implements Serializable {

    String dni;
    String nombreYApellidos;
    float salario;
    int anioingreso;
    short mesingreso;
    short diaingreso;
    char tipoemple;
    byte provincia;
    char sexo;

    public Empleado(String nombreYApellidos, char sexo, float salario, int anioingreso, short mesingreso, short diaingreso, char tipoemple, byte provincia) {
        //this.dni = dni;  HAY QUE DECIDIR SI METER O NO EL DNI AQUI...
        this.nombreYApellidos = nombreYApellidos;
        this.salario = salario;
        this.anioingreso = anioingreso;
        this.mesingreso = mesingreso;
        this.diaingreso = diaingreso;
        this.tipoemple = tipoemple;
        this.provincia = provincia;
        this.sexo = sexo;

    }

    @Override
    public String toString() {
        String hombreMujer = "Mujer";
        if (sexo == 'H') {
            hombreMujer = "Hombre";
        }
        String prov = null;
        switch (provincia) {
            case 1:
                prov = "Almeria";
                break;
            case 2:
                prov = "Cádiz";
                break;
            case 3:
                prov = "Cordoba";
                break;
            case 4:
                prov = "Granada";
                break;
            case 5:
                prov = "Huelva";
                break;
            case 6:
                prov = "Jaen";
                break;
            case 7:
                prov = "Malaga";
                break;
            case 8:
                prov = "Sevilla";
        }
        String tipoEmpleado = null;
        switch (tipoemple) {
            case 'C':
                tipoEmpleado = "A Comision";
                break;
            case 'F':
                tipoEmpleado = "Fijo";
                break;
            case 'D':
                tipoEmpleado = "A Domicilio";
        }
        return "\nNombre y Apellidos: " + nombreYApellidos
                + "\nDNI: " + dni
                + "\n" + hombreMujer
                + "\nSalario: " + salario + "€"
                + "\nFecha Ingreso: " + diaingreso + "/" + mesingreso + "/" + anioingreso
                + "\nTipo de Empleado: " + tipoEmpleado
                + "\nProvincia: " + prov + "\n";
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombreYApellidos(String nombreYApellidos) {
        this.nombreYApellidos = nombreYApellidos;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setAnioingreso(int anioingreso) {
        this.anioingreso = anioingreso;
    }

    public void setMesingreso(short mesingreso) {
        this.mesingreso = mesingreso;
    }

    public void setDiaingreso(short diaingreso) {
        this.diaingreso = diaingreso;
    }

    public void setTipoemple(char tipoemple) {
        this.tipoemple = tipoemple;
    }

    public void setProvincia(byte provincia) {
        this.provincia = provincia;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombreYApellidos() {
        return nombreYApellidos;
    }

    public float getSalario() {
        return salario;
    }

    public int getAnioingreso() {
        return anioingreso;
    }

    public short getMesingreso() {
        return mesingreso;
    }

    public short getDiaingreso() {
        return diaingreso;
    }

    public char getTipoemple() {
        return tipoemple;
    }

    public byte getProvincia() {
        return provincia;
    }

    public char getSexo() {
        return sexo;
    }

}
