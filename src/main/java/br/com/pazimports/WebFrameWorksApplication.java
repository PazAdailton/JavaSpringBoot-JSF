package br.com.pazimports;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class} )
public class WebFrameWorksApplication extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebFrameWorksApplication.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(WebFrameWorksApplication.class, args);
	}
	
	
	

}
