package lab;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("shoppingDAO")
public class ShoppingDAO extends EgovAbstractMapper {


	public int insertShopping(ShoppingVO vo){
		return insert("Shopping.insertShop", vo);
	}
    	
	public int deleteShopping(ShoppingVO vo){
		return delete("Shopping.deleteShop", vo);
	}
		
	public List<ShoppingVO> selectShopList(ShoppingVO vo){
		return selectList("Shopping.selectShopList", vo);
	}

	public ShoppingVO selectShopping(ShoppingVO vo){
		return selectOne("Shopping.selectShop", vo);
	}
	
	public int updateShopping(ShoppingVO vo){
		return update("Shopping.updateShop", vo);
	}
	
	public List<ShoppingVO> selectShoppingList(Map<?, ?> param) { 
		 return selectList("employee.selectShoppingList", param); 
	}
	
	public int getShoppingCount(Map<?, ?> param) {
		return (Integer)selectOne("shopping.getShoppingCount", param); 
	}
}
