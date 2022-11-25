package unipiloto.proyecto;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends Conexion {
    
    public int insertarUsuario(Usuario us){
        int res=0;
        
        try {
            this.conectar();
            String sql = "INSERT INTO usuario (user, nombre, apellido, correo, password, tiporol) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?);";
                    
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, us.getUser());
            pre.setString(2, us.getNombre());
            pre.setString(3, us.getApellido());
            pre.setString(4, us.getCorreo());
            pre.setString(5, us.getPassword());
            pre.setInt(6, us.getTiporol());
            
            res= pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar" +e.getMessage());
        } finally {
            this.desconectar();
        }
        
        return res;
    }
    
    public int modificarPassword(Recuperar c){
        
        int res=0;
        
        try {
            this.conectar();
            
            String sql= "UPDATE `usuario` SET `password`=? WHERE `correo`= ?";
            PreparedStatement pre= this.getCon().prepareStatement(sql);
            pre.setString(1, c.getPass());
            pre.setString(2, c.getCorreo());
            
            res =pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al cambiar contrasena "+e.getMessage());
        } finally{
            this.desconectar();
        }
        return res;
        
    }
    
    public String iniciarProyecto(String usuario, String contra){
        
        int iniciar;
        String devolver="";
        try {
            this.conectar();
            System.out.println("entrar");
            String sql="SELECT user,password, tiporol FROM usuario WHERE user=? and password=?";
            PreparedStatement pre= this.getCon().prepareStatement(sql);
            pre.setString(1, usuario);
            pre.setString(2, contra);
            
            ResultSet rs;
            rs = pre.executeQuery();
            
            if(rs.next()){
                iniciar = rs.getInt(3);
                switch (iniciar) {
                    case 1:
                        devolver="administrador";
                        break;
                    case 2:
                        devolver="cliente";
                        break;
                    default:
                        devolver="";
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al iniciar "+e.getMessage());
        } finally{
            this.desconectar();
        }
        return devolver;
    }
}
