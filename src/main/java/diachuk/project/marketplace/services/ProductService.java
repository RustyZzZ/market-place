package diachuk.project.marketplace.services;

import diachuk.project.marketplace.entity.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
	@PostConstruct
	public void method() {
		var product = new Product();
		product.setCurrency(Currency.getInstance("UAH"));
		product.setPrice(BigDecimal.valueOf(191));

		createProduct(product);
	}


	private final CurrencyService currencyService;

	public Product createProduct(Product product) {

		var currencyCode = product.getCurrency().getCurrencyCode();
		var rate = currencyService.getCurrency().getRates().get(currencyCode);
		product.setPrice(product.getPrice().divide(rate, RoundingMode.HALF_UP));
		product.setCurrency(Currency.getInstance("EUR"));
		return product;
	}

}
