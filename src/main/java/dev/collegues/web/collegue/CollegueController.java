package dev.collegues.web.collegue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entity.Collegue;
import dev.collegues.web.services.ServiceCollegue;

@RestController
@RequestMapping("collegues")
public class CollegueController {

	private ServiceCollegue serviceCollegue;

	public CollegueController(ServiceCollegue serviceCollegue) {
		this.serviceCollegue = serviceCollegue;
	}

	@GetMapping
	public List<String> ListHotels(@RequestParam Integer nom) {

		List<String> listMatricules = new ArrayList<>();
		List<Collegue> listCollegue = serviceCollegue.findByName(nom);
		for (Collegue c : listCollegue) {
			listMatricules.add(c.getMatricule());
		}
		return listMatricules;

	}

}
