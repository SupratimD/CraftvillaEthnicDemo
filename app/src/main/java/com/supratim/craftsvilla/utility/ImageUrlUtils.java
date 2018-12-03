package com.supratim.craftsvilla.utility;

import java.util.ArrayList;

/**
 * Created by supratim on 2015/6/24.
 */
public class ImageUrlUtils {
    static ArrayList<String> wishlistImageUri = new ArrayList<>();
    static ArrayList<String> cartListImageUri = new ArrayList<>();



    public static String[] getOffersUrls() {
        String[] urls = new String[]{
                "https://static.pexels.com/photos/169047/pexels-photo-169047-medium.jpeg",
                "https://static.pexels.com/photos/1702/bow-tie-businessman-fashion-man-medium.jpg",
                "https://static.pexels.com/photos/193355/pexels-photo-193355-medium.jpeg",
                "https://static.pexels.com/photos/213384/pexels-photo-213384-medium.jpeg",
                "https://static.pexels.com/photos/67442/pexels-photo-67442-medium.jpeg",
                "https://static.pexels.com/photos/1543/landscape-nature-man-person-medium.jpg",
                "https://static.pexels.com/photos/211048/pexels-photo-211048-medium.jpeg",
        };
        return urls;
    }



    // Methods for Wishlist
    public void addWishlistImageUri(String wishlistImageUri) {
        this.wishlistImageUri.add(0,wishlistImageUri);
    }

    public void removeWishlistImageUri(int position) {
        this.wishlistImageUri.remove(position);
    }

    public ArrayList<String> getWishlistImageUri(){ return this.wishlistImageUri; }

    // Methods for Cart
    public void addCartListImageUri(String wishlistImageUri) {
        this.cartListImageUri.add(0,wishlistImageUri);
    }

    public void removeCartListImageUri(int position) {
        this.cartListImageUri.remove(position);
    }

    public ArrayList<String> getCartListImageUri(){ return this.cartListImageUri; }
}
