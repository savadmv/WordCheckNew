
package com.test.wordcheck.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("definition")
    @Expose
    private String definition;
    @SerializedName("partOfSpeech")
    @Expose
    private Object partOfSpeech;
    @SerializedName("synonyms")
    @Expose
    private List<String> synonyms = null;
    @SerializedName("similarTo")
    @Expose
    private List<String> similarTo = null;
    @SerializedName("examples")
    @Expose
    private List<String> examples = null;
    @SerializedName("typeOf")
    @Expose
    private List<String> typeOf = null;
    @SerializedName("derivation")
    @Expose
    private List<String> derivation = null;
    @SerializedName("inCategory")
    @Expose
    private List<String> inCategory = null;
    @SerializedName("antonyms")
    @Expose
    private List<String> antonyms = null;
    @SerializedName("pertainsTo")
    @Expose
    private List<String> pertainsTo = null;
    @SerializedName("partOf")
    @Expose
    private List<String> partOf = null;
    @SerializedName("also")
    @Expose
    private List<String> also = null;
    @SerializedName("attribute")
    @Expose
    private List<String> attribute = null;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Object getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(Object partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getSimilarTo() {
        return similarTo;
    }

    public void setSimilarTo(List<String> similarTo) {
        this.similarTo = similarTo;
    }

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    public List<String> getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(List<String> typeOf) {
        this.typeOf = typeOf;
    }

    public List<String> getDerivation() {
        return derivation;
    }

    public void setDerivation(List<String> derivation) {
        this.derivation = derivation;
    }

    public List<String> getInCategory() {
        return inCategory;
    }

    public void setInCategory(List<String> inCategory) {
        this.inCategory = inCategory;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }

    public List<String> getPertainsTo() {
        return pertainsTo;
    }

    public void setPertainsTo(List<String> pertainsTo) {
        this.pertainsTo = pertainsTo;
    }

    public List<String> getPartOf() {
        return partOf;
    }

    public void setPartOf(List<String> partOf) {
        this.partOf = partOf;
    }

    public List<String> getAlso() {
        return also;
    }

    public void setAlso(List<String> also) {
        this.also = also;
    }

    public List<String> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<String> attribute) {
        this.attribute = attribute;
    }

}
