/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author ajka
 */
public class PatIm {
    private Complex image;
    private Complex pattern;
    
    public void setPattern(Complex pattern){
        this.pattern=pattern;
    }
    public void setImage(Complex image){
        this.image=image;
    }
    public Complex getPattern(){
        return pattern;
                
    }
    public Complex getImage(){
        return image;
    }
    
}
