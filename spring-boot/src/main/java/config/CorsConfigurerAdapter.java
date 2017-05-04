package config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Component
public class CorsConfigurerAdapter extends WebMvcConfigurerAdapter{

	public void addCORSMappings(CorsRegistry corsRegistry){
		System.out.println(corsRegistry);
		corsRegistry.addMapping("/rest/*").allowedOrigins("*");
	}
}
