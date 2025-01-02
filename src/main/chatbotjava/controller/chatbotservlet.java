package controller;

	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	@WebServlet("/ChatbotServlet")
	public class chatbotservlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String userMessage = request.getParameter("message");
	        String botResponse = getBotResponse(userMessage);
	        response.getWriter().write(botResponse);
	    }

	    private String getBotResponse(String message) {
	        String response = "";
	        try {
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot_db", "username", "password");
	            String query = "SELECT response FROM chatbot_responses WHERE user_message = ?";
	            PreparedStatement pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, message);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                response = rs.getString("response");
	            } else {
	                response = "I'm sorry, I don't understand.";
	            }
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return response;
	    }
	}


