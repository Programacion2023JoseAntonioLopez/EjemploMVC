package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    // URL de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/midb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root123456";

    private static Connection connection;

    // Constructor privado para evitar instancias directas
    private DBConnection() {}

    // Método estático para obtener la instancia única de la conexión
    public static Connection getConnection() {
        if (connection == null) {
            // Bloqueo sincronizado para evitar concurrencia
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                       // Establecer la conexión
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                        crearTabla(connection);
                    } catch ( SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
    private static void crearTabla(Connection conexion) throws SQLException {
        try (Statement statement = conexion.createStatement()) {
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Persona (\n" +
                            "    dni VARCHAR(10) PRIMARY KEY,\n" +
                            "    nombre VARCHAR(50) NOT NULL,\n" +
                            "    apellido VARCHAR(50) NOT NULL,\n" +
                            "    edad INT CHECK (edad >= 0)\n" +
                            ");"
            );
            System.out.println("Tabla Alumno creada correctamente.");
        }
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

