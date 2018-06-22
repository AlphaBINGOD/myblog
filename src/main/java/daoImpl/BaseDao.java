package daoImpl;

import utils.PaginationUtils;
import utils.dbUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

/*
* 基础的jdbc类
* 包含增删改封装方法,带泛型的查询方法
* 此后任何dao实现类都必须继承这个BaseDao类
*
* */
public class BaseDao {

    private static BaseDao baseDao = null;

    /**
     *@Author: zsb
     *@Description: 对外提供一个相同的BaseDao实例,由于BaseDao是其他类的父类,暂时没有办法做成单例继承
     *@params:
     *@Date: 2018/6/8
    */
    public static BaseDao getBaseDao(){
        if(baseDao != null){
            return baseDao;
        }else {
            return new BaseDao();
        }
    }

    /**
     *@Author: zsb
     *@Description: 封装的增删改方法
     *@params:
     *@Date: 2018/6/1 16:04
    */
    public int update(String sql, Object...params){
        int result = 0;
        //try-with-resouece可以在操作后自动关闭资源
        try(Connection conn = dbUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            //向ps预编译的sql语句中添加对应的属性
            setParams(ps,params);
            //执行sql语句,并获得影响的数据库条数
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *@Author: zsb
     *@Description: 封装的查询方法,使用泛型获取保存所有的查询信息
     *@params:
     *@Date: 2018/6/1 16
    */
    public <T> List<T> queryForList(Class<T> clazz, String sql, Object... params){

        List<T> list = new ArrayList<>();

        try(Connection conn = dbUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            //占位符赋值
            setParams(ps, params);
            //执行查询
            ResultSet rs = ps.executeQuery();
            //获得对应类的所有属性值
            Field[] fields = clazz.getDeclaredFields();
            while(rs.next()){
                //根据传入类的class生成一个对应的实例,用于保存数据库中对应的每一条数据
                T newObject = clazz.newInstance();
                //结果集每一条数据,都需要找到对应的setter方法遍历赋值一次,这里使用反射来应对不同的返回值情况
                //特别注意,需要表属性名和实体类属性名相同
                for (Field field : fields) {
                    //获取对应变量在数据库中的内容
                    Object columnValue = rs.getObject(field.getName());
                    //获得属性名,并转换为首字母大写,主要是因为set方法后是首字母大写的属性名
                    String UpperFieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    //找到对应的set方法, 这个getType()弄了好一阵,参数需要的是方法参数类型的.class对象
                    Method method = clazz.getMethod("set" + UpperFieldName, field.getType());
                    //执行方法
                    method.invoke(newObject,columnValue);
                }
                list.add(newObject);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return list;
    }

        /*以下方法是使用map保存每一条数据,但是使用其实不方便,因此再做了一个查询方法,直接可以获取对象*/
/*    public List<Map<String, Object>> queryForList(String sql, Object...params){
        List<Map<String, Object>> list = new ArrayList<>();
        try(Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            setParams(ps, params);
            //执行查询
            ResultSet rs = ps.executeQuery();
            //获得结果集的属性
            ResultSetMetaData rsm = rs.getMetaData();
            //获得属性的数量
            int column = rsm.getColumnCount();
            String columnName = null;
            Object columnValue = null;
            while(rs.next()){
                //循环赋值每一个map, 每一个map代表一条数据
                Map<String, Object> map = new HashMap<>();
                for(int i = 0; i < column; i++){
                    columnName = rsm.getColumnName(i+1);
                    columnValue = rs.getObject(i+1);
                    map.put(columnName,columnValue);
                }
                //向list里添加每条数据
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }*/

    /**
     *@Author: zsb
     *@Description: 用于查询表中所有的数据总数,主要是分页的时候需要用到
     *@params: table: 表名
     *@Date: 2018/6/3
    */
    public static int queryTotalNumber(String table){
        int total = 0;
        //占位符对表名不起作用,支队字段值有用,所以不能用?
        String sql = "SELECT COUNT(*) FROM " + table;
        try(Connection conn = dbUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    /**
     *@Author: zsb
     *@Description: 向预编译PrepareStatement的sql语句里添加对应的属性, 这个方法被这个类的其他方法使用
     *@params:
     *@Date: 2018/6/1
    */
    public void setParams(PreparedStatement ps, Object... params) throws SQLException {
        if(params != null){
            for(int i = 0; i < params.length; i++){
                ps.setObject(i+1,params[i]);
            }
        }
    }

    /**
     *@Author: zsb
     *@Description: 用于将table表里的数据进行定制排序输出指定内容,这种语句很常用
     *@params:
     *@Date: 2018/6/4
    */
    public <T> List<T> queryRankingByCondition(Class<T> clazz, String table, String condition, String asc, int beginRow, int rowNumber){
        String sql = "SELECT * FROM "+ table + " ORDER BY " + condition +" "+ asc + " LIMIT " + beginRow +","+ + rowNumber;
        return queryForList(clazz, sql,null);
    }

    /*按特定条件查询一条数据*/
    /*----------------------------*/
    public <T> T queryOneDataByCondition(Class<T> clazz, String table, String condition, int real){
        String sql = "SELECT * FROM "+ table + " WHERE " + condition + " = " + real;
        List<T> list = queryForList(clazz, sql, null);
        return (list.size() > 0)?list.get(0):null;
    }

    /*分页相关*/
    /*----------------------------*/
    /**
     *@Author: zsb
     *@Description: 获得总页数
     *@params:
     *@Date: 2018/6/7
     */
    public int getTotalPage(String table,int rowNum){
        return (int) Math.ceil((double) BaseDao.queryTotalNumber(table) / rowNum);
    }

    /**
     *@Author: zsb
     *@Description: 根据传入页码获取某页的数据,注意检查页码合法性
     *@params:
     *@Date: 2018/6/7
     */
    public <T> List<T> getPageData(int page, Class<T> clazz, String table, String condition, String asc, int rowNum){
        //检查页码合法性
        page = checkPaginationLimit(page, table, rowNum);
        int beginRow = getBeginRow(page,rowNum);
        return queryRankingByCondition(clazz,table,"id","DESC",beginRow,rowNum);
    }

    /**
     *@Author: zsb
     *@Description: 获取所有数据
     *@params:
     *@Date: 2018/6/15
    */
    public <T> List<T> queryForAll(String table, Class<T> clazz){
        String sql = "SELECT * FROM " + table;
        return queryForList(clazz, sql, null);
    }

    /**
     *@Author: zsb
     *@Description: 获取起始行号
     *@params:
     *@Date: 2018/6/7
     */
    public int getBeginRow(int page,int rowNum){
        return (page-1) * rowNum;
    }

    /**
     *@Author: zsb
     *@Description: 页数上下限检查
     *@params:
     *@Date: 2018/6/5
     * */
    public int checkPaginationLimit(int page,String table,int rowNum){
        //查询所有数据条数
        int totalPage = BaseDao.getBaseDao().getTotalPage(table,rowNum);
        page = page <     1     ?     1     : page ;
        page = page > totalPage ? totalPage : page ;
        return page;
    }

    //改------------------------------------------------------------------------------------------
    /**
     *@Author: zsb
     *@Description: 对数据库某个字段进行加1操作
     *@params:
     *@Date: 2018/6/15
    */
    int incrementByOneStep(String table, String cloumnName, int id){
        String sql = "UPDATE "+ table + " SET "+ cloumnName + " = " + cloumnName + " + 1 WHERE id = ?";
        return update(sql,id);
    }





}
