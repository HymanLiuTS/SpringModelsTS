package springmvcts;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvcts.domain.SpitterService;

@Controller
public class HomeController {

	private SpitterService spitterService;

	@Autowired
	public HomeController(SpitterService spitterService) {
		this.spitterService = spitterService;
	}

	@RequestMapping("/")
	// @ResponseBody
	public String showHomePage(Map<String, Object> model) {
		return this.spitterService.getHome();
	}
}
