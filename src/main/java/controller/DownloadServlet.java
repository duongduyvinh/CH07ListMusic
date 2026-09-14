package controller;

import model.User;
import model.Song;
import model.Album;

import data.AlbumDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "viewAlbums";
        }

        String url = "/index.jsp";

        // Lấy thông tin sản phẩm từ Data Layer (Database giả lập)
        String productCode = request.getParameter("productCode");
        if (productCode != null && !productCode.isEmpty()) {
            Album album = AlbumDB.getAlbum(productCode);
            
            if (album != null) {
                request.setAttribute("productCode", album.getProductCode());
                request.setAttribute("description", album.getDescription());
                request.setAttribute("songs", album.getSongs());
            } else {
                request.setAttribute("description", "Unknown Album");
                request.setAttribute("songs", new ArrayList<Song>());
            }
        }

        if (action.equals("checkUser")) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            if (user == null) {
                url = "/register.jsp";
            } else {
                url = "/download.jsp";
            }
        } else if (action.equals("registerUser")) {
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            User user = new User(email, firstName, lastName);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            url = "/download.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}