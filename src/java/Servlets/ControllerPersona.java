/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.personarolDAO;
import VO.funcionalidadVO;
import VO.personarolVO;
import VO.personasVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wilson
 */
public class ControllerPersona extends HttpServlet {

    private personarolDAO personarolAO = new personarolDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        try {
            int opcion = 0;
            if (request.getParameter("opcion") != null) {
                opcion = Integer.parseInt(request.getParameter("opcion"));
            }
            switch (opcion) {
                case 0:
                    String username = request.getParameter("usuario");
                    String password = request.getParameter("password");
                    personarolVO personaO = validar(username, password);
                    if (personaO == null) {
                        response.sendRedirect("index.jsp?error=Usuario o contrasena incorrecta");
                    } else {
                        session.setAttribute("menu", menu(personaO));
                        session.setAttribute("personaxd", personaxd(personaO));
                        session.setAttribute("valido", true);
                        session.setAttribute("usuario", personaO); //Para obtener atrributos de la persona que este en sesion.
                        response.sendRedirect("jsp/Principal.jsp");
                    }
                    break;
                case 1:
                    out.println(listadodecuentas());
                    break;
                case 2:
                    out.println(listadodecuentasroles());
                    break;
                case 3:
                    out.println(listadodecuentasusername());
                    break;
            }
        } finally {
            out.close();
        }
    }

    private personarolVO validar(String nombre, String contrasena) throws SQLException {
        personarolVO persVO = personarolAO.validarPersona(nombre, contrasena);
        return persVO;
    }

    private String menu(personarolVO persVO) throws SQLException {
        LinkedList datos = new LinkedList();
        datos = personarolAO.menu(persVO);
        String menu = "";
        if (!datos.isEmpty()) {
            for (Object dato : datos) {
                funcionalidadVO funcVO = new funcionalidadVO();
                funcVO = (funcionalidadVO) dato;
                menu += " <li class=\"sub-menu dcjq-parent-li\"><a  href=\"../" + funcVO.getlink_funcionalidad() + "\"><i class=\"" + funcVO.geticono_funcionalidad() + "\"></i> " + "<span>" + funcVO.getnombre_funcionalidad() + "</span>" + "</a></li>\n";
            }

        } else {
            menu = "No tiene asignadas funcionalidades";
        }

        return menu;
    }

    private String personaxd(personarolVO persVO) throws SQLException, IOException {

        LinkedList datos = new LinkedList();
        datos = personarolAO.personaxd(persVO);

        String nombrexd = "";
        if (!datos.isEmpty()) {
            for (Object dato : datos) {
                personasVO personsVO = new personasVO();
                personsVO = (personasVO) dato;

                nombrexd += " <h5 class=\"centered\">" + personsVO.getPrimernombre_persona() + "  " + personsVO.getPrimerapellido_persona() + "</h5>";
            }

        } else {
            nombrexd = "pailas";
        }

        return nombrexd;
    }

    private String listadodecuentas() throws SQLException {
        LinkedList datos = new LinkedList();
        String listado = "";
        String x = "";
        datos = personarolAO.listarcuentas();
        if (!datos.isEmpty()) {
            personarolVO rolVO = new personarolVO();
            for (int i = 0; i < datos.size(); i++) {
                rolVO = (personarolVO) datos.get(i);
                if (rolVO.getid_rol() == 1) {
                    x = "Administrador";
                } else if (rolVO.getid_rol() == 2) {
                    x = "Bibliotecario";
                } else if (rolVO.getid_rol() == 3) {
                    x = "Docente";
                } else if (rolVO.getid_rol() == 4) {
                    x = "Estudiante";
                } else if (rolVO.getid_rol() == 5) {
                    x = "Persona Externa";
                }
                listado += "<tr>"
                        + "<td>" + rolVO.getusername() + "</td>"
                        + "<td>" + rolVO.getid_persona() + "</td>"
                        + "<td>" + x 
                      +"</td>"
                        + "</tr>";
            }
        } else {
            listado += "<tr>"
                    + "<td colspan=\"3\">" + "No se han encontrado registros." + "</td>"
                    + "</tr>";
        }
        return listado;
    }

    private String listadodecuentasroles() throws SQLException {
        LinkedList datos = new LinkedList();
        String listado = "";
        String x = "";
        datos = personarolAO.listarcuentasroles();
        if (!datos.isEmpty()) {
            personarolVO rolVO = new personarolVO();
            for (Object dato : datos) {
                rolVO = (personarolVO) dato;
                if (rolVO.getid_rol() == 1) {
                    x = "Administrador";
                } else if (rolVO.getid_rol() == 2) {
                    x = "Bibliotecario";
                } else if (rolVO.getid_rol() == 3) {
                    x = "Docente";
                } else if (rolVO.getid_rol() == 4) {
                    x = "Estudiante";
                } else if (rolVO.getid_rol() == 5) {
                    x = "Persona Externa";
                }
                listado += "<tr>"
                        + "<td>" + rolVO.getusername() + "</td>"
                        + "<td>" + rolVO.getid_persona() + "</td>"
                        + "<td>" + x + "</td>"
                        + "</tr>";
            }
        } else {
            listado += "<tr>"
                    + "<td colspan=\"3\">" + "No se han encontrado registros." + "</td>"
                    + "</tr>";
        }
        return listado;
    }

    private String listadodecuentasusername() throws SQLException {
        LinkedList datos = new LinkedList();
        String listado = "";
        String x = "";
        datos = personarolAO.listarcuentasnombre();
        if (!datos.isEmpty()) {
            personarolVO rolVO = new personarolVO();
            for (Object dato : datos) {
                rolVO = (personarolVO) dato;
                if (rolVO.getid_rol() == 1) {
                    x = "Administrador";
                } else if (rolVO.getid_rol() == 2) {
                    x = "Bibliotecario";
                } else if (rolVO.getid_rol() == 3) {
                    x = "Docente";
                } else if (rolVO.getid_rol() == 4) {
                    x = "Estudiante";
                } else if (rolVO.getid_rol() == 5) {
                    x = "Persona Externa";
                }
                listado += "<tr>"
                        + "<td>" + rolVO.getusername() + "</td>"
                        + "<td>" + rolVO.getid_persona() + "</td>"
                        + "<td>" + x + "</td>"
                        + "</tr>";
            }
        } else {
            listado += "<tr>"
                    + "<td colspan=\"3\">" + "No se han encontrado registros." + "</td>"
                    + "</tr>";
        }
        return listado;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
