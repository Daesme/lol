/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DaoElementos;
import DAO.DaoUsuario;
import Modelo.Elemento;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.SQLException;

/**
 *
 * @author maria
 */
public class BuscarElemento extends HttpServlet  {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identificador = request.getParameter("user");
        String clave = request.getParameter("pass");
        try {
            String parametro = request.getParameter("Buscar");
            Elemento elm = new Elemento();
            DaoElementos daoE = new DaoElementos();
            elm = daoE.buscarPorNombre(parametro);
            request.setAttribute("etiqueta", elm);
            
            response.setContentType("application/json");
           
        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
