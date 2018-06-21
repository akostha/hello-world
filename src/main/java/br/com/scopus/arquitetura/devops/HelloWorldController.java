package br.com.scopus.arquitetura.devops;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.scopus.arquitetura.devops.model.Mensagem;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

	private final AtomicLong contador = new AtomicLong();
	private final String[] blackList = new String[] {"Vader","Koopa","Bowser", "Satangos","Adolf","Apoliana"};
	

	public HelloWorldController() {
		Arrays.sort(blackList);
	}
	
	@RequestMapping("/")
	@ResponseBody
	public Mensagem index() throws InterruptedException {
		Thread.sleep(1000);
		return new Mensagem(contador.incrementAndGet(), "Hello World!");
	}

	@RequestMapping("/hello")
	@ResponseBody
	public Mensagem hello(@RequestParam(name="nome", required=false, defaultValue="Gasper") String nome) {
		int busca = Arrays.binarySearch(blackList, nome);
		if(busca < 0) {
			return new Mensagem(contador.incrementAndGet(), String.format("Hello, %s!", nome));
		}else {
			throw new IllegalArgumentException("Nome não permitido!");
		}
	}

}
