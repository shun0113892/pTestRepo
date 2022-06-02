package sample.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ReviewDAO")
public class ReviewDAO
{
     private static final String URL="jdbc:mysql://localhost:3306/sample";
     private static final String USER="root";
     private static final String PASSWD="id4kpqu8";
     
      public void dbconnect() {
    	  // JDBCドライバ読み込み
          try {
            // PostgreSQLドライバの読み込み
            Class.forName("com.mysql.jdbc.Driver");
          } catch(ClassNotFoundException e) {
            e.printStackTrace();
          }
      }
      //findAllメソッド
       public List<ReviewDTO> findAll() 
       {
    	 PreparedStatement ps = null;
         // DTOクラスのインスタンス格納用
         List<ReviewDTO> ReviewDTO = new ArrayList<>();
         dbconnect();//ドライバ読み込み
      
         // データベースへの接続
         try(Connection conn = DriverManager.getConnection(URL,USER,PASSWD);) 
         {
           // sql文を実行するためのオブジェクト生成
           //String sql = "SELECT * FROM test_tbl where id = ?";
           String sql = "SELECT * FROM test_tbl";
           ps = conn.prepareStatement(sql);
           //ps.setInt(1, 1);//?を変換したい時だけこうする
           ResultSet rset = ps.executeQuery();
           
           //実行された結果から全ての値を取り出す。
           //これはwhile一回で、1レコードの処理。
           //なおかつ実行された配列からとってきたカラムをdtoのフィールドにセット。
           while(rset.next()) 
           {
             // ReviewDTOクラスのインスタンスを生成
             ReviewDTO dto = new ReviewDTO();
             // カラムidの値をフィールドidにセット
             dto.setId(rset.getInt("id"));
             // カラムnameの値をフィールドnameにセット
             dto.setName(rset.getString("name"));
             // カラムageの値をフィールドageにセット
             dto.setAge(rset.getInt("age"));
             // インスタンスをListに格納
             ReviewDTO.add(dto);
           }
         } catch(SQLException e) {
           e.printStackTrace();
         }finally {
        	 if(ps != null) {
        		 try {
        			 ps.close();
        		 } catch(SQLException e) {
        			 
        		 }
        	 }
         }
         // DTOクラスのインスタンスのListを返す
         return ReviewDTO;
       }
       //findAllメソッド終
       
       
     //
       public boolean Exist(int param) 
       {
    	 PreparedStatement ps = null;
         dbconnect();//ドライバ読み込み
         // データベースへの接続
         try(Connection conn = DriverManager.getConnection(URL,USER,PASSWD);) 
         {
           // sql文を実行するためのオブジェクト生成
           String sql = "SELECT * FROM test_tbl where id = ?";
           ps = conn.prepareStatement(sql);
           ps.setInt(1, param);//?を変換したい時だけこうする
           ResultSet rset = ps.executeQuery();
           
           if(rset.next()) 
           {
        	   return true;
           }
           
         } catch(SQLException e) {
           e.printStackTrace();
         }finally {
        	 if(ps != null) {
        		 try {
        			 ps.close();
        		 } catch(SQLException e) {
        			 
        		 }
        	 }
         }
         return false;
       }
       //
   	
}
