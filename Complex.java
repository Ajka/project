package project;

public class Complex {

    double re;
    double im;

    public Complex() {
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex(Complex input) {
        this.re = input.getRe();
        this.im = input.getIm();
    }

    public double getRe() {
        return this.re;
    }

    public double getIm() {
        return this.im;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public Complex getConjugate() {
        return new Complex(this.re, this.im * (-1));
    }

    public Complex add(Complex op) {
        Complex result = new Complex();
        result.setRe(this.re + op.getRe());
        result.setIm(this.im + op.getIm());
        return result;
    }

    public Complex sub(Complex op) {
        Complex result = new Complex();
        result.setRe(this.re - op.getRe());
        result.setIm(this.im - op.getIm());
        return result;
    }

    public Complex mul(Complex op) {
        Complex result = new Complex();
        result.setRe(this.re * op.getRe() - this.im * op.getIm());
        result.setIm(this.re * op.getIm() + this.im * op.getRe());
        return result;
    }

    public Complex div(Complex op) {
        Complex result = new Complex(this);
        result = result.mul(op.getConjugate());
        double opNormSq = op.getRe() * op.getRe() + op.getIm() * op.getIm();
        result.setRe(result.getRe() / opNormSq);
        result.setIm(result.getIm() / opNormSq);
        return result;
    }

    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    public Complex tan() {
        return sin().div(cos());
    }

    public Complex log() {
        double rpart = Math.sqrt(re * re + im * im);
        double ipart = Math.atan2(im, re);
        if(ipart > Math.PI) {
            ipart = ipart - 2.0 * Math.PI;
        }
        return new Complex(Math.log(rpart), ipart);
    }

    /*public Complex sqrt(){
     double r=Math.sqrt(re*re+im*im);
     double rpart=Math.sqrt(0.5*(r+re));
     double ipart=Math.sqrt(0.5*(r-re));
     if(im<0.0) ipart=-ipart;
     return new Complex(rpart,ipart);
     }*/
    public Complex pow(Complex z) {
        Complex a = z.mul(this.log());
        return a.exp();
    }

    public Complex fromPolar(double magnitude, double angle) {
        Complex result = new Complex();
        result.setRe(magnitude * Math.cos(angle));
        result.setIm(magnitude * Math.sin(angle));
        return result;
    }

    public double getNorm() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    public double getAngle() {
        return Math.atan2(this.im, this.re);
    }
}
