package diachuk.project.marketplace.services;

import diachuk.project.marketplace.clients.CurrencyClient;
import diachuk.project.marketplace.dto.CurrencyDto;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {
	private final CurrencyClient currencyClient;
	@Value("${fixer.access.key}")
	private String accessKey;

	@Cacheable(value = "currencies")
	public CurrencyDto getCurrency(){
		System.out.println("NotCached");
		return currencyClient.getCurrencies(accessKey);
	}
	@CacheEvict(value = "currencies")
	public void evictCache(){

	}

}
