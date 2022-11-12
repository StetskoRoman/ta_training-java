package com.epam.training.student_Roman_Stecko.SecondStage.JavaIO.OptTask1;

public class CreateRandomNumbers {
    private int nElements;
    private int max;

    public CreateRandomNumbers(int nElements, int max) {
        this.nElements = nElements;
        this.max = max;
    }

    public int getnElements() {
        return nElements;
    }

    public void setnElements(int nElements) {
        this.nElements = nElements;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int [] makeRandom () {
        int [] massive = new int[nElements];
        for (int i = 0; i < massive.length; i++) {
            massive[i] = (int) (Math.random()*(max - (-max) + 2) - max - 1);
        }
        return massive;
    }

}
