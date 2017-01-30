package fr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.beans.FinanceBean;
import fr.utility.ConnectionDB;

public class FinancesDAO {

	private Connection connection;

	/** Constructor**/
	public FinancesDAO() {
		connection = ConnectionDB.getConnection();
	}
	
	public void createFinance (FinanceBean finance) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement("INSERT INTO finance (type_action, somme, libelle, turn, animals_number, player_id, enclosure_id, payMonthly) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, finance.getType_action());
			st.setLong(2, finance.getSomme());
			st.setString(3, finance.getLibelle());
			st.setString(4, finance.getTurn());
			st.setInt(5, finance.getAnimals_number());
			st.setInt(6, finance.getPlayer_id());
			st.setInt(7, finance.getEnclosure_id());
			st.setInt(8, finance.getPayMonthly());
			
			st.executeUpdate();
			
			ResultSet generatedKeys = st.getGeneratedKeys();
			if (generatedKeys.next()) {
				finance.setId(generatedKeys.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("On a une erreur dans la requête");
			e.printStackTrace();
		} finally { 
			if (st != null) {
				try {
					st.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public FinanceBean getFinanceById(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;		
		FinanceBean finance = null;
		
		try {
			st = connection.prepareStatement("SELECT * FROM finance WHERE id=?");
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				finance = new FinanceBean();
				finance.setType_action(rs.getString("type_action"));
				finance.setSomme(rs.getLong("somme"));
				finance.setLibelle(rs.getString("libelle"));
				finance.setTurn(rs.getString("turn"));
				finance.setAnimals_number(rs.getInt("animals_number"));
				finance.setPlayer_id(rs.getInt("player_id"));
				finance.setPayMonthly(rs.getInt("payMonthly"));
				finance.setEnclosure_id(rs.getInt("enclosure_id"));
			}
		} catch (SQLException e) {
			System.out.println("On a une erreur dans la requête");
			e.printStackTrace();
		} finally { 
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (st != null) {
				try {
					st.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return finance;
	}
	
	public List<FinanceBean> getFinancesByPlayer(int player_id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<FinanceBean> finances = new ArrayList<>();
		
		try {
			st = connection.prepareStatement("SELECT * FROM finance WHERE player_id=?");
			st.setInt(1, player_id);
			rs = st.executeQuery();
			

			while (rs.next()) {
				FinanceBean finance = new FinanceBean();
				// creation de la transaction
				finance.setId(rs.getInt("id"));
				finance.setType_action(rs.getString("type_action"));
				finance.setSomme(rs.getLong("somme"));
				finance.setLibelle(rs.getString("libelle"));
				finance.setTurn(rs.getString("turn"));
				finance.setAnimals_number(rs.getInt("animals_number"));
				finance.setPlayer_id(rs.getInt("player_id"));
				finance.setPayMonthly(rs.getInt("payMonthly"));
				finance.setEnclosure_id(rs.getInt("enclosure_id"));
				// sauvegarde de la transaction dans la liste
				finances.add(finance);
			}
			
		} catch (SQLException e) {
			System.out.println("On a une erreur dans la requête");
			e.printStackTrace();
		} finally { 
			
			if (rs != null) {
				try {
					rs.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (st != null) {
				try {
					st.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return finances;
	}
	
	public List<FinanceBean> getAllFinances() {
		List<FinanceBean> finances = new ArrayList<FinanceBean>();
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM finance");

			while (rs.next()) {
				FinanceBean finance = new FinanceBean();

				finance.setId(rs.getInt("id"));
				finance.setType_action(rs.getString("type_action"));
				finance.setSomme(rs.getLong("somme"));
				finance.setLibelle(rs.getString("libelle"));
				finance.setTurn(rs.getString("turn"));
				finance.setAnimals_number(rs.getInt("animals_number"));
				finance.setPlayer_id(rs.getInt("player_id"));
				finance.setPayMonthly(rs.getInt("payMonthly"));
				finance.setEnclosure_id(rs.getInt("enclosure_id"));

				finances.add(finance);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			
			if (rs != null) {
				try {
					rs.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (st != null) {
				try {
					st.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return finances;
	}
	
	// recuperation des prets du joueur
	public List<FinanceBean> getLoansByPlayer (int player_id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<FinanceBean> loans = new ArrayList<>();
		
		try {
			st = connection.prepareStatement("SELECT * FROM finance WHERE type_action='loan' AND player_id=?");
			st.setInt(1, player_id);
			rs = st.executeQuery();
			
			while (rs.next()) {
				FinanceBean loan = new FinanceBean();
				// creation de la transaction
				loan.setId(rs.getInt("id"));
				loan.setType_action(rs.getString("type_action"));
				loan.setSomme(rs.getLong("somme"));
				loan.setLibelle(rs.getString("libelle"));
				loan.setTurn(rs.getString("turn"));
				loan.setAnimals_number(rs.getInt("animals_number"));
				loan.setPlayer_id(rs.getInt("player_id"));
				loan.setPayMonthly(rs.getInt("payMonthly"));
				loan.setEnclosure_id(rs.getInt("enclosure_id"));
				
				// sauvegarde du pret dans la liste
				loans.add(loan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			
			if (st != null) {
				try {
					st.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return loans;
	}
	
	public void deleteLoan (int id) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement("DELETE FROM finance WHERE id=?");
			st.setInt(1, id);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			
			if (st != null) {
				try {
					st.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateFinances(FinanceBean finance) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement("UPDATE finance SET type_action=?, somme=?, libelle=?, turn=?, animals_number=?, player_id=?, enclosure_id=?, payMonthly=? WHERE id=?");
			st.setString(1, finance.getType_action());
			st.setLong(2, finance.getSomme());
			st.setString(3, finance.getLibelle());
			st.setString(4, finance.getTurn());
			st.setInt(5, finance.getAnimals_number());
			st.setInt(6, finance.getPlayer_id());
			st.setInt(7, finance.getEnclosure_id());
			st.setInt(8, finance.getPayMonthly());
			st.setInt(9, finance.getId());


			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			
			if (st != null) {
				try {
					st.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deleteFinances(int idPlayer) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement("DELETE FROM finance WHERE id=?");
			st.setInt(1, idPlayer);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			
			if (st != null) {
				try {
					st.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
