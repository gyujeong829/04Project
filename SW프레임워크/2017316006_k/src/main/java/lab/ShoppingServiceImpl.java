package lab;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("shoppingService")
@Transactional(rollbackFor={Exception.class})
public class ShoppingServiceImpl implements ShoppingService {
	@Resource(name="shoppingDAO")
	ShoppingDAO dao;
	
	@Override	
	public int insertShopping(ShoppingVO shoppingVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertShopping(shoppingVO);
	}

	@Override
	public int deleteShopping(ShoppingVO shoppingVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteShopping(shoppingVO);		
	}
	
	@Override
	public List<ShoppingVO> selectShoppingList(ShoppingVO shoppingVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectShopList(shoppingVO);
	}
	
	public void insertTransaction(ShoppingVO shoppingVO) throws Exception{		
		dao.deleteShopping(shoppingVO);
		dao.insertShopping(shoppingVO);
		shoppingVO.id = "3";
		dao.insertShopping(shoppingVO);
		throw new Exception();
	}	
	
	@Override
	public int updateShopping(ShoppingVO shoppingVO) throws Exception {
		// TODO Auto-generated method stub		
		return dao.updateShopping(shoppingVO);		
	}	
	
	@Override
	public ShoppingVO selectShopping(ShoppingVO shoppingVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectShopping(shoppingVO);
	}
	
	@Override
	public List<ShoppingVO> selectShoppingList(Map<?, ?> param) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectShoppingList(param); 
	}
	
	@Override
	public int getShoppingCount(Map<?, ?> param) throws Exception {
		// TODO Auto-generated method stub
		return dao.getShoppingCount(param); 
	}
}
