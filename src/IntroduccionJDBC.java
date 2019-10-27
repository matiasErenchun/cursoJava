import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntroduccionJDBC
{
    public static void main(String[] args)
    {
        //paso1. creamos al cadana de conexion
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";// el problema era los parametros de la conexion
        // en casod e no funcionar agregar el jar del controlador al jdk correspondiente en C:\Program Files\Java\jdk1.8.0_191\jre\lib\ext
        // o en C:\Program Files\Java\jre1.8.0_231\lib\extS

        try
        {
            //paso 2 . creamos el objeto de conexion
            Connection conexion= DriverManager.getConnection(url, "root","Oni199233");
            // paso3. crear objeto Statement
            Statement instruccion=conexion.createStatement();
            //paso 4. crear squery
            String sql ="select * from persona";
            //paso 5. ejecucion del query
            ResultSet resultado= instruccion.executeQuery(sql);
            //paso 6. procesar el resultado
            while(resultado.next())
            {
                System.out.print(" id persona :"+ resultado.getInt(1)+",");
                System.out.println(" persona nombre :"+ resultado.getString(2));

            }

            //cerrar todos los objetos usados
            resultado.close();
            instruccion.close();
            conexion.close();

        }
        catch (SQLException e)
        {
            //Logger.getLogger(IntroduccionJDBC.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace(System.out);
        }
    }
}
