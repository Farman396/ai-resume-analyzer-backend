package com.resumeanalyzer.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resume_analysis")
@Builder
public class ResumeAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int atsScore;

    @Column(columnDefinition = "LONGTEXT")
    private String technicalSkills;

    @Column(columnDefinition = "LONGTEXT")
    private String missingSkills;

    @Column(columnDefinition = "LONGTEXT")
    private String suggestions;

    @Column(columnDefinition = "LONGTEXT")
    private String professionalSummary;

    private String analyzedBy;

    public ResumeAnalysis(){}

    public ResumeAnalysis(Long id, int atsScore, String technicalSkills, String missingSkills, String suggestions, String professionalSummary, String analyzedBy) {
        this.id = id;
        this.atsScore = atsScore;
        this.technicalSkills = technicalSkills;
        this.missingSkills = missingSkills;
        this.suggestions = suggestions;
        this.professionalSummary = professionalSummary;
        this.analyzedBy = analyzedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAtsScore() {
        return atsScore;
    }

    public void setAtsScore(int atsScore) {
        this.atsScore = atsScore;
    }

    public String getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(String technicalSkills) {
        this.technicalSkills = technicalSkills;
    }

    public String getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(String missingSkills) {
        this.missingSkills = missingSkills;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getProfessionalSummary() {
        return professionalSummary;
    }

    public void setProfessionalSummary(String professionalSummary) {
        this.professionalSummary = professionalSummary;
    }

    public String getAnalyzedBy() {
        return analyzedBy;
    }

    public void setAnalyzedBy(String analyzedBy) {
        this.analyzedBy = analyzedBy;
    }
}