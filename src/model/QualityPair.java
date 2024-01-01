package model;

public class QualityPair {
    private Qualities qualityOne;
    private int qualityOneValue = 0;
    private Qualities qualityTwo;
    private int qualityTwoValue = 100;

    public QualityPair(Qualities qualityOne, Qualities qualityTwo) {
        this.qualityOne = qualityOne;
        this.qualityTwo = qualityTwo;
    }

    public Qualities getQualityOne() {
        return qualityOne;
    }

    public void setQualityOne(Qualities qualityOne) {
        this.qualityOne = qualityOne;
    }

    public int getQualityOneValue() {
        return qualityOneValue;
    }

    public int setQualityOneValue(int qualityOneValue) {
        return this.qualityOneValue = qualityOneValue;
    }

    public Qualities getQualityTwo() {
        return qualityTwo;
    }

    public void setQualityTwo(Qualities qualityTwo) {
        this.qualityTwo = qualityTwo;
    }

    public int getQualityTwoValue() {
        return qualityTwoValue;
    }

    public int setQualityTwoValue(int qualityTwoValue) {
        return this.qualityTwoValue = qualityTwoValue;
    }
}
