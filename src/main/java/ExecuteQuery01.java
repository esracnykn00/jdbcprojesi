import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Marmara00");
        Statement statement = connection.createStatement();

        //1. Örnek:  region id'si 1 olan satir degerlerini değerlerini çağırın.
        String sql1 = "select * from countries where region_id=1";
        boolean r1 = statement.execute(sql1);
        System.out.println("r1 = " +r1); //true doner cunku select komutu ile data cagirdik.

        //NOT: sql QUERY ile cagirilan datayi gorebilmek icin executeQuery() methodu ile kullanmaliyiz.
        /*
        executeQuery() methodu cagirilan datayi ResultSet datasi olarak doner.
        Default olarak ResultSet bir pointer ile doner ve bu pointer sutun isimleri gosterir.
        Datayi okuyabilmek icin next() methodu ile pointeri siradaki satira tasimaliyiz.
        next() methodu sirada satir varsa true, yoksa false doner ve pointeri siradaki satira tasir.
         */

        //ResultSet resultSet = statement.executeQuery(sql1); //resultset cagirilan datanin icine hapsoldugu kopyalandigi yerdir
        //resultSet.next();
       // resultSet.next();
        //resultSet.next();


        //System.out.println(resultSet.getString("country_name"));

        ResultSet resultSet = statement.executeQuery(sql1);
        while(resultSet.next()){
            System.out.println("country_id: "+resultSet.getString("country_id")+ "country_name: "+resultSet.getString("country_name")+ "region_id: "+resultSet.getString("region_id"));
        }

        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        System.out.println("\n===========Ornek 2 ==========\n");
        String sql2 = "select country_id, country_name from countries where region_id>2";
        ResultSet resultSet2 = statement.executeQuery(sql2);

        while(resultSet2.next()){
            System.out.println(resultSet2.getString(1)+ "|| "+resultSet2.getString(2));
        }

        //3.Ornek: "number_of_employees" degeri en düşük olan satırın tüm değerlerini cağırın.
        System.out.println("\n=========Ornek 3 ===========\n");
        String sql3 = "select * from companies where number_of_employees = (select min(number_of_employees) from companies)";
        ResultSet resultSet3 = statement.executeQuery(sql3);

        while (resultSet3.next()) {
            System.out.println(resultSet3.getString(1) + "|| " + resultSet3.getString(2) + " || " + resultSet3.getString(3));
        }























































    }
}
