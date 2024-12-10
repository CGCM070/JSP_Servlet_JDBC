package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.model.Socio;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "BorrarSocioServlet", value = "/BorrarSocioServlet")
public class BorrarSocioServlet extends HttpServlet {


    //Instanciamos el DAO para acceder a la tabla socio y con ello a la BBDD y poder borrar un socio
    private SocioDAO socioDAO = new SocioDAOImpl();


    //Método para borrar un socio lo haremos por POST
    //Para la ruta POST /BorrarSocioServlet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Creamos un objeto RequestDispatcher para  luego redirigir a la página de listado de socios
        RequestDispatcher dispatcher = null;


        //Recogemos el id del socio a borrar
        int id = Integer.parseInt(request.getParameter("codigo"));

        //el find de la interfaz SocioDAO nos devuelve un Optional de Socio
        //Si el socio existe lo borramos y sino damos un mensaje de error

        Optional<Socio> socioOptional = this.socioDAO.find(id);

        if( socioOptional.isPresent() ) {

            Socio socio = socioOptional.get(); //Obtenemos el socio del Optional porque sabemos que está presente
            this.socioDAO.delete(socio.getSocioId()); //Borramos el socio


            //Redirigimos a la página de listado de socios pero antes actualizamos la lista de socios
            List<Socio> listado = this.socioDAO.getAll();
            request.setAttribute("listado", listado);

            request.setAttribute("ID Socio Elimiinado", id);

            //redirigimos a la página de listado de socios
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoSociosB.jsp");

        }else {

            // si el optional no está presente, es decir, no existe el socio con ese id
            // entonces redirigimos a la página de listado de socios con un mensaje de error

            request.setAttribute("error", "No existe el socio con el id: " + id);

            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoSociosB.jsp");
        }

        dispatcher.forward(request, response); // Hacemos la redirección interna en el servidor a la página de listado de socios
        // con la lista de socios actualizada
        }
}
