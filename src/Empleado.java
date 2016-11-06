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
