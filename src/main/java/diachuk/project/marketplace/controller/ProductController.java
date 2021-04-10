package diachuk.project.marketplace.controller;

import diachuk.project.marketplace.dto.CurrencyDto;
import diachuk.project.marketplace.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final CurrencyService currencyService;
	@GetMapping("/currencies")
	@PreAuthorize("isAnonymous()")
	public CurrencyDto getCurrencies(){
		return currencyService.getCurrency();
	}
}
