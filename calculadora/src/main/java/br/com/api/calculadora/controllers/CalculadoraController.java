package br.com.api.calculadora.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.calculadora.models.Parametros;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	//PathVariable
	@GetMapping ("/somaPV/{valor}/{valor1}")
	public Integer somarPV(@PathVariable Integer valor, @PathVariable Integer valor1) {
		return valor+valor1;
	}
	@GetMapping ("/subtraiPV/{valor}/{valor1}")
	public Integer subtraiPV(@PathVariable Integer valor, @PathVariable Integer valor1) {
		return valor-valor1;
	}
	@GetMapping ("/multPV/{valor}/{valor1}")
	public Integer multPV(@PathVariable Integer valor, @PathVariable Integer valor1) {
		return valor*valor1;
	}
	@GetMapping ("/divPV/{valor}/{valor1}")
	public Integer divPV(@PathVariable Integer valor, @PathVariable Integer valor1) {
		return valor/valor1;
	}
	//RequestParam
	@GetMapping ("/somaRP")
	public Integer somarRP(@RequestParam (required=false) Integer valor, Integer valor1) {
		return valor+valor1;
	}
	@GetMapping ("/subtraiRP")
	public Integer subtrairRP(@RequestParam (required=false) Integer valor, Integer valor1) {
		return valor-valor1;
	}
	@GetMapping ("/multiRP")
	public Integer multiRP(@RequestParam (required=false) Integer valor, Integer valor1) {
		return valor*valor1;
	}
	@GetMapping ("/divRP")
	public Integer divRP(@RequestParam (required=false) Integer valor, Integer valor1) {
		return valor/valor1;
	}
	//RequestBody
	@GetMapping ("/somaRB")
	public Integer somarRB(@RequestBody Parametros valores) {
		return valores.getValor()+valores.getValor1();
	}
	@GetMapping ("/subtraiRB")
	public Integer subtraiRB(@RequestBody Parametros valores) {
		return valores.getValor()-valores.getValor1();
	}
	@GetMapping ("/multiRB")
	public Integer multiRB(@RequestBody Parametros valores) {
		return valores.getValor()*valores.getValor1();
	}
	@GetMapping ("/divRB")
	public Integer divRB(@RequestBody Parametros valores) {
		return valores.getValor()/valores.getValor1();
	}
}
