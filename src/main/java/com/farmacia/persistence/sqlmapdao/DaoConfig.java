package com.farmacia.persistence.sqlmapdao;

import java.io.Reader;
import java.util.Properties;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

/**
 * Clase que usando los archivos de configuración de <b>iBatis</b>, provee intancias de la clase DaoManager que será usada para obtener las intancias de DAOs.
 */
public class DaoConfig {

	

	private static final DaoManager daoManager;

	static {
		try {
			Properties props =
			Resources.getResourceAsProperties("com/farmacia/persistence/resources/database.properties");
			String resource = "com/farmacia/persistence/resources/dao.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			System.out.println("Reader: "+reader.toString());
			System.out.println("Props: "+props.getProperty("username"));
			System.out.println("Props: "+props.getProperty("url"));
			System.out.println("Props: "+props.getProperty("schema"));
			System.out.println("Props: "+props.getProperty("jndi.name"));
			daoManager = DaoManagerBuilder.buildDaoManager(reader,props);
			System.out.println("DaoManagerBuilder: "+daoManager.toString());
		} catch (Exception e) {
			System.out.println("E."+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Description.  Cause: " + e, e);
		}
	}
	/**
	 * Obtiene el manejador de DAOs 
	 * @return El manejador de DAOs 
	 */
	public static DaoManager getDaoManager() {
		return daoManager;
	}


}