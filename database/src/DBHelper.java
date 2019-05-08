import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import java.sql.Connection;
import java.sql.SQLException;


public class DBHelper {
    public static Connection createConnection()
    {

        JsonParser a = new JsonParser();
        JsonObject obj=a.parse(Helper.readFromFile("properties.json")).getAsJsonObject();
        BoneCP bcp=null;
        Connection con =null;

        try {
            BoneCPConfig config = new BoneCPConfig();
            config.setJdbcUrl("jdbc:mysql://"+obj.get("URL").getAsString()+"/"+obj.get("Database").getAsString()+"?useUnicode=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"); // jdbc url specific to your database, eg jdbc:mysql://127.0.0.1/yourdb
            config.setUsername(obj.get("Username").getAsString());
            config.setPassword(obj.get("Password").getAsString());
            bcp = new BoneCP(config); // setup the connection pool
            con = bcp.getConnection(); // fetch a connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
