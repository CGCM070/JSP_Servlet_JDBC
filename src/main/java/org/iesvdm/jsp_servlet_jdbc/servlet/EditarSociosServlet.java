package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAOImpl;

@WebServlet (name = "/EditarSociosServlet", value = "/EditarSociosServlet")
public class EditarSociosServlet extends HttpServlet {

    /***
     * Haremos el GET
     * del formulario de edición de socios y POST para actualizar los datos del socio
     *
     * Cuando se actualizan los datos en base de datos (POST) correctamente
     * habrá una carga del listado principial de pideNumeroSocio.jsp.
     *
     *  Cuando se produzca algún error de validación,
     *  se carga el formulario de edición informando del error.
     *
     *  El formulario de edición tendrás que crearlo. Para ello,
     *  inspírate en formularioSocio.jsp, pero, en este caso, llámalo formularioEditarSocio.jsp
     **/

    private SocioDAO socioDAO = new SocioDAOImpl();

    protected  void






}
