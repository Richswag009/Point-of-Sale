package com.richcodes.POS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(ShopService shopService) {
//		return runner -> {
//			addNewShop(shopService);
//		};
//	}

//	private void addNewShop(ShopService shopService) {
//		Shop shop = new Shop("Shop2","Agip Junction Benin","123424224","Open");
//		shopService.addShop(shop);
//	}


}
