package com.bridgelabz.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc

/**
 * @author bridgeit
 * @param <T>
 * @param <E>
 *
 */
@Repository("dao")
public class TableDaoImpl<T, E> implements TableDao {
	/** The m table name. */
	public String mTableName = null;

	/** The mColumnDataType. */
	public String mColumnDataType[] = null;

	/** The json objects keys. */
	public Map<String, E> jsonObjectsKeys = new HashMap<String, E>();

	/** The db connection. */
	static Connection dbConnection = null;

	/** The pstmt. */
	PreparedStatement pstmt = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bridgelabz.dao.TableDao#getFile(java.lang.String,
	 * org.springframework.validation.BindingResult)
	 */
	@SuppressWarnings({ "unchecked" })
	public ModelAndView getFile(String uploadedValidFile, BindingResult result) throws IOException, Exception {
		JSONObject jsonObject = new JSONObject(uploadedValidFile);
		// loop to get the dynamic key
		for (Object keys : jsonObject.keySet()) {
			mTableName = (String) keys;
		}
		String columnField = null;
		String dataType=null;
		String mcol_data_type=null;
		JSONObject valueObject = null;
		JSONArray jsonArray = jsonObject.getJSONArray(mTableName);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject object = jsonArray.optJSONObject(i);
			Iterator<String> iterator = (Iterator<String>) object.keys();
			while (iterator.hasNext()) {
				columnField = iterator.next();
				if (columnField instanceof String)
				valueObject = new JSONObject(object.get(columnField).toString());
				dataType=valueObject.getString("type");
				mcol_data_type=returnDataType(dataType);
				jsonObjectsKeys.put(columnField,(E) mcol_data_type);
				System.out.println("json :" + jsonObjectsKeys.toString());
				}
			}
		mColumnDataType = (String[]) jsonObjectsKeys.values().toArray();
		for (String s : mColumnDataType) {
			System.out.println("data :" + s);
		}
		try {
			getConnection();
			createTable();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return new ModelAndView("showFile");
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream(
				"/home/bridgeit/Downloads/eclipse/home/bridgeit/json/FileUpload/src/main/webapp/WEB-INF/dbConnection.properties");
		// load a properties file
		prop.load(input);
		String drivers = prop.getProperty("jdbc.driver");
		String connectionURL = prop.getProperty("jdbc.url");
		String username = prop.getProperty("jdbc.username");
		String password = prop.getProperty("jdbc.password");
		Class.forName(drivers);
		dbConnection = DriverManager.getConnection(connectionURL, username, password);
		return dbConnection;
	}

	/**
	 * Creates the table.
	 *
	 * @return the model and view
	 * @throws SQLException
	 *             the SQL exception
	 */
	private ModelAndView createTable() throws SQLException {

		DatabaseMetaData dbm = dbConnection.getMetaData();
		// check if "employee" table is there
		ResultSet table = dbm.getTables(null, null, mTableName, null);
		if (table.next()) {
			// Table exists
			System.out.println("table name already exist in Database..!");
			return new ModelAndView("tableExist");
		} else {
			// Table does not exist
			System.out.println("else stamnt entered ");
			// create SQL query to create new table Team
			String query = null;
			System.out.println("tablename :" + mTableName);
			query = "create table " + mTableName + "(";
			for (int i = 0; i < mColumnDataType.length; i++) {
				query = query + mColumnDataType[i] + " varchar(30) ";
				if (i != mColumnDataType.length - 1)
					query += ",";
			}
			query = query + ");";
			System.out.println(query);
			// create a statement
			pstmt = dbConnection.prepareStatement(query);
			// Step 5 Executing SQL & retrieve data into ResultSet
			int sqlQueryResult = pstmt.executeUpdate();
			// output of database creation
			if (0 == sqlQueryResult) {
				System.out.println("New table created successfully");
			} else {
				System.out.println("Error in creating table");
			}
		}
		return new ModelAndView("showFile");
	}
	public String returnDataType(String data_type)
	{
		String col_data_type = null;
		switch(data_type){
		
		case "string":
			col_data_type= "varchar(40)";
		break;
		case "integer":
			col_data_type="integer";
		break;
		}
		return col_data_type;
	}
}
