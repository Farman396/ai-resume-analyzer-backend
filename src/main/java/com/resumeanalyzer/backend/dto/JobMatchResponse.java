package com.resumeanalyzer.backend.dto;

import lombok.*;

import java.util.List;


@Builder
public class JobMatchResponse {

    private int matchPercentage;

    private List<String> matchingSkills;

    private List<String> missingSkills;

    private List<String> suggestions;

    private List<String> interviewQuestions;

    public JobMatchResponse(){}

    public JobMatchResponse(int matchPercentage, List<String> matchingSkills, List<String> missingSkills, List<String> suggestions, List<String> interviewQuestions) {
        this.matchPercentage = matchPercentage;
        this.matchingSkills = matchingSkills;
        this.missingSkills = missingSkills;
        this.suggestions = suggestions;
        this.interviewQuestions = interviewQuestions;
    }

    public int getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(int matchPercentage) {
        this.matchPercentage = matchPercentage;
    }

    public List<String> getMatchingSkills() {
        return matchingSkills;
    }

    public void setMatchingSkills(List<String> matchingSkills) {
        this.matchingSkills = matchingSkills;
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

    public List<String> getInterviewQuestions() {
        return interviewQuestions;
    }

    public void setInterviewQuestions(List<String> interviewQuestions) {
        this.interviewQuestions = interviewQuestions;
    }
}