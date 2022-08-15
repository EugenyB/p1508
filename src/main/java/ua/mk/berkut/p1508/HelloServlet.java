package ua.mk.berkut.p1508;

import ua.mk.berkut.p1508.beans.ArtistBean;
import ua.mk.berkut.p1508.dao.ArtistDao;
import ua.mk.berkut.p1508.db.DBManager;
import ua.mk.berkut.p1508.tables.Artist;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = {"/artists", "/deleteartist"})
public class HelloServlet extends HttpServlet {

    @Resource(name = "jdbc/chinook")
    private DataSource ds;

    public void init() {
        try {
            DBManager.getInstance().initConnection(ds);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("/artists")) {
            List<Artist> artists = new ArtistDao().findAll();
            ArtistBean artistBean = new ArtistBean(artists);
            request.setAttribute("ab", artistBean);
            request.getRequestDispatcher("artists.jsp").forward(request, response);
        } else if (requestURI.endsWith("/deleteartist")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new ArtistDao().deleteArtist(id);
            response.sendRedirect("artists");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("artistname");
        new ArtistDao().addArtist(name);
        response.sendRedirect("artists");
    }

    public void destroy() {
    }
}