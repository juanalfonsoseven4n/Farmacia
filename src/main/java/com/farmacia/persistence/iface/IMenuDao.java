package com.farmacia.persistence.iface;
import java.math.BigDecimal;
import java.util.Collection;

import com.farmacia.domain.Menu;
/** 
 * @author Julio Barros
 * Interface que define los métodos de acceso principales a la base de datos 
 */
public interface IMenuDao {

	/**se genera
	 * Insertar registro en Base de datos
	 * @param com.morris.vo.Menu menu
	 */
	public void insertMenu(Menu menu);

	/**
	 * Actualizar registro en base de datos
 	 * @param Long id_menu
	 * @param Menu menu
	 */
	public void updateMenu(Menu menu);

	/**
	 * Eliminar un registro de la base de datos
 	 * @param Long id_menu
	 */
	public void deleteMenu(Menu menu);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param Long id_menu
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Menu getMenu(Menu menu);

	/**
	 * Consultar un registro por llave primaria de la base de datos
 	 * @param Long id_menu
	 * @return java.lang.String (XML resultante)
	 */
	public java.lang.String getMenuXmlString(Long id_menu);

	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList
	 */
	public Collection getMenuListPag();
	
	public Collection getMenuList();

	public Collection getMenuListByPerfil(BigDecimal id_perfil);
	/**
	 * Consultar todo el conjunto de registros paginados de la base de datos
	 * @return com.ibatis.common.util.PaginatedList (Objetos java.lang.String con la representación XML del registro)
	 */
	public com.ibatis.common.util.PaginatedList getMenuListXmlString();
	
		/**
	 * MÉTODOS PERSONALIZADOS A IMPLEMENTAR EN LAS CLASES HIJA
	 */

}
