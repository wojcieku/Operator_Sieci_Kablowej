package projekt_bdbt;

import oracle.jdbc.OracleDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import projekt_bdbt.Adres.Adres;
import projekt_bdbt.Adres.AdresDAO;
import projekt_bdbt.Adres.AdresExtended;
import projekt_bdbt.Klient.Klient;
import projekt_bdbt.Klient.KlientDAO;
import projekt_bdbt.Oferta.OfertaInternet.OfertaInternet;
import projekt_bdbt.Oferta.OfertaInternet.OfertaInternetDAO;
import projekt_bdbt.Oferta.OfertaTelefonia.OfertaTelefonia;
import projekt_bdbt.Oferta.OfertaTelefonia.OfertaTelefoniaDAO;
import projekt_bdbt.Oferta.OfertaTelewizja.OfertaTelewizja;
import projekt_bdbt.Oferta.OfertaTelewizja.OfertaTelewizjaDAO;
import projekt_bdbt.Poczta.Poczta;
import projekt_bdbt.Poczta.PocztaDAO;
import projekt_bdbt.Umowa.Umowa;
import projekt_bdbt.Umowa.UmowaDAO;
import projekt_bdbt.UmowaSzczegoly.UmowaSzczegoly;
import projekt_bdbt.UmowaSzczegoly.UmowaSzczegolyDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private AdresDAO adresDAO;
    @Autowired
    private PocztaDAO pocztaDAO;
    @Autowired
    private OfertaInternetDAO ofertaInternetDAO;
    @Autowired
    private UmowaDAO umowaDAO;
    @Autowired
    private UmowaSzczegolyDAO umowaSzczegolyDAO;
    @Autowired
    private OfertaTelefoniaDAO ofertaTelefoniaDAO;
    @Autowired
    private OfertaTelewizjaDAO ofertaTelewizjaDAO;
    @Autowired
    private KlientDAO klientDAO;
    @Autowired
    private OperatorzyDAO operatorzyDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = {"/","/index"})
    public String viewHomePage(Model model) {
        return "index";
    }
    @RequestMapping("/login")
    public String loginPage(Model model){
        return "login";
    }
    @RequestMapping("/user/main")
    public String userMainPage(Model model){
        return "/user/user_main";
    }
    @RequestMapping("/admin/main")
    public String adminMainPage(Model model){
        return "/admin/admin_main";
    }

    @RequestMapping("/new_adres")
    public String showNewAdresForm(Model model) {
        Adres adres = new Adres();
        Poczta poczta = new Poczta();
        model.addAttribute("adres", adres);
        model.addAttribute("poczta", poczta);
        return "new_adres";
    }


    @RequestMapping(value = "/save_adres", method = RequestMethod.POST)
    public String saveAdres(@ModelAttribute("adres") Adres adres, @ModelAttribute("poczta") Poczta poczta) {
        adres.setNrPoczty(pocztaDAO.save(poczta));
        adresDAO.save(adres);
        return "redirect:/";
    }

    @RequestMapping("/edit_adres/{id}")
    public ModelAndView showEditAdresForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_adres");
        AdresExtended adresExtended = adresDAO.get(id);
        Poczta poczta = new Poczta(adresExtended.getNrPoczty(), adresExtended.getKodPocztowy(), adresExtended.getPoczta());
        Adres adres = new Adres(adresExtended.getNrAdresu(), adresExtended.getMiasto(), adresExtended.getUlica(), adresExtended.getNrDomu(), adresExtended.getNrLokalu());
        mav.addObject("adres", adres);
        mav.addObject("poczta", poczta);
        return mav;
    }

    @RequestMapping(value = "/update_adres", method = RequestMethod.POST)
    public String updateAdres(@ModelAttribute("adres") Adres adres, @ModelAttribute("poczta") Poczta poczta) {
        adresDAO.update(adres, pocztaDAO.update(poczta));
        return "redirect:/";
    }

    @RequestMapping("/delete_adres/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        adresDAO.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/admin/oferty_internet")
    public String viewInternetOfferPage(Model model) {
        List<OfertaInternet> ofertaInternetList = ofertaInternetDAO.list();
        model.addAttribute("ofertaInternetList", ofertaInternetList);
        return "/admin/oferty_internet";
    }

    @RequestMapping("/admin/new_oferta_internet")
    public String ShowNewOfertaInternetForm(Model model) {
        OfertaInternet ofertaInternet = new OfertaInternet();
        model.addAttribute(ofertaInternet);
        return "/admin/new_oferta_internet";
    }

    @RequestMapping(value = "/admin/save_oferta_internet", method = RequestMethod.POST)
    public String saveOfertaInternet(@ModelAttribute("ofertaInternet") OfertaInternet ofertaInternet) {
        ofertaInternet.setNrOperatora(22);
        ofertaInternetDAO.save(ofertaInternet);
        return "redirect:/admin/oferty_internet";
    }

    @RequestMapping("/admin/edit_oferta_internet/{nrOferty}")
    public ModelAndView showEditOfertaInternetForm(@PathVariable(name = "nrOferty") int nrOferty) {
        ModelAndView mav = new ModelAndView("/admin/edit_oferta_internet");
        OfertaInternet ofertaInternet = ofertaInternetDAO.get(nrOferty);
        mav.addObject("ofertaInternet", ofertaInternet);
        return mav;
    }

    @RequestMapping(value = "/admin/update_oferta_internet", method = RequestMethod.POST)
    public String updateOfertaInternet(@ModelAttribute("ofertaInternet") OfertaInternet ofertaInternet) {
        ofertaInternetDAO.update(ofertaInternet);
        return "redirect:/admin/oferty_internet";
    }

    @RequestMapping("/admin/delete_oferta_internet/{nrOferty}")
    public String deleteOfertaInternet(@PathVariable(name = "nrOferty") int nrOferty) {
        ofertaInternetDAO.delete(nrOferty);
        return "redirect:/admin/oferty_internet";
    }

    @RequestMapping("/admin/oferty_telefonia")
    public String viewTelefoniaOfferPage(Model model) {
        List<OfertaTelefonia> ofertaTelefoniaList = ofertaTelefoniaDAO.list();
        model.addAttribute("ofertaTelefoniaList", ofertaTelefoniaList);
        return "/admin/oferty_telefonia";
    }

    @RequestMapping("/admin/new_oferta_telefonia")
    public String ShowNewOfertaTelefoniaForm(Model model) {
        OfertaTelefonia ofertaTelefonia = new OfertaTelefonia();
        model.addAttribute(ofertaTelefonia);
        return "/admin/new_oferta_telefonia";
    }

    @RequestMapping(value = "/admin/save_oferta_telefonia", method = RequestMethod.POST)
    public String saveOfertaTelefonia(@ModelAttribute("ofertaTelefonia") OfertaTelefonia ofertaTelefonia) {
        ofertaTelefonia.setNrOperatora(22);
        ofertaTelefoniaDAO.save(ofertaTelefonia);
        return "redirect:/admin/oferty_telefonia";
    }

    @RequestMapping("/admin/edit_oferta_telefonia/{nrOferty}")
    public ModelAndView showEditOfertaTelefoniaForm(@PathVariable(name = "nrOferty") int nrOferty) {
        ModelAndView mav = new ModelAndView("/admin/edit_oferta_telefonia");
        OfertaTelefonia ofertaTelefonia = ofertaTelefoniaDAO.get(nrOferty);
        mav.addObject("ofertaTelefonia", ofertaTelefonia);
        return mav;
    }

    @RequestMapping(value = "/admin/update_oferta_telefonia", method = RequestMethod.POST)
    public String updateOfertaTelefonia(@ModelAttribute("ofertaTelefonia") OfertaTelefonia ofertaTelefonia) {
        ofertaTelefoniaDAO.update(ofertaTelefonia);
        return "redirect:/admin/oferty_telefonia";
    }

    @RequestMapping("/admin/delete_oferta_telefonia/{nrOferty}")
    public String deleteOfertaTelefonia(@PathVariable(name = "nrOferty") int nrOferty) {
        ofertaTelefoniaDAO.delete(nrOferty);
        return "redirect:/admin/oferty_telefonia";
    }

    @RequestMapping("/admin/oferty_telewizja")
    public String viewTelewizjaOfferPage(Model model) {
        List<OfertaTelewizja> ofertaTelewizjaList = ofertaTelewizjaDAO.list();
        model.addAttribute("ofertaTelewizjaList", ofertaTelewizjaList);
        return "/admin/oferty_telewizja";
    }

    @RequestMapping("/admin/new_oferta_telewizja")
    public String ShowNewOfertaTelewizjaForm(Model model) {
        OfertaTelewizja ofertaTelewizja = new OfertaTelewizja();
        model.addAttribute(ofertaTelewizja);
        return "/admin/new_oferta_telewizja";
    }

    @RequestMapping(value = "/admin/save_oferta_telewizja", method = RequestMethod.POST)
    public String saveOfertaTelewizja(@ModelAttribute("ofertaTelewizja") OfertaTelewizja ofertaTelewizja) {
        ofertaTelewizja.setNrOperatora(22);
        ofertaTelewizjaDAO.save(ofertaTelewizja);
        return "redirect:/admin/oferty_telewizja";
    }

    @RequestMapping("/admin/edit_oferta_telewizja/{nrOferty}")
    public ModelAndView showEditOfertaTelewizjaForm(@PathVariable(name = "nrOferty") int nrOferty) {
        ModelAndView mav = new ModelAndView("/admin/edit_oferta_telewizja");
        OfertaTelewizja ofertaTelewizja = ofertaTelewizjaDAO.get(nrOferty);
        mav.addObject("ofertaTelewizja", ofertaTelewizja);
        return mav;
    }

    @RequestMapping(value = "/admin/update_oferta_telewizja", method = RequestMethod.POST)
    public String updateOfertaTelewizja(@ModelAttribute("ofertaTelewizja") OfertaTelewizja ofertaTelewizja) {
        ofertaTelewizjaDAO.update(ofertaTelewizja);
        return "redirect:/admin/oferty_telewizja";
    }

    @RequestMapping("/admin/delete_oferta_telewizja/{nrOferty}")
    public String deleteOfertaTelewizja(@PathVariable(name = "nrOferty") int nrOferty) {
        ofertaTelewizjaDAO.delete(nrOferty);
        return "redirect:/admin/oferty_telewizja";
    }
    @RequestMapping("/admin/umowy")
    public String displayAllUmowy(Model model){
        List<Umowa> umowaList = umowaDAO.listForAdmin();
        model.addAttribute("umowaList",umowaList);
        System.out.println(umowaList);
        return "/admin/umowy";
    }
    @RequestMapping("/admin/edit_umowa/{Nr_umowy}")
    public ModelAndView showUmowaEditForm(@PathVariable(name="Nr_umowy") String nrUmowy){
        ModelAndView mav = new ModelAndView("/admin/edit_umowy_all_form");
        Umowa umowa = umowaDAO.get(nrUmowy);
        mav.addObject(umowa);
        return mav;
    }
    @RequestMapping(value = "/admin/updateUmowa", method = RequestMethod.POST)
    public String updateUmowa(@ModelAttribute("umowa") Umowa umowa){
        umowaDAO.update(umowa);
        return "redirect:/admin/umowy";
    }
    @RequestMapping(value = "/admin/delete/{Nr_umowy}")
    public String deleteUmowa(@PathVariable(name = "Nr_umowy") String nrUmowy){
        umowaSzczegolyDAO.delete(nrUmowy);
        umowaDAO.delete(nrUmowy);
        return "redirect:/admin/umowy";
    }
    @RequestMapping(value="/admin/newUmowa")
    public String addUmowaForAdmin(Model model){
        Umowa umowa = new Umowa();
        UmowaSzczegoly umowaSzczegoly = new UmowaSzczegoly();
        model.addAttribute(umowa);
        model.addAttribute(umowaSzczegoly);
        return "/admin/new_umowa";
    }
    @RequestMapping(value="/admin/saveNewUmowa", method = RequestMethod.POST)
    public String saveNewUmowaForAdmin(@ModelAttribute("umowa") Umowa umowa, @ModelAttribute("umowaSzczegoly")UmowaSzczegoly umowaSzczegoly){
        System.out.println(umowa);
        System.out.println(umowaSzczegoly);
        try{
            ofertaInternetDAO.getOferta(Integer.parseInt(umowaSzczegoly.getNrOferty()));
            String nrUmowy = umowaDAO.save(umowa);
            umowaSzczegoly.setNrUmowy(nrUmowy);
            umowaSzczegolyDAO.save(umowaSzczegoly);
            return "redirect:/admin/umowy";
        }
        catch (EmptyResultDataAccessException e){
            return "redirect:/public/error/input_error";
        }
    }
    @RequestMapping("/user/umowy_klient")
    public String displayAllUmowyForClient(Model model){
        //get username(email) from Authentication object etc
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Umowa> umowaList = umowaDAO.listForClient(authentication.getName());

        model.addAttribute("umowaList",umowaList);
        return "/user/umowy_klient";
    }
    @RequestMapping("/user/umowa_szczegoly/{nrOferty}")
    public ModelAndView showDetails(@PathVariable(name = "nrOferty") int nrOferty){
        String type = ofertaInternetDAO.checkTypeOfOffer(nrOferty);
        System.out.println(type);
        System.out.println(nrOferty);
        if(type.equals("Internet")){
            ModelAndView mav = new ModelAndView("/user/umowa_szczegoly_internet");
            OfertaInternet ofertaInternet = ofertaInternetDAO.get(nrOferty);
            mav.addObject("ofertaInternet", ofertaInternet);
            return mav;
        }
        else if(type.equals("Telewizja")){
            ModelAndView mav = new ModelAndView("/user/umowa_szczegoly_telewizja");
            OfertaTelewizja ofertaTelewizja = ofertaTelewizjaDAO.get(nrOferty);
            mav.addObject("ofertaTelewizja", ofertaTelewizja);
            return mav;
        }
        else {
            ModelAndView mav = new ModelAndView("/user/umowa_szczegoly_telefonia");
            OfertaTelefonia ofertaTelefonia = ofertaTelefoniaDAO.get(nrOferty);
            mav.addObject("ofertaTelefonia", ofertaTelefonia);
            return mav;
        }
    }
    @RequestMapping("/admin/umowa_szczegoly/{nrOferty}")
    public ModelAndView showDetailsAdmin(@PathVariable(name = "nrOferty") int nrOferty){
        String type = ofertaInternetDAO.checkTypeOfOffer(nrOferty);
        System.out.println(type);
        System.out.println(nrOferty);
        if(type.equals("Internet")){
            ModelAndView mav = new ModelAndView("/admin/umowa_szczegoly_internet");
            OfertaInternet ofertaInternet = ofertaInternetDAO.get(nrOferty);
            mav.addObject("ofertaInternet", ofertaInternet);
            return mav;
        }
        else if(type.equals("Telewizja")){
            ModelAndView mav = new ModelAndView("/admin/umowa_szczegoly_telewizja");
            OfertaTelewizja ofertaTelewizja = ofertaTelewizjaDAO.get(nrOferty);
            mav.addObject("ofertaTelewizja", ofertaTelewizja);
            return mav;
        }
        else {
            ModelAndView mav = new ModelAndView("/admin/umowa_szczegoly_telefonia");
            OfertaTelefonia ofertaTelefonia = ofertaTelefoniaDAO.get(nrOferty);
            mav.addObject("ofertaTelefonia", ofertaTelefonia);
            return mav;
        }
    }

    @RequestMapping(value="/user/newUmowaKlient")
    public String addUmowaForClient(Model model){
        Umowa umowa = new Umowa();
        UmowaSzczegoly umowaSzczegoly = new UmowaSzczegoly();
        model.addAttribute(umowa);
        model.addAttribute(umowaSzczegoly);
        return "/user/new_umowa_klient";
    }
    @RequestMapping("/user/oferty_internet")
    public String displayInternetOffers(Model model){
        List<OfertaInternet> ofertaInternetList = ofertaInternetDAO.list();
        model.addAttribute("ofertaInternetList", ofertaInternetList);
        return "/user/oferty_internet_klient";
    }
    @RequestMapping("/user/oferty_telefonia")
    public String displayPhoneOffers(Model model){
        List<OfertaTelefonia> ofertaTelefoniaList = ofertaTelefoniaDAO.list();
        model.addAttribute("ofertaTelefoniaList", ofertaTelefoniaList);
        return "/user/oferty_telefonia_klient";
    }

    @RequestMapping("/user/oferty_telewizja")
    public String displayTvOffers(Model model){
        List<OfertaTelewizja> ofertaTelewizjaList = ofertaTelewizjaDAO.list();
        model.addAttribute("ofertaTelewizjaList", ofertaTelewizjaList);
        return "/user/oferty_telewizja_klient";
    }
    @RequestMapping(value="/user/saveNewUmowaKlient", method = RequestMethod.POST)
    public String saveNewUmowaForClient(@ModelAttribute("umowa") Umowa umowa, @ModelAttribute("umowaSzczegoly")UmowaSzczegoly umowaSzczegoly){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int nrKlienta = klientDAO.getClientIdByEmail(currentPrincipalName);
        umowa.setNrKlienta(String.valueOf(nrKlienta));
//        umowa.setNrKlienta("2"); //TODO odkomentowac jak bedzie spring security
        try{
            ofertaInternetDAO.getOferta(Integer.parseInt(umowaSzczegoly.getNrOferty())); //test if oferta exists
            String nrUmowy = umowaDAO.save(umowa);
            umowaSzczegoly.setNrUmowy(nrUmowy);
            umowaSzczegolyDAO.save(umowaSzczegoly);
            return "redirect:/user/umowy_klient";
        }
        catch (EmptyResultDataAccessException e){
            return "redirect:/public/error/input_error";
        }
    }



    @RequestMapping("/admin/klienci")
    public String viewKlienciPage(Model model) {
        List<Klient> klienciList = klientDAO.list();
        model.addAttribute("klienciList", klienciList);
        return "/admin/klienci";
    }

    @RequestMapping("/admin/new_klient")
    public String ShowNewKlientAdminForm(Model model) {
        Klient klient = new Klient();
        Adres adres = new Adres();
        Poczta poczta = new Poczta();
        model.addAttribute(klient);
        model.addAttribute(adres);
        model.addAttribute(poczta);
        return "/admin/new_klient";
    }
    @RequestMapping("/new_klient")
    public String ShowNewKlientForm(Model model) {
        Klient klient = new Klient();
        Adres adres = new Adres();
        Poczta poczta = new Poczta();
        model.addAttribute(klient);
        model.addAttribute(adres);
        model.addAttribute(poczta);
        return "/new_klient";
    }

    @RequestMapping(value = "/admin/save_klient", method = RequestMethod.POST) //TODO hashowanie hasla
    public String saveKlientAdmin(@ModelAttribute("klient") Klient klient, @ModelAttribute("adres") Adres adres, @ModelAttribute("poczta") Poczta poczta) {
        klient.setNrOperatora(22);
        klient.setHaslo(passwordEncoder.encode(klient.getHaslo()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        klient.setDataDolaczenia(dateFormat.format(date));
        adres.setNrPoczty(pocztaDAO.save(poczta));
        klient.setNrAdresu(adresDAO.save(adres));
        klient.setAktywnaUmowa("N"); //TODO 0 i 1?
        klient.setCzyAktywne("1");
        klient.setAuthority("user");
        klientDAO.save(klient);
        return "redirect:/klienci";
    }
    @RequestMapping(value = "/save_klient", method = RequestMethod.POST) //TODO hashowanie hasla
    public String registerClient(@ModelAttribute("klient") Klient klient, @ModelAttribute("adres") Adres adres, @ModelAttribute("poczta") Poczta poczta) {
        klient.setNrOperatora(22);
        klient.setHaslo(passwordEncoder.encode(klient.getHaslo()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        klient.setDataDolaczenia(dateFormat.format(date));
        adres.setNrPoczty(pocztaDAO.save(poczta));
        klient.setNrAdresu(adresDAO.save(adres));
        klient.setAktywnaUmowa("N");
        klient.setCzyAktywne("1");
        klient.setAuthority("USER");
        klientDAO.save(klient);
        return "redirect:/login";
    }

    @RequestMapping("/admin/edit_klient/{nrKlienta}") //TODO trzeba dodatkowy widok dla klienta
    public ModelAndView showEditKlientFormForAdmin(@PathVariable(name = "nrKlienta") int nrKlienta) {
        ModelAndView mav = new ModelAndView("/admin/edit_klient");
        Klient klient = klientDAO.get(nrKlienta);
        AdresExtended adresExtended = adresDAO.get(klient.getNrAdresu());
        Poczta poczta = new Poczta(adresExtended.getNrPoczty(), adresExtended.getKodPocztowy(), adresExtended.getPoczta());
        Adres adres = new Adres(adresExtended.getNrAdresu(), adresExtended.getMiasto(), adresExtended.getUlica(), adresExtended.getNrDomu(), adresExtended.getNrLokalu());
        mav.addObject("klient", klient);
        mav.addObject("adres", adres);
        mav.addObject("poczta", poczta);
        return mav;
    }
    @RequestMapping("/user/edit_klient/{nrKlienta}")
    public ModelAndView showEditKlientFormForUser(@PathVariable(name = "nrKlienta") int nrKlienta) throws org.springframework.security.access.AccessDeniedException {
        //TODO int id = getClientIdByEmail;  if id == nrKlienta: ... else throw new AccessDeniedException("access denied");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int id = klientDAO.getClientIdByEmail(authentication.getName());
        if (id != nrKlienta) {
            throw new org.springframework.security.access.AccessDeniedException("403 returned");
        }
        ModelAndView mav = new ModelAndView("/user/edit_klient");
        Klient klient = klientDAO.get(nrKlienta);
        AdresExtended adresExtended = adresDAO.get(klient.getNrAdresu());
        Poczta poczta = new Poczta(adresExtended.getNrPoczty(), adresExtended.getKodPocztowy(), adresExtended.getPoczta());
        Adres adres = new Adres(adresExtended.getNrAdresu(), adresExtended.getMiasto(), adresExtended.getUlica(), adresExtended.getNrDomu(), adresExtended.getNrLokalu());
        mav.addObject("klient", klient);
        mav.addObject("adres", adres);
        mav.addObject("poczta", poczta);
        return mav;
    }

    @RequestMapping(value = "/update_klient", method = RequestMethod.POST)
    public String updateKlient(@ModelAttribute("klient") Klient klient, @ModelAttribute("adres") Adres adres, @ModelAttribute("poczta") Poczta poczta) {
        adresDAO.update(adres, pocztaDAO.update(poczta));
        klient.setHaslo(passwordEncoder.encode(klient.getHaslo()));
        klient.setNrAdresu(adres.getNrAdresu());
        klientDAO.update(klient);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authority = authentication.getAuthorities().toArray()[0].toString();
        if(authority.equals("ADMIN")) {
            return "redirect:/admin/klienci";
        }
        else if(authority.equals("USER")){
            return "redirect:/user/main";
        }
        return null;
    }

    @RequestMapping("/admin/delete_klient/{nrKlienta}")
    public String deleteKlient(@PathVariable(name = "nrKlienta") int nrKlienta) {
        klientDAO.delete(nrKlienta);
        return "redirect:/admin/klienci";
    }
    @RequestMapping("/user/delete_klient/{nrKlienta}")
    public String safeDeleteKlient(@PathVariable(name = "nrKlienta") int nrKlienta,HttpServletRequest request) throws org.springframework.security.access.AccessDeniedException{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //klient nie moze usunac innego konta niz swoje
        int id = klientDAO.getClientIdByEmail(authentication.getName());
        if (id != nrKlienta) {
            throw new org.springframework.security.access.AccessDeniedException("403 returned");
        }
        else {
            klientDAO.delete(nrKlienta);
            try {
                request.logout();
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return "redirect:/index";
        }
    }
    @RequestMapping("/user/about_me")
    public String getInfoOfClient(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int id = klientDAO.getClientIdByEmail(authentication.getName());
        Klient klient = klientDAO.get(id);
        model.addAttribute("klient", klient);
        return "/user/klient_info";
    }
    @RequestMapping("/admin/about_me")
    public String getInfoOfClientAdmin(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int id = klientDAO.getClientIdByEmail(authentication.getName());
        Klient klient = klientDAO.get(id);
        model.addAttribute("klient", klient);
        return "/admin/klient_info";
    }
}
