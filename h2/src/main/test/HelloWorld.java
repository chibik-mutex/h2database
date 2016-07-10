package test;

import org.h2.tools.DeleteDbFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloWorld {

    public static void main(String... args) throws Exception {

        DeleteDbFiles.execute("~", "test", true);

        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
        Statement stat = conn.createStatement();

        stat.execute("create table test(id int primary key, name varchar(255))");

        for(int i = 0; i < 20000; i++) {
            stat.execute("insert into test values('" + i + "', 'Hello')");
        }

        ResultSet rs;
        rs = stat.executeQuery("select count(*) from test");
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }
        stat.close();
        conn.close();
    }

}
