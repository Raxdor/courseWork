package pack.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

    List<ProductInfo> productLIst = new ArrayList<ProductInfo>();

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/product/details/{productid}")
    public Product getProductDetails(@PathVariable Long productid){
        //Get Name and Desc from product-service
        ProductInfo productInfo = getProductInfo(productid);
        //Get Price from pricing-service
        Price price = restTemplate.getForObject("http://localhost:8002/price/"+productid, Price.class);
        //Get Stock Avail from inventory-service
        Inventory inventory = restTemplate.getForObject("http://localhost:8003/inventory/"+productid, Inventory.class);
        return new Product(productInfo.getProductID(), productInfo.getProductName(),
                productInfo.getProductDesc(), price.getOriginalPrice(), inventory.getInStock());
    }

    private ProductInfo getProductInfo(Long productid){
        populateProductList();
        for(ProductInfo p: productList){
            if(productid.equals(p.getProductID())){
                return p;
            }
        }
        return null;
    }

    private void populateProductList(){
        productLIst.add(new ProductInfo(101L, "Iphone", "Iphone10"));
        productLIst.add(new ProductInfo(102L, "Book", "Book1"));
        productLIst.add(new ProductInfo(103L, "Washing MC", "Washing machine8"));
    }


