package com.poc.recommendationservice.controller;

import com.poc.recommendationservice.model.Recommendation;
import com.poc.recommendationservice.service.RecommendationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {
    private RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        super();
        this.recommendationService = recommendationService;
    }
    @PostMapping("/save")
    public ResponseEntity<Recommendation> saveRecommendation(@RequestBody Recommendation recommendation){
        System.out.println("Salut");
        return new ResponseEntity<Recommendation>(recommendationService.saveRecommendation(recommendation), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Recommendation> getAllRecommendations(){
        return recommendationService.getAllRecommendations();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Recommendation> getRecommendationById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<Recommendation>(recommendationService.getRecommendationById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Recommendation> updateRecommendation(@RequestBody Recommendation recommendation,@PathVariable(name = "id") Long id_to_change){
        return new ResponseEntity<Recommendation>(recommendationService.updateRecommendation(recommendation, id_to_change), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecommendation(@PathVariable(name = "id")Long id_to_delete){
        recommendationService.deleteRecommendation(id_to_delete);
        return new ResponseEntity<String>("Recommendation deleted successfully!", HttpStatus.OK);
    }
}
