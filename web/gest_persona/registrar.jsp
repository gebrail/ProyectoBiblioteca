<%-- 
    Document   : registrar
    Created on : 10/05/2015, 08:23:06 PM
    Author     : Wilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registar Nueva Cuenta
        </title>
        <script src="../js/gest_cuentas.js"></script>
        <script type="text/javascript" src="../assets/js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="../assets/js/jquery-ui-1.9.2.custom.min.js"></script>
        <script type="text/javascript">
            
            
        </script>


        <%@include file="../jsp/head.html"%>
    </head>

    <body>


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
                            
                            <!-- /content-panel -->
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