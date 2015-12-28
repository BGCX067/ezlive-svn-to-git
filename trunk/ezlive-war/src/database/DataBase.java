package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class DataBase<E> {

	protected Logger log = Logger.getLogger("DataBase");

	protected Connection conn;

	protected ResultSet keyGenerate;

	public void open() {
		try {
			
			

			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/ezlive");
			conn = ds.getConnection();
			
		} catch (SQLException e) {
			log.warning("Can't connect database "+e);
		} catch (NamingException e) {
			log.warning("Can't connect database "+e);
		}
	}

	public void requeteMaj(String query) {
		try {
			PreparedStatement st = conn.prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
			st.executeUpdate();
			keyGenerate = st.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
			log.warning("MAJ database failed");
		}
	}

	public ResultSet execQuery(String query) {
		try {
			PreparedStatement st = (PreparedStatement) conn
					.prepareStatement(query);
			ResultSet res = st.executeQuery();
			return res;
		} catch (SQLException e) {
			log.warning("Excecute query failed");
		}
		return null;
	}

	public int getKeyGenerated() {
		try {
			if (keyGenerate.next()) {
				return keyGenerate.getInt(1);
			}
		} catch (SQLException e) {
			log.warning("Return generated key failed");
		}
		return 0;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			log.warning("Can't close data base connect "+e);
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public ResultSet getKeyGenerate() {
		return keyGenerate;
	}

	public void setKeyGenerate(ResultSet keyGenerate) {
		this.keyGenerate = keyGenerate;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public abstract void ajout(E o);

}
