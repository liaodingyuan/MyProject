package com.springmvc.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import oracle.jdbc.oracore.OracleType;


public class ProcedureCallTest {

    Connection conn = null;
    Statement ste = null;
    ResultSet rs = null;
    CallableStatement proc = null;
    private final String driver = "oracle.jdbc.driver.OracleDriver";
    private final String url = "jdbc:Oracle:thin:@127.0.0.1:1521:yuanhaha";
    private final String user = "scott";
    private final String pass = "tiger";

    public ProcedureCallTest() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("regite failure!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("get connection failure!");
            e.printStackTrace();
        }

    }

    /*
     * 存储过程无返回参数（out参数）
     */
    public void procedureE() throws SQLException {
        proc = conn.prepareCall("{ call TESTA(?,?) }");
        proc.setString(1, "100");
        proc.setString(2, "TestOne");
        proc.execute();

    }

    /*
     * 存储过程有返回参数
     */
    public void procedureB() throws SQLException {
        proc = conn.prepareCall("{ call TESTB(?,?) }");
        proc.setString(1, "SMITH");
        //存储过程的out参数
        proc.registerOutParameter(2, Types.VARCHAR);
        proc.execute();
        //get相对应的out参数在存储过程中的index
//		这里的 proc.getString(2)中的数值 2并非任意的， 而是和存储过程中的 out列对应
//		的，如果 out 是在第一个位置，那就是 proc.getString(1)，如果是第三个位置，就是
//		proc.getString(3)，当然也可以同时有多个返回值，那就是再多加几个 out参数了
        String outPara = proc.getString(2);
        System.out.println("输出的参数：" + outPara);
    }

    /*
     * 存储过程返回列表
     */
    public void procedureC() throws SQLException {
        proc = conn.prepareCall("{ call TESTC(?) }");
        //游标类型
        proc.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        proc.execute();
        rs = (ResultSet) proc.getObject(1);
        while (rs.next()) {
            System.out.println("<tr><td>" + rs.getString(1) +
                    "</td><td>"
                    + rs.getString(2) + "</td></tr>");
        }
    }

    public static void main(String[] args) throws SQLException {
        ProcedureCallTest P = new ProcedureCallTest();
        P.procedureC();
    }

}
