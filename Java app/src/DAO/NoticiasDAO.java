package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entidad.Noticias;

/**
 * <p>Esta clase representa una noticia y proporciona funcionalidades para 
 * gestionar la información relacionada con los contenido en la base de datos.</p>
 * @author gabriel
 *
 */

public class NoticiasDAO {

    /**

*<p>Añade una noticia a la base de datos.</p>
*@param con <p>Establece la conexión con la base de datos.</p>
*@param noticia <p>La noticia a añadir.</p>
*@throws Exception <p>Tira una excepción si hay un problema al insertar la noticia.</p>
*/

    public void addNoticia(Connection con, Noticias noticia) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO noticias (id_noticia, id_evento, nombre, noticia) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, noticia.getId_noticia());
            stmt.setInt(2, noticia.getId_evento());
            stmt.setString(3, noticia.getNombre());
            stmt.setString(4, noticia.getNoticia());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al insertar la noticia: " + e.getMessage());
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }




}