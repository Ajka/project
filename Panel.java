/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import project.shapes.Dot;
import project.shapes.Line;

/**
 *
 * @author ajka
 */
public interface Panel {
        public ArrayList<PatIm> dots = new ArrayList<PatIm>();
        public ArrayList<Line> lines = new ArrayList<Line>();
}
