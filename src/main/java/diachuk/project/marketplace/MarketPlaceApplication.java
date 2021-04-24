package diachuk.project.marketplace;

import diachuk.project.marketplace.services.CurrencyService;
import java.util.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class MarketPlaceApplication implements CommandLineRunner {

	@Autowired
	private CurrencyService currencyService;
	@Autowired
	private CacheManager cacheManager;

	public static void main(String[] args) {
		SpringApplication.run(MarketPlaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();
		currencyService.getCurrency();

	}
}
