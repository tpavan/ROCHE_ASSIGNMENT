package tests;

import domain.Product;
import flows.FlowsInit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProduct implements FlowsInit {

    private Product product;

    @Test(description = "Search the product and add it into Cart")
    public void searchProductAndAdditIntoCart(){
        searchProductFlows.searchProductAndAddIntoWishList("Tshirts For Men");
        searchProductFlows.addProductFromWishListToCart();
    }

    @Test(description = "Search the product and add it into Cart")
    public void searchProductAndAdditIntoCartDtlsPage(){
        product = Product.setProduct();
        searchProductFlows.searchProduct(product.getProductCategory());
        searchProductFlows.addProductIntoWishListFromProductDtlsPage(product.getProductNumber());
        searchProductFlows.addProductFromWishListToCart();
    }

    @Test(description = "Validate that added product can be removed from wishlist")
    public void validateProductCanBeRemovedFromWishList(){
        product = Product.setProduct();
        searchProductFlows.searchProduct(product.getProductCategory());
        searchProductFlows.addProductIntoWishListFromProductDtlsPage(product.getProductNumber());
        searchProductFlows.addProductFromWishListToCart();
    }

    @Test(description = "Validate that product can be directly able to add into Cart")
    public void validateProductCanBeAddedToBagDirectly(){
        product = Product.setProduct();
        searchProductFlows.searchProduct(product.getProductCategory());
        searchProductFlows.addProductIntoWishListFromProductDtlsPage(product.getProductNumber());
        Assert.assertTrue(searchProductFlows.addProductIntoCart(),"Failed to add product into Cart");
    }
}
