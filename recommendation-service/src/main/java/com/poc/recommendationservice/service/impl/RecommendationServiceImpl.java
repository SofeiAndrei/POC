package com.poc.recommendationservice.service.impl;

import com.poc.recommendationservice.exception.NotFoundException;
import com.poc.recommendationservice.model.Recommendation;
import com.poc.recommendationservice.repository.RecommendationRepository;
import com.poc.recommendationservice.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    private RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationServiceImpl(RecommendationRepository recommendationRepository) {
        super();
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public Recommendation saveRecommendation(Recommendation recommendation) {
        System.out.println("Salut din Service");
        return recommendationRepository.save(recommendation);
    }

    @Override
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    @Override
    public Recommendation getRecommendationById(Long id) {
        return recommendationRepository.findById(id).orElseThrow( ()->new NotFoundException("Recommendation", "Id", id));
    }
    @Override
    public Recommendation updateRecommendation(Recommendation recommendation, long id_to_change) {
        Recommendation existing_recommendation = recommendationRepository.findById(id_to_change).orElseThrow( ()->new NotFoundException("Recommendation", "Id", id_to_change));
        existing_recommendation.setRate(recommendation.getRate());
        existing_recommendation.setContent(recommendation.getContent());
        existing_recommendation.setRecommendedId(recommendation.getRecommendedId());
        recommendationRepository.save(existing_recommendation);
        return existing_recommendation;
    }

    @Override
    public void deleteRecommendation(long id_to_delete) {
        recommendationRepository.findById(id_to_delete).orElseThrow( ()->new NotFoundException("Recommendation", "Id", id_to_delete));
        recommendationRepository.deleteById(id_to_delete);
    }
}
