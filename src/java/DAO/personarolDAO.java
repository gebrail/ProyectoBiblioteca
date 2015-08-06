/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conexionDB;
import VO.funcionalidadVO;
import VO.personarolVO;
import VO.personasVO;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Wilson
 */
public class personarolDAO {

    public personarolDAO() {
    }

    public personarolVO validarPersona(String username, String password) {
        conexionDB cn = null;
        PreparedStatement select = null;
        ResultSet rs = null;
        personarolVO loginVO = null;
        try {
            cn = new conexionDB();
            select = cn.getConnection().prepareStatement("SELECT * FROM personarol WHERE username=? AND password=?;");
            select.setString(1, username);
            select.setString(2, password);
            rs = select.executeQuery();
            if (rs.next()) {
                loginVO = new personarolVO();
                loginVO.setid_persona(rs.getInt("id_persona"));
                loginVO.setusername(rs.getString("username"));
                loginVO.setpassword(rs.getString("password"));

            }
            return loginVO;
        } catch (SQLException ex) {
            Logger.getLogger(personarolDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(select);
            cn.cerrarResultSet(rs);
        }
    }

    public LinkedList menu(personarolVO perVO) {
        conexionDB cn = null;
        PreparedStatement select = null;
        ResultSet rs = null;
        LinkedList datos = new LinkedList();
        try {
            cn = new conexionDB();
            select = cn.getConnection().prepareStatement("SELECT DISTINCT f.* FROM (funcionalidad AS f INNER JOIN(funcionalidaddelrol AS rf INNER JOIN personarol AS pr ON pr.id_rol = rf.id_rol)ON rf.id_funcionalidad = f.id_funcionalidad)WHERE pr.id_persona =?");
            select.setLong(1, perVO.getid_persona());
            rs = select.executeQuery();
            while (rs.next()) {
                funcionalidadVO funcVO = new funcionalidadVO();
                funcVO.setid_funcionalidad(rs.getInt("id_funcionalidad"));
                funcVO.setnombre_funcionalidad(rs.getString("nombre_funcionalidad"));
                funcVO.setdescripcion_funcionalidad(rs.getString("descripcion_funcionalidad"));
                funcVO.setlink_funcionalidad(rs.getString("link_funcionalidad"));
                funcVO.seticono_funcionalidad(rs.getString("icono_funcionalidad"));

                //JOptionPane.showMessageDialog(null,funcVO.getid_funcionalidad()+"\n"+ perVO.getid_persona()+"\n"+ funcVO.getlink_funcionalidad());
                datos.add(funcVO);
            }
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(personarolDAO.class.getName()).log(Level.SEVERE, null, ex);
            return datos;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(select);
            cn.cerrarResultSet(rs);
        }
    }

    public LinkedList personaxd(personarolVO perVO) throws IOException {
        conexionDB cn = null;
        PreparedStatement select = null;
        ResultSet rs = null;
        LinkedList datos = new LinkedList();
        try {
            cn = new conexionDB();
            select = cn.getConnection().prepareStatement("SELECT * FROM personas WHERE id_persona =? ");
            select.setLong(1, perVO.getid_persona());
            rs = select.executeQuery();
            while (rs.next()) {

                personasVO personaxdVO = new personasVO();
                personaxdVO.setId_persona(rs.getInt("id_persona"));
                personaxdVO.setId_documento(rs.getInt("id_documento"));
                personaxdVO.setPrimernombre_persona(rs.getString("primernombre_persona"));
                personaxdVO.setSegundonombre_persona(rs.getString("segundonombre_persona"));
                personaxdVO.setPrimerapellido_persona(rs.getString("primerapellido_persona"));
                personaxdVO.setSegundoapellido_persona(rs.getString("segundoapellido_persona"));
                // personaxdVO.setFoto_persona(ConvertirImagen(rs.getBytes("foto_persona")));
                // personaxdVO.setFoto_persona((Byte[]) rs.getObject("foto_persona"));
//                personaxdVO.setFoto_persona(rs.getByte("foto_persona"));
                personaxdVO.setFoto_persona(ConvertirImagen(rs.getBytes("foto_persona")));
                personaxdVO.setGenero_persona(rs.getString("genero_persona"));
                personaxdVO.setDireccion_persona(rs.getString("direccion_persona"));
                personaxdVO.setTelefono_persona(rs.getInt("telefono_persona"));
                personaxdVO.setCorreo_persona(rs.getString("correo_persona"));
                personaxdVO.setEstadocivil_persona(rs.getString("estadocivil_persona"));
                personaxdVO.setFechanacimiento_persona(rs.getDate("fechanacimiento_persona"));
                datos.add(personaxdVO);
            }
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(personarolDAO.class.getName()).log(Level.SEVERE, null, ex);
            return datos;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(select);
            cn.cerrarResultSet(rs);
        }
    }

    private Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }

    public LinkedList listarcuentas() {
        conexionDB cn = null;
        PreparedStatement select = null;
        ResultSet rs = null;
        LinkedList datos = new LinkedList();
        try {
            cn = new conexionDB();
            select = cn.getConnection().prepareCall("SELECT * FROM personarol ORDER BY id_persona ASC;");
            rs = select.executeQuery();
            while (rs.next()) {
                personarolVO rolVO = new personarolVO();
                rolVO.setid_persona(rs.getLong("id_persona"));
                rolVO.setusername(rs.getString("username"));
                rolVO.setpassword(rs.getString("password"));
                rolVO.setid_rol(rs.getInt("id_rol"));
                datos.add(rolVO);
            }
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(personarolDAO.class.getName()).log(Level.SEVERE, null, ex);
            return datos;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(select);
            cn.cerrarResultSet(rs);
        }
    }

    public LinkedList listarcuentasroles() {
        conexionDB cn = null;
        PreparedStatement select = null;
        ResultSet rs = null;
        LinkedList datos = new LinkedList();
        try {
            cn = new conexionDB();
            select = cn.getConnection().prepareCall("SELECT * FROM personarol ORDER BY id_rol ASC;");
            rs = select.executeQuery();
            while (rs.next()) {
                personarolVO rolVO = new personarolVO();
                rolVO.setid_persona(rs.getLong("id_persona"));
                rolVO.setusername(rs.getString("username"));
                rolVO.setpassword(rs.getString("password"));
                rolVO.setid_rol(rs.getInt("id_rol"));
                datos.add(rolVO);
            }
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(personarolDAO.class.getName()).log(Level.SEVERE, null, ex);
            return datos;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(select);
            cn.cerrarResultSet(rs);
        }
    }

    public LinkedList listarcuentasnombre() {
        conexionDB cn = null;
        PreparedStatement select = null;
        ResultSet rs = null;
        LinkedList datos = new LinkedList();
        try {
            cn = new conexionDB();
            select = cn.getConnection().prepareCall("SELECT * FROM personarol ORDER BY username ASC;");
            rs = select.executeQuery();
            while (rs.next()) {
                personarolVO rolVO = new personarolVO();
                rolVO.setid_persona(rs.getLong("id_persona"));
                rolVO.setusername(rs.getString("username"));
                rolVO.setpassword(rs.getString("password"));
                rolVO.setid_rol(rs.getInt("id_rol"));
                datos.add(rolVO);
            }
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(personarolDAO.class.getName()).log(Level.SEVERE, null, ex);
            return datos;
        } finally {
            cn.desconectar();
            cn.cerrarStatement(select);
            cn.cerrarResultSet(rs);
        }
    }
}
