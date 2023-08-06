
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //1. Adım: Driver'a kaydol ==> JDBC 4 sonrasi gerekli değil 1.adim kullanilmiyor artik
        //Class.forName("org.postgresql.Driver");

        //2. Adım: Database'e bağlan
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Marmara00");

        //3. Adım: Statement oluştur
        Statement statement = connection.createStatement();

        //4. Adım: Query çalıştır

        //1.Ornek: worker adinda bir table olusturunuz
        boolean sql1 = statement.execute("CREATE TABLE worker (worker_id VARCHAR(20),worker_name VARCHAR(20), worker_salary INT)");
        System.out.println("sql1 = " + sql1);
        /*
        execute() methodu DDL (create, drop, alter, truncate) ile kullanildiginda data donmeyecegi icin her zaman false doner.
        execute() methodu DQL (Select) ile kullanildginda data donerse true donmezse false doner.
         */

        //2/Ornek: worker table ina worker_address adinda bir sutun ekleyiniz
        boolean sql2 = statement.execute("ALTER TABLE worker ADD worker_address VARCHAR(100)");
        System.out.println("sql2 = " + sql2); //false doner cunku bir data cagirilmadi

        //3.Ornek: worker table ini siliniz
        boolean sql3 = statement.execute("DROP TABLE worker");
        System.out.println("sql3 = " + sql3); //false



        //5.Adim: Baglantiyi kapat
        connection.close();
        statement.close();


        /*
        JDBC kullanmaya başlamaya karar verdiysek genellikle yapacağımız adımlar şunlar. (Bu adımları tek tek ileriki yazılarımda inceleyeceğiz)
            1)Veritabanımız ile bağlantı oluşturacağız.
            2)JDBC Driver’imizi yükleyeceğiz.
            3)Statement/PreparedStatement sorgularımızı oluşturacağız.
            4)Resultset oluşturacağız
            5)Ve son olarak oluşturduğumuz bağlantıyı/statementi/resulset’i kapatacağız.
         */



























    }
}