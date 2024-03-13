import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

	@RequestMapping(value = "/404", method = {RequestMethod.GET, RequestMethod.POST})
	public String handle404() {
		return "404";
	}
}