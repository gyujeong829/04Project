package lab;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class ShoppingContoller {
	@Resource(name="shoppingService") 
	ShoppingService shoppingservice; 
	
	@RequestMapping(value = "/shoppingAdd.do", method=RequestMethod.GET) 
	protected String shoppingAddForm(ModelMap model) throws Exception{ 
		model.addAttribute("shopping",new ShoppingVO()); 
		return "shopping/shoppingAddForm"; 	
	}
	
	@RequestMapping(value = "/shoppingAdd.do", method=RequestMethod.POST)
	protected String shoppingAdd(@ModelAttribute("shopping") ShoppingVO
		command, BindingResult errors, ModelMap model) throws Exception { 
			if (errors.hasErrors()) { 
				return "shopping/shoppingAddForm"; 
			}
			shoppingservice.insertShopping(command); 
			return "redirect:/shoppingList.do"; 
	}
	
	@RequestMapping(value = "/shoppingList.do") 
	protected String shoppingList(ModelMap model) throws Exception{ 
		ShoppingVO vo = new ShoppingVO(); 
		List<ShoppingVO> shoppinglist = shoppingservice.selectShoppingList(vo);  
		model.addAttribute("shoppinglist",shoppinglist); 		
		return "shopping/shoppingList"; 
	}
	
	@RequestMapping(value = "/shoppingView.do")
	protected String shoppingAdd(@RequestParam String id, ModelMap model) 
	throws Exception { 
		ShoppingVO vo = new ShoppingVO();
		vo.setId(id); 
		ShoppingVO command = shoppingservice.selectShopping(vo);
		model.addAttribute("shoppinginfo",command);
		return "shopping/shoppingView"; 
	}
	
	@RequestMapping(value = "/shoppingModify.do", method=RequestMethod.GET)
	protected String shoppingModifyForm(@RequestParam String id,ModelMap model) 
	throws Exception{
		ShoppingVO vo = new ShoppingVO();
		vo.setId(id);
		ShoppingVO command = shoppingservice.selectShopping(vo);
		model.addAttribute("shopping",command);
		return "shopping/shoppingModifyForm"; 
	}
	
	@RequestMapping(value = "/shoppingModify.do", method=RequestMethod.POST)
	protected String shoppingModify(@ModelAttribute("shopping") ShoppingVO
			command, BindingResult errors, ModelMap model) throws Exception {
				if (errors.hasErrors()) { 
					return "shopping/shoppingModifyForm"; 
				}
				shoppingservice.updateShopping(command); 
				return "redirect:/shoppingView.do?id="+command.getId(); 
	}
	
	@RequestMapping(value = "/shoppingRemove.do") 
	protected String shoppingRemove(@RequestParam String id) 
	throws Exception { 
		ShoppingVO vo = new ShoppingVO();
		vo.setId(id); 
		shoppingservice.deleteShopping(vo); 
		return "redirect:/shoppingList.do"; 
	}
	
	@RequestMapping(value = "/shoppingList.do") 
	protected String shppingList(@RequestParam(value = "pageNo", required = false) 
	String pageNo, @ModelAttribute("searchCriteria") SearchCriteria searchCriteria, 
	ModelMap model, @RequestParam Map<String, Object> commandMap) 
			throws Exception{ 
		int currentPageNo; 
		try{
			currentPageNo = Integer.parseInt(pageNo); 
		} catch (Exception e) { 
			currentPageNo = 1; 
		}
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo); 
		paginationInfo.setRecordCountPerPage(3); 
		paginationInfo.setPageSize(10); 
		commandMap.put("firstIndex", paginationInfo.getFirstRecordIndex()); 
		commandMap.put("lastIndex", paginationInfo.getLastRecordIndex());
		commandMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage()); 
		List<ShoppingVO> shoppinglist =  shoppingservice.selectShoppingList(commandMap); 
		model.addAttribute("shoppinglist",shoppinglist); 
		model.addAttribute("searchCriteria", searchCriteria); 
		int shoppingCount = shoppingservice.getShoppingCount(commandMap); 
		paginationInfo.setTotalRecordCount(shoppingCount); 
		model.addAttribute("paginationInfo", paginationInfo); 
		return "shopping/shoppingList"; 
	}
}
