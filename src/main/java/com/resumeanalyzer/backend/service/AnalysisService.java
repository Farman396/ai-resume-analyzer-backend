package com.resumeanalyzer.backend.service;

import com.resumeanalyzer.backend.dto.ResumeAnalysisResponse;
import com.resumeanalyzer.backend.entity.ResumeAnalysis;
import com.resumeanalyzer.backend.repository.ResumeAnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final ResumeAnalysisRepository analysisRepository;

    public ResumeAnalysis saveAnalysis(
            ResumeAnalysisResponse response,
            String email
    ) {

        ResumeAnalysis analysis = ResumeAnalysis.builder()
                .atsScore(response.getAtsScore())
                .technicalSkills(
                        String.join(
                                ", ",
                                response.getTechnicalSkills()
                        )
                )
                .missingSkills(
                        String.join(
                                ", ",
                                response.getMissingSkills()
                        )
                )
                .suggestions(
                        String.join(
                                ", ",
                                response.getSuggestions()
                        )
                )
                .professionalSummary(
                        response.getProfessionalSummary()
                )
                .analyzedBy(email)
                .build();

        return analysisRepository.save(analysis);
    }

    public List<ResumeAnalysis> getUserAnalysis(
            String email
    ) {

        return analysisRepository.findByAnalyzedBy(email);
    }
}