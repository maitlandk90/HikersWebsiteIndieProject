package edu.matc.controller;

import edu.matc.persistence.HikerAccountDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to search for a Hiker Account.
 * @author dmiller
 */

@WebServlet(
        urlPatterns = {"/searchHikerAccount"}
)

public class SearchHikerAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HikerAccountDao hikerAccountDao = new HikerAccountDao();

        String searchType = req.getParameter("searchType");
        String searchTerm = req.getParameter("searchTerm");

        if (searchTerm == null || searchTerm.isEmpty()) {

            req.setAttribute("hiker_accounts", hikerAccountDao.getHikerAccountsByLastName(searchTerm));

        } else {

            req.setAttribute("hiker_accounts", hikerAccountDao.getAllHikerAccounts());
        }

        String url = "/results.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);

    }
}
