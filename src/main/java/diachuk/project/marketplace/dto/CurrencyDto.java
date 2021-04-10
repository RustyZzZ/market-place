package diachuk.project.marketplace.dto;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;

@Data
public class CurrencyDto {
	private String base;
	private Map<String, BigDecimal> rates;
}
