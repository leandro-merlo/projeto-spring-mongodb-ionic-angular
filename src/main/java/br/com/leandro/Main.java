package br.com.leandro;

import br.com.leandro.controllers.UsuarioController;
import br.com.leandro.repositories.UsuarioRepository;
import br.com.leandro.services.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackageClasses = {UsuarioService.class, UsuarioRepository.class, UsuarioController.class})
@EnableAutoConfiguration
@EnableWebMvc
@SpringBootApplication
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SpringApplication.run(Main.class, args);
    }
}
