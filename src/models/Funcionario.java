package models;
import java.sql.Date;

/**
 *
 * @author YOBANY
 */
public class Funcionario {
    
    private int id;
    private String numId;
    private String nombres;
    private String apellidos;
    private String sexo;
    private String direccion; 
    private String telefono;
    private Date fechaNacimiento;
    private int tipoDocumento;
    private int estadoCivil;

    public Funcionario() {
        
    }

    public Funcionario(String numId, String nombres, String apellidos, String sexo, String direccion, String telefono, Date fechaNacimiento) {
        this.numId = numId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Funcionario(String nombres, String apellidos, String sexo, String direccion, String telefono, Date fechaNacimiento, int tipoDocumento, int estadoCivil) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.estadoCivil = estadoCivil;
    }
    
    public Funcionario(String numId, String nombres, String apellidos, String sexo, String direccion, String telefono, Date fechaNacimiento, int tipoDocumento, int estadoCivil) {
        this.numId = numId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.estadoCivil = estadoCivil;
    }

    public Funcionario(int id, String numId, String nombres, String apellidos, String sexo, String direccion, String telefono, Date fechaNacimiento, int tipoDocumento, int estadoCivil) {
        this.id = id;
        this.numId = numId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.estadoCivil = estadoCivil;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }   
}
