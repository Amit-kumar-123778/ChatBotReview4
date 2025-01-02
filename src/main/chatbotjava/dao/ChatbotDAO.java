package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class ChatbotDAO {
	    private Connection connection;

	    public ChatbotDAO(Connection connection) {
	        this.connection = connection;
	    }

	    public String getResponse(String userInput) throws SQLException {
	        String response = "";
	        String query = "SELECT response FROM chatbot_responses WHERE user_input = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, userInput);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            response = resultSet.getString("response");
	        }
	        return response;
	    }
	}



