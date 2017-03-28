package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.polito.tdp.libretto.model.Esame;

public class EsameDAO {
	
	public Esame find(String codice){
		
		String sql = "SELCET codice, titolo, docente, data_superamento "+
					 "FROM esame "+
					 /*"WHERE codice=' "+codice+"'" ; */   //metodo da evitare, problema di sicurezza
					 "WHERE codice=?"; //metodo migliore
					 
              String jdbcUrl = "jdbc:mysql:/localhost/libretto?user=root&password=root" ;
              
              Esame ex = null;
              try{
      			
      			Connection conn = DriverManager.getConnection(jdbcUrl);
      		      			
      			PreparedStatement st = conn.prepareStatement(sql);
      			
      			st.setString(1, codice); //con questo sostituisco la concatenazione perchè nella query non è piu esplicito ma è una variabile
      			
      			ResultSet res = st.executeQuery();
      			
      			if(res.next()){ //non piu un while perche abbiamo due possibili valori
      				
      				ex = new  Esame(res.getString("codice"), res.getString("titolo"), res.getString("docente"));
      				
      			} else {
      				return null;
      			}
      		
      			conn.close();
      			return ex;
      		}
      		catch(SQLException e){
      			e.printStackTrace();
      			return null;
      		}
       
	}

	public boolean create(Esame e){
 	   
 	   String sql = "INSERT INTO 'libretto'.'esame' ('codice', 'titolo', 'docente') VALUES (?, ?, ?);" ;   //QUERY DI INSERIMENTO
 	   String jdbcUrl = "jdbc:mysql:/localhost/libretto?user=root&password=root" ;
 	   
 	  try{
			
			Connection conn = DriverManager.getConnection(jdbcUrl);
		      			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, e.getCodice()); //finisce nel primo ?
			st.setString(2, e.getTitolo()); //finisce nel secondo ?
			st.setString(3, e.getDocente()); //finisce nel terzo ?
			
			int result = st.executeUpdate();
			
			conn.close();
			
			if(result == 1){
				return true;
			} else {
				return false;
			}
		}
		catch(SQLException e1){
			e1.printStackTrace();
			return false;
		}
    }
}
