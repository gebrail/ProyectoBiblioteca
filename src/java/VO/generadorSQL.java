/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Conexion.conexionDB;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Freddy Jaimes
 */
public class generadorSQL {

    public static void main(String args[]) throws SQLException, IOException {
        generar();
    }
    /*
     * Permite tomar la DataBase y construir de forma automatica los Values Object.
     */

    public static void generar() throws SQLException, IOException {
        conexionDB cn = new conexionDB();
        Statement stm = cn.getConnection().createStatement();
        String consultarTablas = "SELECT tablename FROM pg_tables WHERE schemaname = 'public'";
        ResultSet rs = stm.executeQuery(consultarTablas);
        while (rs.next()) {
            String tabla = rs.getString("tablename");
            File clase = new File("C:\\Users\\Wilson\\Documents\\NetBeansProjects\\Biblioteca2\\src\\java\\VO", tabla + "VO" + ".java");
            FileWriter escribirClase = new FileWriter(clase);

            String importaciones = "";
            String clasetxt = "\n\npublic class " + tabla + "VO" + " {\n \n";
            String atributos = "";
            String metodos = "";

            String consultarTabla = "SELECT * FROM " + tabla;
            stm = cn.getConnection().createStatement();
            ResultSet rs1 = stm.executeQuery(consultarTabla);

            ResultSetMetaData rm = rs1.getMetaData();
            for (int i = 1; i <= rm.getColumnCount(); i++) {
                String nombreCampo = rm.getColumnName(i);
                String tipoCampo = "";
                if (rm.getColumnTypeName(i).equals("text") || rm.getColumnTypeName(i).equals("varchar")) {
                    tipoCampo = "String";
                } else if (rm.getColumnTypeName(i).equals("date")) {
                    tipoCampo = "Date";
                    if (importaciones.indexOf("sql.Date") == -1) {
                        importaciones = importaciones + "import java.sql.Date;\n";
                    }
                } else if (rm.getColumnTypeName(i).equals("time")) {
                    tipoCampo = "Time";
                    if (importaciones.indexOf("sql.Time") == -1) {
                        importaciones = importaciones + "import java.sql.Time;\n";
                    }
                } else if (rm.getColumnTypeName(i).equals("integer") || rm.getColumnTypeName(i).equals("serial") || rm.getColumnTypeName(i).equals("int4")|| rm.getColumnTypeName(i).equals("numeric")) {
                    tipoCampo = "int";
                } else if (rm.getColumnTypeName(i).equals("bool")) {
                    tipoCampo = "boolean";
                }

                atributos = atributos + "\tprivate " + tipoCampo + " " + nombreCampo + ";\n";

                metodos = metodos + "\tpublic " + tipoCampo + " get" + nombreCampo + "() {\n"
                        + "\t\treturn this." + nombreCampo + ";\n\t}\n\n";

                metodos = metodos + "\tpublic void set" + nombreCampo + "(" + tipoCampo + " " + nombreCampo + ") {\n"
                        + "\t\tthis." + nombreCampo + "=" + nombreCampo + ";\n\t}\n\n";
            }
            clasetxt = "package VO;" + importaciones + clasetxt + atributos + "\n" + metodos + "}";
            escribirClase.write(clasetxt);
            escribirClase.close();
        }
    }
}