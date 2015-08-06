package VO;

import java.awt.Image;
import java.sql.Date;

public class personasVO {

    public long getId_persona() {
        return id_persona;
    }

    public void setId_persona(long id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getPrimernombre_persona() {
        return primernombre_persona;
    }

    public void setPrimernombre_persona(String primernombre_persona) {
        this.primernombre_persona = primernombre_persona;
    }

    public String getSegundonombre_persona() {
        return segundonombre_persona;
    }

    public void setSegundonombre_persona(String segundonombre_persona) {
        this.segundonombre_persona = segundonombre_persona;
    }

    public String getPrimerapellido_persona() {
        return primerapellido_persona;
    }

    public void setPrimerapellido_persona(String primerapellido_persona) {
        this.primerapellido_persona = primerapellido_persona;
    }

    public String getSegundoapellido_persona() {
        return segundoapellido_persona;
    }

    public void setSegundoapellido_persona(String segundoapellido_persona) {
        this.segundoapellido_persona = segundoapellido_persona;
    }

    public Image getFoto_persona() {
        return foto_persona;
    }

    public void setFoto_persona(Image foto_persona) {
        this.foto_persona = foto_persona;
    }

    public String getGenero_persona() {
        return genero_persona;
    }

    public void setGenero_persona(String genero_persona) {
        this.genero_persona = genero_persona;
    }

    public String getDireccion_persona() {
        return direccion_persona;
    }

    public void setDireccion_persona(String direccion_persona) {
        this.direccion_persona = direccion_persona;
    }

    public int getTelefono_persona() {
        return telefono_persona;
    }

    public void setTelefono_persona(int telefono_persona) {
        this.telefono_persona = telefono_persona;
    }

    public String getCorreo_persona() {
        return correo_persona;
    }

    public void setCorreo_persona(String correo_persona) {
        this.correo_persona = correo_persona;
    }

    public String getEstadocivil_persona() {
        return estadocivil_persona;
    }

    public void setEstadocivil_persona(String estadocivil_persona) {
        this.estadocivil_persona = estadocivil_persona;
    }

    public Date getFechanacimiento_persona() {
        return fechanacimiento_persona;
    }

    public void setFechanacimiento_persona(Date fechanacimiento_persona) {
        this.fechanacimiento_persona = fechanacimiento_persona;
    }

    private long id_persona;
    private int id_documento;
    private String primernombre_persona;
    private String segundonombre_persona;
    private String primerapellido_persona;
    private String segundoapellido_persona;
    private Image foto_persona;
    private String genero_persona;
    private String direccion_persona;
    private int telefono_persona;
    private String correo_persona;
    private String estadocivil_persona;
    private Date fechanacimiento_persona;

}
