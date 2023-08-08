import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Marmara00");
        Statement statement = connection.createStatement();

        //1.Ornek: Prepared statement kullanarak company adi IBM olan number_of_employees degerini 9999 olarak guncelleyin.

        //PreparedStatement olusturmak icin:

        //1.Adim: PreparedStatementquery sini olustur.
        String sql1 = "update companies set number_of_employees = ? where company = ?"; // ? --> parametlendirme yapar

        //2.adim: PreparedStatement objesi olustur.
         PreparedStatement preparedStatement = connection.prepareStatement(sql1);

         //3.Adim : Soru isareti yerine atamalar yap
        preparedStatement.setInt(1,9999);
        preparedStatement.setString(2,"IBM");

        //4.Adim: Query i calistir
        int guncellenenStirSayisi = preparedStatement.executeUpdate();
        System.out.println("gucellenenSatirSayisi = " + guncellenenStirSayisi);











    }
}
