package com.resumeanalyzer.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resumeanalyzer.backend.dto.JobMatchResponse;
import com.resumeanalyzer.backend.dto.ResumeAnalysisResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public ResumeAnalysisResponse analyzeResume(String resumeText) {

        try {

            String prompt = """
                    Analyze this resume and return ONLY valid JSON.
                    
                    JSON format:
                    
                    {
                      "atsScore": 85,
                      "technicalSkills": [],
                      "missingSkills": [],
                      "suggestions": [],
                      "professionalSummary": ""
                    }
                    
                    Resume:
                    """ + resumeText;

            String url =
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                            + apiKey;

            String requestJson = """
                    {
                      "contents": [
                        {
                          "parts": [
                            {
                              "text": %s
                            }
                          ]
                        }
                      ]
                    }
                    """.formatted(
                    new ObjectMapper().writeValueAsString(prompt)
            );

            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity =
                    new HttpEntity<>(requestJson, headers);

            ResponseEntity<String> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.POST,
                            entity,
                            String.class
                    );

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root =
                    mapper.readTree(response.getBody());

            String aiText =
                    root.get("candidates")
                            .get(0)
                            .get("content")
                            .get("parts")
                            .get(0)
                            .get("text")
                            .asText();

            // Clean markdown json
            aiText = aiText.replace("```json", "")
                    .replace("```", "")
                    .trim();

            return mapper.readValue(
                    aiText,
                    ResumeAnalysisResponse.class
            );

        } catch (Exception e) {

            return ResumeAnalysisResponse.builder()
                    .atsScore(0)
                    .professionalSummary("Error: " + e.getMessage())
                    .build();
        }
    }

    public JobMatchResponse matchJobDescription(
            String resumeText,
            String jobDescription) {

        try {

            String prompt = """
                Analyze the resume against the job description.
                
                Return ONLY valid JSON.
                
                JSON format:
                
                {
                  "matchPercentage": 80,
                  "matchingSkills": [],
                  "missingSkills": [],
                  "suggestions": [],
                  "interviewQuestions": []
                }
                
                Resume:
                """ + resumeText +
                    """
                    
                    
                    Job Description:
                    """ + jobDescription;

            String url =
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                            + apiKey;

            String requestJson = """
                {
                  "contents": [
                    {
                      "parts": [
                        {
                          "text": %s
                        }
                      ]
                    }
                  ]
                }
                """.formatted(
                    new ObjectMapper().writeValueAsString(prompt)
            );

            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity =
                    new HttpEntity<>(requestJson, headers);

            ResponseEntity<String> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.POST,
                            entity,
                            String.class
                    );

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root =
                    mapper.readTree(response.getBody());

            String aiText =
                    root.get("candidates")
                            .get(0)
                            .get("content")
                            .get("parts")
                            .get(0)
                            .get("text")
                            .asText();

            aiText = aiText.replace("```json", "")
                    .replace("```", "")
                    .trim();

            return mapper.readValue(
                    aiText,
                    JobMatchResponse.class
            );

        } catch (Exception e) {

            return JobMatchResponse.builder()
                    .matchPercentage(0)
                    .suggestions(
                            java.util.List.of(
                                    "Error: " + e.getMessage()
                            )
                    )
                    .build();
        }
    }
}