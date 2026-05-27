package com.resumeanalyzer.backend.controller;

import com.resumeanalyzer.backend.dto.JobMatchRequest;
import com.resumeanalyzer.backend.dto.JobMatchResponse;
import com.resumeanalyzer.backend.dto.ResumeAnalysisResponse;
import com.resumeanalyzer.backend.entity.ResumeAnalysis;
import com.resumeanalyzer.backend.service.AnalysisService;
import com.resumeanalyzer.backend.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AiController {

    private final GeminiService geminiService;
    private final AnalysisService analysisService;

    @PostMapping("/analyze")
    public ResumeAnalysis analyzeResume(
            @RequestBody String resumeText,
            Authentication authentication
    ) {

        String email = authentication.getName();

        ResumeAnalysisResponse response =
                geminiService.analyzeResume(resumeText);

        return analysisService.saveAnalysis(
                response,
                email
        );
    }

    @PostMapping("/job-match")
    public JobMatchResponse jobMatch(
            @RequestBody JobMatchRequest request
    ) {

        return geminiService.matchJobDescription(
                request.getResumeText(),
                request.getJobDescription()
        );
    }

    @GetMapping("/history")
    public List<ResumeAnalysis> getHistory(
            Authentication authentication
    ) {

        String email = authentication.getName();

        return analysisService.getUserAnalysis(email);
    }
}