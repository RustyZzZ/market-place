package diachuk.project.marketplace.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;

@Data
public class CurrencyDto implements Serializable {
	private String base;
	private Map<String, BigDecimal> rates;
}
