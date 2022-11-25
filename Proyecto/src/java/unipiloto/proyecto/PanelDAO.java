package unipiloto.proyecto;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PanelDAO extends Conexion {

    public int insertarPanel(Panel pn) {
        int res = 0;

        try {
            this.conectar();
            String sql = "INSERT INTO panel (identificacion, nombre, apellido, fe_registro, tipopanel, mensaje,"
                    + "ubicacion, fe_entrada, fe_salida) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? );";

            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, pn.getIdentificacion());
            pre.setString(2, pn.getNombre());
            pre.setString(3, pn.getApellido());
            pre.setString(4, pn.getFe_registro());
            pre.setInt(5, pn.getIdTipo());
            pre.setString(6, pn.getMensaje());
            pre.setString(7, pn.getUbicacion());
            pre.setString(8, pn.getFe_entrada());
            pre.setString(9, pn.getFe_salida());

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar" + e.getMessage());
        } finally {
            this.desconectar();
        }

        return res;
    }

    public ArrayList<Panel> mostrarPaneles() {
        ArrayList<Panel> lista = new ArrayList<>();

        try {
            this.conectar();
            String sql = "SELECT * FROM panel cl INNER JOIN tipo ca ON cl.tipopanel=ca.idTipo";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();

            while (rs.next()) {

                Panel pa = new Panel();

                pa.setId(rs.getInt(1));
                pa.setIdentificacion(rs.getString(2));
                pa.setNombre(rs.getString(3));
                pa.setApellido(rs.getString(4));
                pa.setFe_registro(rs.getString(5));
                pa.setIdTipo(6);
                pa.setTipopanel(rs.getString(12));
                pa.setMensaje(rs.getString(7));
                pa.setUbicacion(rs.getString(8));
                pa.setFe_entrada(rs.getString(9));
                pa.setFe_salida(rs.getString(10));

                lista.add(pa);

            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar" + e.getMessage());
        } finally {
            this.desconectar();
        }

        return lista;
    }

    public ArrayList<Notificacion> notificarPanel() {
        ArrayList<Notificacion> lista = new ArrayList<>();

        try {
            this.conectar();
            String sql = "SELECT id, mensaje,ubicacion FROM panel WHERE tipopanel=2 OR tipopanel=4";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();

            String via;
            while (rs.next()) {

                Notificacion pa = new Notificacion();

                pa.setId(rs.getInt(1));
                pa.setMensaje(rs.getString(2));
                pa.setUbicacion(rs.getString(3));
                via=rs.getString(3);
                String[] parts = via.split(" ");
                int part2 = Integer.parseInt(parts[1]) + 1;

                String tex = parts[0] + " " + part2;
                pa.setViaAlterna(tex);

                lista.add(pa);

            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar" + e.getMessage());
        } finally {
            this.desconectar();
        }

        return lista;
    }

    public int modificarPanel(Panel pa) {
        int res = 0;

        try {
            this.conectar();
            String sql = "UPDATE panel SET identificacion=?, nombre=?, apellido=?, fe_registro=?,"
                    + "tipopanel=?, mensaje=?, ubicacion=?, fe_entrada=?, fe_salida=? WHERE id=?";

            PreparedStatement pre = this.getCon().prepareStatement(sql);

            pre.setString(1, pa.getIdentificacion());
            pre.setString(2, pa.getNombre());
            pre.setString(3, pa.getApellido());
            pre.setString(4, pa.getFe_registro());
            pre.setInt(5, pa.getIdTipo());
            pre.setString(6, pa.getMensaje());
            pre.setString(7, pa.getUbicacion());
            pre.setString(8, pa.getFe_entrada());
            pre.setString(9, pa.getFe_salida());
            pre.setInt(10, (pa.getId()));

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarCliente(Panel pa) {
        int res = 0;

        try {
            this.conectar();

            String sql = "DELETE FROM panel where id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pa.getId());

            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

}
