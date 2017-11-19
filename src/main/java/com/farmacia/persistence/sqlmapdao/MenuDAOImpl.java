package com.farmacia.persistence.sqlmapdao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import com.farmacia.domain.Menu;
import com.farmacia.persistence.iface.IMenuDao;
import com.farmacia.util.Constants;
/**
 * Clase que implementa los métodos definidos en la interface correspondiente a 'MenuDao' 
 *    y extiende la plantilla de acceso a la base de datos 'SqlMapDaoTemplate'
 * @author .
 */
public class MenuDAOImpl extends DAO implements IMenuDao {

	
	
	public MenuDAOImpl(com.ibatis.dao.client.DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * Implementación del método básico de inserción de un registro en la base de datos.
	 * @param com.morris.vo.Menu
	 */
	public void insertMenu(Menu menu) {

			
			HashMap datosseq = new HashMap();
			datosseq.put(Constants.SEQNAME,  "idmenu");
			datosseq.put(Constants.TABLENAME,  "menu");
			Long id = getNext(datosseq);
			menu.setIdmenu(new BigDecimal(id.longValue()));
			
			/**Como no esta contemplado el ingreso del codigo en las interfaces
			 * se le esta seteando al codigo el mismo id*/
			insert("insertMenu", menu);

		
	
	
	}

	/**
	 * Implementación del método básico de actualización de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Menu)
	 * @param Menu
	 */
	public void updateMenu( Menu menu) {

		update("updateMenu", menu);
	}

	/**
	 * Implementación del método básico de borrado de un registro en la base de datos.
	 * @param java.math.BigDecimal (llave primaria de Menu) 
	 */
	public void deleteMenu(Menu menu) {
		delete("deleteMenu", menu);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna un objeto con la misma estructura del registro de la tabla.
	 * @param java.math.BigDecimal (llave primaria de Menu)
	 * @return Menu (Objeto mapeado directamente de la BD) 
	 */
	public Menu getMenu(Menu menu) {
		return (Menu) queryForObject("getMenu", menu);
	}

	/**
	 * Implementación del método básico de consulta por llave primaria de un registro en la base de datos
	 * Retorna una cadena con la estructura XML del registro de la tabla.
	 * @param int (llave primaria de Pv_header)
	 * @return java.lang.String (Cadena de texto XML mapeada directamente de la BD) 
	 */
	public String getMenuXmlString(Long id_menu) {
		return (String) queryForObject("getMenuXmlString", id_menu);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'Pv_header'). 
	 */
	public Collection getMenuListPag() {
		return queryForPaginatedList("getMenuList", null, Integer.parseInt( PAGE_SIZE));
	}

	public Collection getMenuList() {
		return queryForList("getMenuList", null);
	}
	
	public Collection getMenuListByPerfil(BigDecimal id_perfil) {
		System.out.println("El id perfil es :"+id_perfil);
		return queryForList("getMenuListByPerfil", id_perfil);
	}

	/**
	 * Implementación del método básico de consulta todos los registros paginados de la base de datos	 
	 * @return com.ibatis.common.util.PaginatedList (Lista paginada con objetos de tipo 'java.lang.String' 
	 *                                               correspondientes a estructuras XML de 'Pv_header'). 
	 */
	public com.ibatis.common.util.PaginatedList getMenuListXmlString() {
		return queryForPaginatedList("getMenuListXmlString", null, Integer.parseInt( PAGE_SIZE));
	}
	
		/**
	 * MÉTODOS PERSONALIZADOS DE ACCESO A LA BASE DE DATOS:	 
	 */

}