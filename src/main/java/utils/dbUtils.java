package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class dbUtils {

    //定义一个ComboPooledDataSource变量
    private static ComboPooledDataSource cpd = new ComboPooledDataSource();

    //静态代码块,用于初始化数据源参数
    static{
        Properties pro = new Properties();
        InputStream in = dbUtils.class.getResourceAsStream("/jdbc.properties");
        try {
        //读入配置文件
            pro.load(in);
        //数据源配置
        // 数据库基本的四个参数
            cpd.setDriverClass(pro.getProperty("jdbc.driver"));
            cpd.setJdbcUrl(pro.getProperty("jdbc.url"));
            cpd.setUser(pro.getProperty("jdbc.user"));
            cpd.setPassword(pro.getProperty("jdbc.password"));
        //数据源的其他配置,可以不配置,C3P0有默认配置
            cpd.setMaxPoolSize(Integer.parseInt(pro.getProperty("maxPoolSize")));   //连接池最大连接数
            cpd.setMinPoolSize(Integer.parseInt(pro.getProperty("minPoolSize")));   //连接池最小连接数最下
            cpd.setMaxIdleTime(Integer.parseInt(pro.getProperty("maxIdleTime")));   //最大空闲等待时间
        } catch (IOException | PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    /**
     *@Author: zsb
     *@Description:  获取连接池中的连接
     *@params: 
     *@Date: 2018/6/1 16:01
    */
    public static Connection getConnection() throws SQLException {
      return cpd.getConnection();
    }

    //关闭连接的操作
    public void closeConnction(ResultSet rs, PreparedStatement ps, Connection conn){
        try{
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
