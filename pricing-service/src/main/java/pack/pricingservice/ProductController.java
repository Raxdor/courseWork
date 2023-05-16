package pack.pricingservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController{

    List<Price> priceList = new ArrayList<Price>();

    @GetMapping("/price/{productid}")
    public Price getPriceDetails(@PathVariable Long productid) {
        Price price = getPriceInfo(productid);
        return price;
    }

    private Price getPriceInfo(Long productid) {
        populatePriceList();
        for(Price p: priceList) {
            if(productid.equals(p.getProductID())) {
                return p;
            }
        }
        return null;
    }

    private void populatePriceList() {
        priceList.add(new Price(201L, 101l, 1999, 999));
        priceList.add(new Price(202L, 102l, 199, 19));
        priceList.add(new Price(203L, 103l, 1222, 600));
    }
}
