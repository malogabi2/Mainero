/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorDB;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conectar {
    private Connection conexion = null;
    private Statement sentencia = null;
    private ResultSet rs = null;

    public Conectar() {
        System.out.println("Conecto");
    }

    public void conectarInformix(String maquina, String nombreBD, String usuario, String clave) throws ClassNotFoundException, SQLException {
        String url = "jdbc:informix-sqli://" + maquina + ":1900:INFORMIXSERVER=" + nombreBD + ";user=" + usuario + ";password=" + clave + "";
        System.out.println(url);
        Class.forName("com.informix.jdbc.IfxDriver");
        System.out.println("Driver OK");
        Properties pr = new Properties();
        pr.put("OPTOFC", "1");
        this.conexion = DriverManager.getConnection(url, pr);
        System.out.println("catalog " + this.conexion.getCatalog());
    }

    public void conectarAccess(String nombreBD, String usuario, String clave) throws ClassNotFoundException, SQLException {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String url = "jdbc:odbc:" + nombreBD;
        this.conexion = DriverManager.getConnection(url, usuario, clave);
    }

    public void conectarPostgres(String maquina, String nombreBD, String usuario, String clave) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println("'conectarPostgres()' Error al intentar cargar Driver. " + e.getMessage());
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://" + maquina + "/" + nombreBD;
        this.conexion = DriverManager.getConnection(url, usuario, clave);
    }

    public boolean conectarMySQL(String maquina, String nombreBD, String usuario, String clave) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println("'conectarMySQl()' Error al intentar cargar Driver. " + e.getMessage());
            e.printStackTrace();
        }
        try {
            String url = "jdbc:mysql://" + maquina + "/" + nombreBD;
            String userName = usuario;
            String password = clave;
            String selectMethod = "cursor";
            this.conexion = DriverManager.getConnection(url, userName, password);
            return true;
        }
        catch (Exception error) {
            System.out.println("Error: no se ha podido crear la conexion con " + nombreBD + " server: " + maquina + " " + error.getMessage() + ".\n");
            return false;
        }
    }

    public boolean conectarSQL(String maquina, String nombreBD, String usuario, String clave) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://";
        String serverName = maquina;
        String databaseName = nombreBD;
        String userName = usuario;
        String password = clave;
        String selectMethod = "cursor";
        url = url + serverName + ";databaseName=" + databaseName + ";selectMethod=" + selectMethod + ";";
        this.conexion = DriverManager.getConnection(url, userName, password);
        return true;
    }

    public void conectarHSQL(String archivo, String usuario, String clave) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        }
        catch (ClassNotFoundException e) {
            System.err.println("'conectarHSQL()' Error al intentar cargar Driver. " + e.getMessage());
            e.printStackTrace();
        }
        try {
            String url = "jdbc:hsqldb:" + archivo;
            this.conexion = DriverManager.getConnection(url, usuario, clave);
        }
        catch (SQLException e) {
            System.err.println("'conectarHSQL()' Error al intentar conectarse. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        System.out.println("Cierro conexion");
        try {
            this.conexion.close();
        }
        catch (Exception e) {
            System.err.println("'cerrarConexion()' Error al intentar cerrar conexion. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void iniciarBloque(String nombreTabla) {
        try {
            this.sentencia = this.conexion.createStatement(1005, 1008);
            this.rs = this.sentencia.executeQuery("SELECT * FROM " + nombreTabla);
            this.rs.moveToInsertRow();
        }
        catch (SQLException e) {
            System.err.println("'iniciarBloque()' Error en iniciar bloque. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertarCampo(String nombreColumna, Object valorColumna) {
        try {
            this.rs.updateObject(nombreColumna, valorColumna);
        }
        catch (SQLException e) {
            System.err.println("'insertarCampo()' Error al intentar insertar campo a la BD. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cerrarBloque() {
        try {
            if (this.rs != null) {
                this.rs.insertRow();
                this.rs.close();
                this.sentencia.close();
            }
        }
        catch (SQLException e) {
            System.err.println("'cerrarBloque()' eRROR al guardar en la BD. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean existeCampo(String nombreTabla, String nombreColumna, Object nombreCampoBuscado) {
        try {
            this.sentencia = this.conexion.createStatement(1005, 1007);
            this.rs = this.sentencia.executeQuery("SELECT " + nombreColumna + " FROM " + nombreTabla);
            while (this.rs.next()) {
                if (!this.rs.getObject(1).equals(nombreCampoBuscado)) continue;
                return true;
            }
        }
        catch (SQLException e) {
            System.err.println("'buscarCampo()' Error al bucar campo. " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public long buscarCampo(String nombreTabla, String nombreColumna, Object nombreCampoBuscado) {
        long cantidad = 0L;
        try {
            this.sentencia = this.conexion.createStatement(1005, 1007);
            this.rs = this.sentencia.executeQuery("SELECT " + nombreColumna + " FROM " + nombreTabla);
            while (this.rs.next()) {
                if (!this.rs.getObject(1).equals(nombreCampoBuscado)) continue;
                ++cantidad;
            }
        }
        catch (SQLException e) {
            System.err.println("'buscarCampo()' Error al bucar campo. " + e.getMessage());
            e.printStackTrace();
        }
        return cantidad;
    }

    public void actualizarCampo(String nombreTabla, String nombreColumna, Object nombreCampoActual, Object nombreCampoNuevo) {
        try {
            this.sentencia = this.conexion.createStatement(1005, 1008);
            this.rs = this.sentencia.executeQuery("SELECT * FROM " + nombreTabla);
            while (this.rs.next()) {
                if (!this.rs.getObject(nombreColumna).equals(nombreCampoActual)) continue;
                this.rs.updateObject(nombreColumna, nombreCampoNuevo);
                this.rs.updateRow();
            }
        }
        catch (SQLException e) {
            System.err.println("'actualizarCampo()' Error al actualizar campo. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarCampo(String nombreTabla, String nombreColumnaLLave, Object nombreCampo) {
        try {
            this.sentencia = this.conexion.createStatement(1005, 1008);
            this.rs = this.sentencia.executeQuery("SELECT " + nombreColumnaLLave + " FROM " + nombreTabla);
            while (this.rs.next()) {
                if (!this.rs.getObject(1).toString().equals(nombreCampo.toString())) continue;
                this.rs.deleteRow();
            }
        }
        catch (SQLException e) {
            System.err.println("'eliminarCampo()' Error al eliminar campo. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ResultSet Select(String select) throws SQLException {
        this.sentencia = this.conexion.createStatement(1005, 1007);
        this.rs = this.sentencia.executeQuery(select);
        return this.rs;
    }

    public Connection getConexion() {
        return this.conexion;
    }

    public ResultSet getRs() {
        return this.rs;
    }

    public void IniciarTransaccion() throws SQLException {
        this.conexion.setAutoCommit(true);
    }

    public void CancelarTransaccion() throws SQLException {
        this.conexion.rollback();
    }

    public void ConfirmarTransaccion() throws SQLException {
        this.conexion.commit();
    }

    public void ejecutaConsulta(String sql) throws SQLException {
        this.sentencia = this.conexion.createStatement();
        this.sentencia.executeUpdate(sql);
        this.sentencia.close();
    }

    ResultSet getConsulta(String sql) throws SQLException {
        this.sentencia = this.conexion.createStatement();
        this.rs = this.sentencia.executeQuery(sql);
        return this.rs;
    }

    public Object[][] pasarATabla(ResultSet registro) throws Exception {
        Object[][] datos = null;
        try {
            registro.afterLast();
            registro.previous();
            int filas = registro.getRow();
            int columna = registro.getMetaData().getColumnCount();
            datos = new Object[filas][columna];
            registro.beforeFirst();
            int j = 0;
            while (registro.next()) {
                for (int i = 1; i < registro.getMetaData().getColumnCount() + 1; ++i) {
                    datos[j][i - 1] = registro.getString(i) != null ? new String(registro.getString(i)) : new String("");
                }
                ++j;
            }
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return datos;
    }

    public Object[][] SelectATabla(String select) throws Exception {
        return this.pasarATabla(this.Select(select));
    }

    protected void finalize() throws Throwable {
        this.cerrarConexion();
        super.finalize();
    }
}

