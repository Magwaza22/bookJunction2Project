package za.ac.cput.service;

import za.ac.cput.domain.SellerRating;

import java.util.List;

public interface ISellerRatingService extends IService <SellerRating,Integer> {

    List<SellerRating> getAll();
}
