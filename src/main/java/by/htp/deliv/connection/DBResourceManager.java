package by.htp.deliv.connection;


import java.util.ResourceBundle;

public class DBResourceManager {

    private final static DBResourceManager instance = new DBResourceManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("by.htp.deliv.dao.connection.db");

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }

}