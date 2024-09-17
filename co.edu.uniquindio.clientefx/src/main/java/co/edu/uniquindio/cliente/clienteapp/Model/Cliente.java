package co.edu.uniquindio.cliente.clienteapp.Model;

public class Cliente {

    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private String correo;
    private String celular;
    private String tipoCliente;

    public Cliente() {

    }
    public Cliente(int id, String nombre, String apellido, String cedula, int edad, String correo, String celular, String tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
        this.celular = celular;
        this.tipoCliente = tipoCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                '}';
    }
}
