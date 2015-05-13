package ge.edu.geolab;

import ge.edu.geolab.dao.PersistenceManager;
import ge.edu.geolab.dao.UserDao;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        EntityManager entityManager = PersistenceManager.getInstance().getEntityManager();
        UserDao userDao = new UserDao(entityManager);
        List list = userDao.selectEntries(0);

        for (Object o : list) {
            writer.write(o.toString());
            writer.write("\n");
        }

        int statusCode = HttpServletResponse.SC_OK;
        resp.setStatus(statusCode);
        writer.flush();
    }

}
