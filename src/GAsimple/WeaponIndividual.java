package GAsimple;

import java.util.BitSet;
import java.util.Random;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class WeaponIndividual {
    static int DEFAULTGENELENGTH = 8;
    private BitSet _SpreadGenes = new BitSet(DEFAULTGENELENGTH);
    private BitSet _ColorGenes = new BitSet(DEFAULTGENELENGTH);
    private BitSet _ThicknessGenes = new BitSet(DEFAULTGENELENGTH);
    private BitSet _ShapeGenes = new BitSet(DEFAULTGENELENGTH);
    
    public BitSet getSpreadGenes() {
        return _SpreadGenes;
    }

    public void setSpreadGenes(BitSet _SpreadGenes) {
        this._SpreadGenes = _SpreadGenes;
    }

    public BitSet getColorGenes() {
        return _ColorGenes;
    }

    public void setColorGenes(BitSet _ColorGenes) {
        this._ColorGenes = _ColorGenes;
    }

    public BitSet getThicknessGenes() {
        return _ThicknessGenes;
    }

    public void setThicknessGenes(BitSet _ThicknessGenes) {
        this._ThicknessGenes = _ThicknessGenes;
    }

    public BitSet getShapeGenes() {
        return _ShapeGenes;
    }

    public void setShapeGenes(BitSet _ShapeGenes) {
        this._ShapeGenes = _ShapeGenes;
    }
    
    /**
     * Generates a new random individual
     */
    
    public void generateWeaponIndividual() {
        Random randomBoolean = new Random();
        for(int genePos = 0; genePos < size(); genePos++) {
            _SpreadGenes.set(genePos, randomBoolean.nextBoolean());
            _ColorGenes.set(genePos, randomBoolean.nextBoolean());
            _ThicknessGenes.set(genePos, randomBoolean.nextBoolean());
            _ShapeGenes.set(genePos, randomBoolean.nextBoolean());
        }
    }
    
    public int size() {
        return DEFAULTGENELENGTH;
    }
    
}
