package com.pricing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import com.pricing.calculator.PricingCalculator;
import com.pricing.model.SupplierProduct;
import com.pricing.model.enums.ProductStatus;
import com.pricing.presentation.uibean.RequestPrice;
import com.pricing.services.SupplierProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application.properties")
public class PricingControllerTest 
{
    
    @Test
    @DisplayName("Test état « Comme neuf » et stratégie x = 1 centimes et y = 200 centimes et les bornes de prix du vendeur pour cet article sont de 15 à 29,50€")
    public void calculatePrice_withStatusCommeNeuf() 
    {
    	RequestPrice request = new RequestPrice(2L, 0.01, 2.0, 15.0, 29.5, "Comme neuf");
    	
    	double suggestedPrice = PricingCalculator.calculatePrice(this.filterByStatus(ProductStatus.COMME_NEUF),request, ProductStatus.COMME_NEUF.ordinal());
    			
    	assertEquals(28.99, suggestedPrice);
    }
    
    @Test
    @DisplayName("Test état « Très bon état » et stratégie x = 1 centimes et y = 200 centimes et les bornes de prix du vendeur pour cet article sont de 15 à 29,50€")
    public void calculatePrice_withStatusTresBonEtat() 
    {
    	RequestPrice request = new RequestPrice(2L, 0.01, 2.0, 15.0, 29.5, "Très bon état");
    	double suggestedPrice = PricingCalculator.calculatePrice(this.filterByStatus(ProductStatus.TRES_BON_ETAT),request, ProductStatus.TRES_BON_ETAT.ordinal());
    			
    	assertEquals(19.99, suggestedPrice);
    }
    
    @Test
    @DisplayName("Test avec stratégie x = 1 centimes et y = 200 centimes et les bornes de prix du vendeur pour cet article sont de 15 à 29,50€")
    public void calculatePrice_withoutStatus() 
    {
    	RequestPrice request = new RequestPrice(2L, 0.01, 2.0, 15.0, 29.5, null);
    	ProductStatus[] productStatuses = ProductStatus.values();
		
		for (ProductStatus status : productStatuses)
		{
			double suggestedPrice = PricingCalculator.calculatePrice(this.filterByStatus(status),request, status.ordinal());
			
			switch(status) 
			{
				case ETAT_MOYEN:
					assertEquals(15, suggestedPrice);
					break;
				case BON_ETAT:
					assertEquals(18.0, suggestedPrice);
					break;
				case TRES_BON_ETAT:
					assertEquals(19.99, suggestedPrice);
					break;
				case COMME_NEUF:
					assertEquals(28.99, suggestedPrice);
					break;
				case NEUF:
					assertEquals(29.5, suggestedPrice);
					break;
			}
		}
    }
    
    private List<SupplierProduct> createData ()
    {
    	List<SupplierProduct> supplierProducts = new ArrayList<>();
    	
    	SupplierProduct product = new SupplierProduct();
    	product.setPrice(14.10);
    	product.setStatus(ProductStatus.ETAT_MOYEN);
    	supplierProducts.add(product);
    	product = new SupplierProduct();
    	product.setPrice(16.20);
    	product.setStatus(ProductStatus.ETAT_MOYEN);
    	supplierProducts.add(product);
    	product = new SupplierProduct();
    	product.setPrice(20.0);
    	product.setStatus(ProductStatus.TRES_BON_ETAT);
    	supplierProducts.add(product);
    	product = new SupplierProduct();
    	product.setPrice(21.5);
    	product.setStatus(ProductStatus.TRES_BON_ETAT);
    	supplierProducts.add(product);
    	product = new SupplierProduct();
    	product.setPrice(29.0);
    	product.setStatus(ProductStatus.COMME_NEUF);
    	supplierProducts.add(product);
    	product = new SupplierProduct();
    	product.setPrice(30.99);
    	product.setStatus(ProductStatus.NEUF);
    	supplierProducts.add(product);
    	
    	return supplierProducts;
    }
    
    private List<SupplierProduct> filterByStatus (ProductStatus status)
    {
    	return this.createData().stream().filter(supplierProduct -> supplierProduct.getStatus().getOrder() >= status.getOrder()).collect(Collectors.toList());
    }
}
