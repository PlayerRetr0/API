package br.com.api.aula1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class AulaController {
	@GetMapping
	public String retorno() {
		return "olha eu aqui";
	}
}
