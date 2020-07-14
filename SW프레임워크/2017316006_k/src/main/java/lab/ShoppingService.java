package lab;

import java.util.List;
import java.util.Map;

public interface ShoppingService  {
	
	public int insertShopping(ShoppingVO shoppingVO) throws Exception;
	
	public int deleteShopping(ShoppingVO shoppingVO)throws Exception;

	public List<ShoppingVO> selectShoppingList(ShoppingVO shoppingVO)throws Exception;

	public void insertTransaction(ShoppingVO shoppingVO) throws Exception;
	
	public ShoppingVO selectShopping(ShoppingVO shoppingVO) throws Exception;

	public int updateShopping(ShoppingVO shoppingVO)throws Exception;
	
	public List<ShoppingVO> selectShoppingList(Map<?, ?> param) throws Exception;
	
	public int getShoppingCount(Map<?, ?> param) throws Exception;
	
}
