<%-- 
    Document   : listarxroles
    Created on : 5/08/2015, 09:36:44 PM
    Author     : Wilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Listado De Cuentas por roles</title>
        <script src="../js/gest_cuentas.js"></script>
        <%@include file="../jsp/head.html"%>
    </head>

    <body onload="listadodecuentasxroles();">
        <%if (session.getAttribute("valido") == null) {
                response.sendRedirect("../index.jsp?error=Acceso Denegado");
            }
        %>


        <section id ="container">

            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="../jsp/Principal.jsp" class="logo"><b>Gestor Biblioteca</b></a>
                <!--logo end-->
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li><a class="logout" href="../jsp/cerrarsesion.jsp">Cerrar Sesion</a></li>
                    </ul>
                </div>
            </header>

            <!--header end-->

            <%@include file="../jsp/aside.html"%>  
            <!-- **********************************************************************************************************************************************************
                  MAIN CONTENT
                 *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                 
                    <div class="row mt">
                        <div class="col-lg-12">
                            <div class="content-panel">
                                <center>                                <h4><i class="fa fa-angle-right"></i> Listado De Cuentas</h4
                                    <div class="showback">
                                        
                                        <!-- Single button -->
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-theme dropdown-toggle" data-toggle="dropdown">
                                                Ver Por Orden <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="listar.jsp">Cedulas</a></li>
                                                <li><a href="listarxroles.jsp">Roles</a></li>
                                                <li><a href="listarxusername.jsp">Nombre</a></li>
                                            </ul>
                                        </div>
                                </center>
                                <section id="unseen">
                                    <table class="table table-bordered table-striped table-condensed">
                                        <thead>
                                            <tr>
                                                <th>
                                                    Username
                                                </th>
                                                <th>
                                                    ID De la Persona
                                                </th>
                                                <th>
                                                    Rol
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody id="listadodecuentasroles">
                                        </tbody>
                                    </table

                            </div>

                            </section>
                        </div><!-- /content-panel -->
                    </div><!-- /col-lg-4 -->			
                    </div><!-- /row -->
                    <!--main content end-->
                    <!--footer start-->
                    <footer class="site-footer">
                        <%@include file="../jsp/foonter.html" %>
                    </footer>
                    <!--footer end-->
                </section>

                <!-- js placed at the end of the document so the pages load faster -->
                <script src="../assets/js/jquery.js"></script>
                <script src="../assets/js/jquery-1.8.3.min.js"></script>
                <script src="../assets/js/bootstrap.min.js"></script>
                <script class="include" type="text/javascript" src="../assets/js/jquery.dcjqaccordion.2.7.js"></script>
                <script src="../assets/js/jquery.scrollTo.min.js"></script>
                <script src="../assets/js/jquery.nicescroll.js" type="text/javascript"></script>


                <!--common script for all pages-->
                <script src="../assets/js/common-scripts.js"></script>

                <!--script for this page-->
                <script type="text/javascript" src="../assets/js/gritter/js/jquery.gritter.js"></script>
                <script type="text/javascript" src="../assets/js/gritter-conf.js"></script>





                </body>

                </html>
