package controller;

import model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            action = "viewAlbums";  // Mặc định
        }

        String url = "/index.jsp";

        // Xử lý lấy thông tin sản phẩm (album) với dữ liệu nhạc mới
        String productCode = request.getParameter("productCode");
        if (productCode != null && !productCode.isEmpty()) {
            String description = "";
            java.util.List<model.Song> songs = new java.util.ArrayList<>();

            if (productCode.equals("cine01")) {
                description = "Epic Soundscapes - Cinematic Scores";
                songs.add(new model.Song("The Final Battle", "final_battle.mp3"));
                songs.add(new model.Song("A Hero's Journey", "heros_journey.mp3"));
            } else if (productCode.equals("cine02")) {
                description = "Orchestral Legends - Volume 2";
                songs.add(new model.Song("Rise of the King", "rise_king.mp3"));
                songs.add(new model.Song("Dragon's Lair", "dragons_lair.mp3"));
            } else if (productCode.equals("lf01")) {
                description = "Midnight Coder - Lo-Fi Beats";
                songs.add(new model.Song("Late Night Syntax", "late_night_syntax.mp3"));
                songs.add(new model.Song("Coffee & Compilers", "coffee_compilers.mp3"));
            } else if (productCode.equals("edm01")) {
                description = "Neon Lights - The Festival Collection";
                songs.add(new model.Song("Electric Sunrise", "electric_sunrise.mp3"));
                songs.add(new model.Song("Jump The Beat", "jump_the_beat.mp3"));
            } else {
                description = "Unknown Album";
            }

            request.setAttribute("productCode", productCode);
            request.setAttribute("description", description);
            request.setAttribute("songs", songs);
        }

        if (action.equals("checkUser")) {
            // Lấy thông tin user từ session (nếu có)
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            if (user == null) {
                // Nếu chưa đăng ký, chuyển sang trang register.jsp
                url = "/register.jsp";
            } else {
                // Nếu đã đăng ký, chuyển sang trang download.jsp
                url = "/download.jsp";
            }
        } else if (action.equals("registerUser")) {
            // Xử lý form đăng ký
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            // Lưu vào session
            User user = new User(email, firstName, lastName);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            url = "/download.jsp";
        }

        // Thực hiện điều hướng
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}