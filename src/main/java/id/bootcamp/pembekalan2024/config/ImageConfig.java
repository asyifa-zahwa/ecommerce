package id.bootcamp.pembekalan2024.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//Path lokasi folder uploads
		String path = new FileSystemResource("").getFile().getAbsolutePath();
		path +="\\uploads\\";
		
		//tambah fungsi jika buka localhost/images/....
		//nanti membuka file dari folder uploads
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///" + path);
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}
