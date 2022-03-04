package com.poc.recommendationservice.service;

import com.poc.recommendationservice.model.Recommendation;

import java.util.List;

public interface RecommendationService {
    Recommendation saveRecommendation(Recommendation recommendation);
    List<Recommendation> getAllRecommendations();
    Recommendation getRecommendationById(Long id);
    Recommendation updateRecommendation(Recommendation recommendation, long id_to_change);
    void deleteRecommendation(long id_to_delete);
}
