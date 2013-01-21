package project;

import project.functions.Function;

public class ValueImage {

    private Complex value;
    private Complex image;

    public void evaluate(Function f, Complex c) {
        this.image = f.evaluate(value, c);
    }

    public void setValue(Complex pattern) {
        this.value = pattern;
    }

    public void setImage(Complex image) {
        this.image = image;
    }

    public Complex getValue() {
        return value;
    }

    public Complex getImage() {
        return image;
    }
}
