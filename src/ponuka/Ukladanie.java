package ponuka;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Ukladanie implements Ulozenie {
    private final static String URL = "jdbc:sqlite:data/db.db";
    private static Ukladanie UKLADANIE;
    private Connection connection;


    public static Ukladanie getInstance() {
        if (UKLADANIE == null)
        {
            UKLADANIE = new Ukladanie();
        }

        return  UKLADANIE;
    }


    private Ukladanie()
    {
        if (this.connection == null) {
            try {
                this.connection = DriverManager.getConnection(URL);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        String sql = """
    CREATE TABLE IF NOT EXISTS scores (
        id INTEGER PRIMARY KEY,
        name TEXT NOT NULL UNIQUE,
        points INTEGER
    );
    """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void ulozSkore(Skore skore) {

        String sql = "INSERT INTO scores (name, points) VALUES (?, ?) ON CONFLICT(name) DO NOTHING";

        try (var preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setString(1, skore.name());
            preparedStatement.setInt(2, skore.points());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public boolean jeMenoUnikatne(String meno) {
        String sql = "SELECT 1 FROM scores WHERE name = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(sql))
        {
            statement.setString(1, meno);
            try (ResultSet resultSet = statement.executeQuery())
            {
                return !resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Skore> nacitajSkore() {
        String sql = "SELECT name, points FROM scores";
        List<Skore> skoreList = new LinkedList<>();

        try (var statement = this.connection.createStatement();
             var resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int points = resultSet.getInt("points");
                skoreList.add(new Skore(name, points));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return skoreList;
    }

}
