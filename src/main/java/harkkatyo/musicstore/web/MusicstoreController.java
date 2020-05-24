package harkkatyo.musicstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import harkkatyo.musicstore.domain.LP;
import harkkatyo.musicstore.domain.LPRepository;
import harkkatyo.musicstore.domain.GenreRepository;

@Controller
public class MusicstoreController {
	@Autowired
	LPRepository lrepo;
	@Autowired
	GenreRepository grepo;
	
	@GetMapping("/*")
	public String showMainPage() {
		return "frontpage";
	}

	@GetMapping("/index")
	public String showIndexPage() {
		return "frontpage";
	}
	 @GetMapping(value="/musiclist")
	    public String studentList(Model model) {	
	        model.addAttribute("LPs", lrepo.findAll());
	        return "musiclist";
	    }
	 @GetMapping(value="addLP")
	 	public String AddLp(Model model) {
			model.addAttribute("newLP", new LP());
			model.addAttribute("genres", grepo.findAll());
		 return "addLP";
	 }
	@PostMapping("saveLP")
		public String saveLP(LP lp) {
		lrepo.save(lp);
		return "redirect:musiclist";
		
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteLp(@PathVariable("id") Long id) {
		lrepo.deleteById(id);
        return "redirect:../musiclist";
	}
	
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public String editLp(@PathVariable("id") Long id, Model model){
		model.addAttribute("editLp", lrepo.findById(id).get());
		model.addAttribute("genres", grepo.findAll());
		return "editLP";
	}
	 
	 @RequestMapping(value = "/lps", method = RequestMethod.GET)
	 	 public @ResponseBody List<LP> lpsRest() {
		 return (List<LP>) lrepo.findAll();
		 
	 }
	 @RequestMapping(value="/lps", method =RequestMethod.POST)
	     LP newQuestion(@RequestBody LP newLp, Model model) {
	   	model.addAttribute("lp", new LP());
	   	model.addAttribute("genre", grepo.findAll());
	   		return lrepo.save(newLp);
     }
}
