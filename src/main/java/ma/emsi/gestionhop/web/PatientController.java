package ma.emsi.gestionhop.web;

import lombok.AllArgsConstructor;
import ma.emsi.gestionhop.entities.Patient;
import ma.emsi.gestionhop.repository.PatientRepos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepos patR;

    @GetMapping("/index")
    //on doit creer une vue
    public String index(Model model, @RequestParam(name="page",defaultValue = "0")int page,//page prend le parametre noté p
                        @RequestParam(name="size",defaultValue = "2")int size ,
                        @RequestParam(name = "keyword",defaultValue = "")String kw) //pas forcement de faire ?page=0&size=2
    {

        //page pour la pagination
        //Page<Patient> pageP=patR.findAll(PageRequest.of(page,size));
        Page<Patient> pageP=patR.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("ListePatients",pageP.getContent());
        model.addAttribute("pages", new int[pageP.getTotalPages()]);
        model.addAttribute("pageCurrent",page);
        model.addAttribute("keyword",kw);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patR.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
}
