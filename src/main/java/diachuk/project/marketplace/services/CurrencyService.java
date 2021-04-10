package diachuk.project.marketplace.services;

import diachuk.project.marketplace.clients.CurrencyClient;
import diachuk.project.marketplace.dto.CurrencyDto;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {
	private final CurrencyClient currencyClient;
	@Value("${fixer.access.key}")
	private String accessKey;


	public CurrencyDto getCurrency(){
		return currencyClient.getCurrencies(accessKey);
	}

}
