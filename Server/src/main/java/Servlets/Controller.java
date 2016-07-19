/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.BaseDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcos Filho
 */
public class Controller extends HttpServlet {

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
            throws ServletException, IOException {
        try {

            // Não é um conjunto de pares nome-valor,
            // então tem que ler como se fosse um upload de arquivo...
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            request.getInputStream(), "UTF8"));
            String textoDoJson = br.readLine();

            JsonObject jsonObjectDeJava = null;
            // Ler e fazer o parsing do String para o "objeto json" java
            try ( //Converte o string em "objeto json" java
                    // Criar um JsonReader.
                    JsonReader readerDoTextoDoJson
                    = Json.createReader(new StringReader(textoDoJson))) {
                // Ler e fazer o parsing do String para o "objeto json" java
                jsonObjectDeJava = readerDoTextoDoJson.readObject();
                // Acabou, então fechar o reader.
            } catch (Exception e) {
                e.printStackTrace();
            }

            String op = jsonObjectDeJava.getString("opcao");
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet res = null;
            BaseDAO DAO = new BaseDAO();

            String station = jsonObjectDeJava.getString("station");
            String dateI = jsonObjectDeJava.getString("dateI");
            String dateF = jsonObjectDeJava.getString("dateF");
            conn = DAO.getConnection();
            String sql = null;

            switch (op) {
                case "tmax":
                    sql = " SELECT Climate.VALOR , Climate.DATA from Climate"
                            + " WHERE Climate.DATA >= ?   "
                            + " AND Climate.DATA <= ?     "
                            + " AND Climate.ESTACAO = ?   "
                            + " AND Climate.TIPO = 'TMAX' ";
                    break;
                case "tmin":
                    sql = " SELECT Climate.VALOR , Climate.DATA from Climate"
                            + " WHERE Climate.DATA >= ?   "
                            + " AND Climate.DATA <= ?     "
                            + " AND Climate.ESTACAO = ?   "
                            + " AND Climate.TIPO = 'TMIN' ";
                    break;
                case "tavg":
                    sql = "SELECT AVG(Climate.VALOR) AS Mean,"
                            + " YEAR(Climate.DATA) AS Year"
                            + " FROM Climate"
                            + " WHERE Climate.DATA >= ? AND"
                            + " Climate.DATA <= ? AND"
                            + " Climate.ESTACAO = ? AND"
                            + " (Climate.TIPO = 'TMAX' OR"
                            + " Climate.TIPO = 'TMIN')"
                            + " GROUP BY Year"
                            + " ORDER BY Year ASCENDING";

                    break;
                case "prec":
                    sql = " SELECT Climate.VALOR , Climate.DATA from Climate"
                            + " WHERE Climate.DATA >= ?   "
                            + " AND Climate.DATA <= ?     "
                            + " AND Climate.ESTACAO = ?   "
                            + " AND Climate.TIPO = 'PRCP' ";
                    break;
                case "snow":
                    sql = " SELECT Climate.VALOR , Climate.DATA from Climate"
                            + " WHERE Climate.DATA >= ?   "
                            + " AND Climate.DATA <= ?     "
                            + " AND Climate.ESTACAO = ?   "
                            + " AND Climate.TIPO = 'SNOW' ";

                    break;
                default:
                    System.out.println("BUG");
            }
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dateI);
            stmt.setString(2, dateF);
            stmt.setString(3, station);
            res = stmt.executeQuery();

            //Variables to hold statements, connection, and results
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
