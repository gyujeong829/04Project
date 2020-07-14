package lab;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShoppingApp {
	public static void main(String[] args) throws Exception {
		String configLocation = "classpath*:META-INF/spring/context-*.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		ShoppingService shopping=(ShoppingService)context.getBean("shoppingService");

		
		//모두 삭제
		shopping.deleteShopping(new ShoppingVO());
		
		//id=1,2 추가
		ShoppingVO vo = new ShoppingVO();		
		
		vo.id = "1";
		vo.name = "줄무늬 셔츠";
		vo.price ="20000";
		vo.color = "blue";
		vo.quantity = "700";
		shopping.insertShopping(vo);
		
		vo.id = "2";
		vo.name = "꽃무늬 원피스";
		vo.price ="25000";
		vo.color = "yellow";
		vo.quantity = "700";
		shopping.insertShopping(vo);
		
		vo.id = "4";
		vo.name = "민소매 원피스";
		vo.price ="17000";
		vo.color = "yellow";
		vo.quantity = "600";
		shopping.insertShopping(vo);
		
		vo.id = "5";
		vo.name = "반팔티";
		vo.price ="10000";
		vo.color = "red";
		vo.quantity = "600";
		shopping.insertShopping(vo);
		
		//transaction test
		ShoppingVO vo1 = new ShoppingVO();
		vo1.id = "2";
		vo1.name = "꽃무늬 원피스";
		vo1.price ="23000";
		vo1.color = "blue";
		vo1.quantity = "800";
		shopping.insertTransaction(vo1);
		
		
		List<ShoppingVO> resultList= shopping.selectShoppingList(new ShoppingVO());
		int num = resultList.size();
		for (int i=0; i<num; i++) {
			ShoppingVO resultvo = resultList.get(i);
			System.out.println("id="+resultvo.id);
			System.out.println("name="+resultvo.name);
			System.out.println("address="+resultvo.price);
			System.out.println("address="+resultvo.color);
			System.out.println("address="+resultvo.quantity);
		}

	}
}
