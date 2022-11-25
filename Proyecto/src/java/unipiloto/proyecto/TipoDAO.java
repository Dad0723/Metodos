package unipiloto.proyecto;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoDAO extends Conexion{
    
    public ArrayList<Tipo> mostrarTipo (){
        ArrayList<Tipo> lista = new ArrayList<>();
        
        try {
            this.conectar();
            
            String sql="SELECT * FROM tipo";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            
            while(rs.next()){
                Tipo c= new Tipo();
                
                c.setIdTipo(rs.getInt(1));
                c.setTipopanel(rs.getString(2));
                
                lista.add(c);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al mostrar"+ e.getMessage());
        } finally {
            this.desconectar();
        }
        
        return lista;
    } 
    
    
}
