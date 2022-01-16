package bdbt_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Controller
public class AppController implements WebMvcConfigurer {
    @Autowired
    private OperatorzyDAO operatorzyDAO;
    @Autowired
    private AdresyDAO adresyDAO;


    @RequestMapping(value = {"/index","/"} )
    public String viewHomePage(Model model) {
        return "index";
    }
    @RequestMapping("/login")
    public String loginPage(Model model){
        return "login";
    }
    @RequestMapping("/main")
    public String mainPage(Model model){
        return "main";
    }

    @RequestMapping("/operatorData")
    public String viewOperatorDataPage(Model model) {
        List<Operator> operatorList = operatorzyDAO.list();
        model.addAttribute("operatorList", operatorList);
        return "operatorData";
    }

    @RequestMapping("/new")
    public String viewClickPage(Model model) {
        Operator operator = new Operator();
        Adres adres = new Adres();
        model.addAttribute("operator", operator);
        model.addAttribute("adres", adres);
        return "new_Operator";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("operator") Operator operator, @ModelAttribute("adres") Adres adres) {
        if (adresyDAO.validate(adres) == Boolean.TRUE) {
            String adresId = adresyDAO.save(adres);
            operator.setNrAdresu(adresId);
            operatorzyDAO.save(operator);
            return "redirect:/operatorData";
        } else return "redirect:/input_error";
    }

    @RequestMapping("/edit/{Nr_operatora}")
    public ModelAndView showEditForm(@PathVariable(name = "Nr_operatora") String Nr_operatora) {
        ModelAndView mav = new ModelAndView("edit_Operator_form");
        Operator operator = operatorzyDAO.get(Nr_operatora);
        Adres adres = adresyDAO.get(operator.getNrAdresu()); //stad adres dla danego operatora B)
        mav.addObject("operator", operator);
        mav.addObject("adres", adres);
        System.out.println(operator);
        System.out.println(adres);
        return mav; //czemu nie po prostu String edit_Operator_form?
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("operator") Operator operator, @ModelAttribute("adres") Adres adres) {
        System.out.println(operator);
        System.out.println(adres);
        operatorzyDAO.update(operator);
        adres.setNrAdresu(operator.getNrAdresu());
        adresyDAO.update(adres);
        return "redirect:/operatorData";
    }

    @RequestMapping("/delete/{nr_operatora}")
    public String deleteOperator(@PathVariable(name = "nr_operatora") String nr_operatora) {
        operatorzyDAO.delete(nr_operatora);
        return "redirect:/operatorData";
    }
}
