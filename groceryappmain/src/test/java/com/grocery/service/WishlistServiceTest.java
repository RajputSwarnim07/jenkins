//package com.grocery.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.grocery.exception.ProductAlreadyExistsException;
//import com.grocery.exception.ProductNotFoundException;
//import com.grocery.model.ProductModel;
//import com.grocery.model.WishlistModel;
//import com.grocery.repository.ProductRepository;
//import com.grocery.repository.WishlistRepository;
//
//
//
//public class WishlistServiceTest {
//
//
//
//@Mock
//
//private WishlistRepository wishRepo;
//
//
//
//@Mock
//
//private ProductRepository prodRepo;
//
//
//
//@InjectMocks
//
//private WishlistServiceImpl wishlistService;
//
//
//
//@BeforeEach
//
//public void setUp() throws Exception {
//
//MockitoAnnotations.initMocks(this);
//
//}
//
//
//
//@org.junit.jupiter.api.Test
//
//public void testViewWishlist() {
//
//// Arrange
//
//WishlistModel wishlist = new WishlistModel();
//
//wishlist.setWishlistId(1);
//
//wishlist.setQuantity(2);
//
//List<ProductModel> products = List.of(new ProductModel(), new ProductModel());
//
//wishlist.setProducts(products);
//
//
//
//when(wishRepo.findById(1)).thenReturn(Optional.of(wishlist));
//
//
//
//// Act
//
//WishlistModel result = wishlistService.viewWishlist(1);
//
//
//
//// Assert
//
//assertEquals(wishlist, result);
//
//}
//
//
//
//@Test
//
//public void testAddProductToWishlist() throws ProductNotFoundException, ProductAlreadyExistsException {
//
//// Arrange
//
//WishlistModel wishlist = new WishlistModel();
//
//wishlist.setWishlistId(1);
//
//wishlist.setQuantity(0);
//
//List<ProductModel> products = List.of();
//
//wishlist.setProducts(products);
//
// 
//
//when(wishRepo.findById(1)).thenReturn(Optional.of(wishlist));
//
//when(prodRepo.findById(1)).thenReturn(Optional.of(new ProductModel()));
//
//when(wishRepo.save(wishlist)).thenReturn(wishlist);
//
//
//
//// Act
//
//List<ProductModel> result = wishlistService.addProductToWishlist(1, 1);
//
//
//
//// Assert
//
//assertEquals(1, result.size());
//
//assertEquals(1, wishlist.getQuantity());
//
//assertTrue(wishlist.getProducts().contains(new ProductModel()));
//
//}
//
//
//
//@Test//(expected = ProductNotFoundException.class)
//
//public void testAddProductToWishlistWithNonExistingProduct() throws ProductNotFoundException, ProductAlreadyExistsException {
//
//// Arrange
//
//when(wishRepo.findById(1)).thenReturn(Optional.of(new WishlistModel()));
//
//when(prodRepo.findById(1)).thenReturn(Optional.empty());
//
//
//
//// Act
//
//Assertions.assertThrows( ProductNotFoundException.class, ()->wishlistService.addProductToWishlist(1, 1));
//
//}
//
//
//
//@Test//(expected = ProductAlreadyExistsException.class)
//
//public void testAddProductToWishlistWithAlreadyExistingProduct() throws ProductNotFoundException, ProductAlreadyExistsException {
//
//// Arrange
//
//WishlistModel wishlist = new WishlistModel();
//
//wishlist.setWishlistId(1);
//
//List<ProductModel> products = List.of(new ProductModel());
//
//wishlist.setProducts(products);
//
//
//
//when(wishRepo.findById(1)).thenReturn(Optional.of(wishlist));
//
//when(prodRepo.findById(1)).thenReturn(Optional.of(new ProductModel()));
//
//
//
//// Act
//
//Assertions.assertThrows( ProductNotFoundException.class, ()->wishlistService.addProductToWishlist(1, 1));
//
//}
//
//
//
//@Test
//
//public void testDeleteProductFromWishlist() throws ProductNotFoundException {
//
//// Arrange
//
//ProductModel product1 = new ProductModel();
//
//product1.setProductId(1);
//
//ProductModel product2 = new ProductModel();
//
//product2.setProductId(2);
//
//WishlistModel wishlist = new WishlistModel();
//
//wishlist.setWishlistId(1);
//
//wishlist.setQuantity(2);
//
//List<ProductModel> products = List.of(product1, product2);
//
//wishlist.setProducts(products);
//
//when(wishRepo.findById(1)).thenReturn(Optional.of(wishlist));
//
//when(prodRepo.findById(2)).thenReturn(Optional.of(product2));
//
//when(wishRepo.save(wishlist)).thenReturn(wishlist);
//
//
//
//// Act
//
//List<ProductModel> result = wishlistService.deleteProductFromWishlist(1, 2);
//
//
//// Assert
//
//assertEquals(1, result.size());
//
//assertEquals(1, wishlist.getQuantity());
//
//assertTrue(wishlist.getProducts().contains(product1));
//
//assertFalse(wishlist.getProducts().contains(product2));
//
//}
//
//@Test()//(expected = ProductNotFoundException.class)
//
//public void testDeleteNonExistingProductFromWishlist() throws ProductNotFoundException {
//
//// Arrange
//
//when(wishRepo.findById(1)).thenReturn(Optional.of(new WishlistModel()));
//
//when(prodRepo.findById(1)).thenReturn(Optional.empty());
//
//
//
//// Act
//
//Assertions.assertThrows( ProductNotFoundException.class, ()->wishlistService.deleteProductFromWishlist(1, 1));
//
//}
//
//
//
//@Test
//
//public void testGetAllWishProducts() {
//
//// Arrange
//
//WishlistModel wishlist = new WishlistModel();
//
//wishlist.setWishlistId(1);
//
//wishlist.setQuantity(2);
//
//List<ProductModel> products = List.of(new ProductModel(), new ProductModel());
//
//wishlist.setProducts(products);
//
//
//
//when(wishRepo.findById(1)).thenReturn(Optional.of(wishlist));
//
//
//
//// Act
//
//List<ProductModel> result = wishlistService.getAllWishProducts(1);
//
//
//
//// Assert
//
//assertEquals(products, result);
//
//}
//
//}