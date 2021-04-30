import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

	//attributi per la connessione al Database

	private String URL = "jdbc:postgresql://localhost:5432/AgriturismoDB";
	private String USER = "postgres";
	private String PASSWORD = "2522";

	private Connection conn;


	//creazione metodo per la connessione al DB

	public void connect() {

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			if (conn != null)
				System.out.println("connected to the database");
			else
				System.out.println("failed to make connection");

		}

		catch (SQLException e) {
			System.err.format("SQL state: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/*
	public List<Anagrafica> queryAllAnagrafica() throws SQLException {
		List<Anagrafica> result = new ArrayList<>();

		if (conn == null) {
			System.out.println("errore, connessione non aperta");
			return null;

		}


		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM main.ANAGRAFICA";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			Anagrafica elem = new Anagrafica();
			elem.setCodfiscale(rs.getString("cod_fiscale"));
			elem.setCognome(rs.getString("cognome"));
			elem.setNome(rs.getString("nome"));
			elem.setDatanascita(rs.getString("data_nascita"));
			result.add(elem);
		}

		return result;

	}
*/

}
