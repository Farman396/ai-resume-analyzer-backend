package com.resumeanalyzer.backend.dto;

import lombok.*;

import java.util.List;


@Builder
public class ResumeAnalysisResponse {

    private int atsScore;

    private List<String> technicalSkills;

    private List<String> missingSkills;

    private List<String> suggestions;

    private String professionalSummary;

    public ResumeAnalysisResponse(){}

    public ResumeAnalysisResponse(int atsScore, List<String> technicalSkills, List<String> missingSkills, List<String> suggestions, String professionalSummary) {
        this.atsScore = atsScore;
        this.technicalSkills = technicalSkills;
        this.missingSkills = missingSkills;
        this.suggestions = suggestions;
        this.professionalSummary = professionalSummary;
    }

    public int getAtsScore() {
        return atsScore;
    }

    public void setAtsScore(int atsScore) {
        this.atsScore = atsScore;
    }

    public List<String> getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(List<String> technicalSkills) {
        this.technicalSkills = technicalSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }

    public String getProfessionalSummary() {
        return professionalSummary;
    }

    public void setProfessionalSummary(String professionalSummary) {
        this.professionalSummary = professionalSummary;
    }
}