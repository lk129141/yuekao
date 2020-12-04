package until;

import java.lang.reflect.Field;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: BaseDao
 * @Description: TODO
 * @Author: lk
 * @date: 2020/11/30 14:24
 * @Version: V1.0
 */
public class BaseDao {
    protected Connection con ;
    protected PreparedStatement ps ;
    protected ResultSet rs;

    //声明常量
    private static  final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/lk";
    private static final String USERNAME="root";
    private static final String PASSWORD="123";

    /**
     * 1.获取数据连接驱动
     * @return
     */
    public Connection getConnection(){
        //1.加载驱动
        try {
            Class.forName(DRIVER);
            //2.连接对象
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 2.释放资源
     * @param conn
     * @param ps
     * @param rs
     */
    public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
        //6、释放资源
        try {
            if(rs !=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps !=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 添加， 删除，修改
     * @param sql
     * @param params
     * @return
     */
    public int excuteUpdate(String sql,Object...params){
        try {
            PreparedStatement ps=getConnection().prepareStatement(sql);
            if(params.length>0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询所有的数据
     * @param sql
     * @param params
     * @return
     */
    public ResultSet excuteQuery(String sql,Object...params){

        try {
            PreparedStatement ps=getConnection().prepareStatement(sql);
            for (int i = 0; i <params.length ; i++) {
                ps.setObject(i+1,params[i]);
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String   dateToString(String string){
        Date date = new Date();
        SimpleDateFormat si = new SimpleDateFormat(string);
        String str = si.format(date);
        return str ;
    }
    public static Date stringToDate(String dates,String string) throws ParseException {
        SimpleDateFormat si = new SimpleDateFormat(string);
        Date dd = si.parse(dates);
        return dd;
    }

    /**
     * 通过反射机制查询单条记录
     * @param sql
     * @param cls
     * @param params
     * @param <T>
     * @return
     * @throws SQLException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <T>T excuteOneQuery(String sql,Class<T> cls,Object...params) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        T resultObject=cls.newInstance();  //得到实例
        //查询数据
        ResultSet rs=this.excuteQuery(sql,params);
        // 获取元数据
        ResultSetMetaData metaData=rs.getMetaData();
        int colLen=metaData.getColumnCount();  //获取列数
        while(rs.next()){
            for (int i = 0; i <colLen ; i++) {
                //获取数据库列名称 从1开始；
                String colsName=metaData.getColumnName(i+1);
                Object colsValue=rs.getObject(colsName);
                //利用反射字段读取
                Field field=cls.getDeclaredField(colsName);
                field.setAccessible(true);  //设置字段访问权限
                field.set(resultObject,colsValue);
            }

        }
        return resultObject;
    }



    /**
     * 通过反射机制查询多条记录
     * @param sql
     * @param cls
     * @param params
     * @param <T>
     * @return
     * @throws SQLException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <T> List<T> excuteMoreQuery(String sql, Class<T> cls, Object...params) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        List<T> list=new ArrayList<>();
        //查询数据
        ResultSet rs=this.excuteQuery(sql,params);
        // 获取元数据
        ResultSetMetaData metaData=rs.getMetaData();
        //获取列数
        int colLen=metaData.getColumnCount();
        //循环
        while(rs.next()){
            //获得实例 (自动调用默认的构造方法)
            T resultObject=cls.newInstance();
            for (int i = 0; i <colLen ; i++) {
                //获取数据库列名称
                String colsName=metaData.getColumnName(i+1);
                //获得值
                Object colsValue=rs.getObject(colsName);

                //利用反射字段读取
                Field field=cls.getDeclaredField(colsName);
                field.setAccessible(true);
                field.set(resultObject,colsValue);
            }
            list.add(resultObject);
        }
        return list;
    }
}
