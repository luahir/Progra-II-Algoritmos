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

    public void setSpreadGenes(BitSet pSpreadGenes) {
        _SpreadGenes = pSpreadGenes;
    }

    public BitSet getColorGenes() {
        return _ColorGenes;
    }

    public void setColorGenes(BitSet pColorGenes) {
        _ColorGenes = pColorGenes;
    }

    public BitSet getThicknessGenes() {
        return _ThicknessGenes;
    }

    public void setThicknessGenes(BitSet pThicknessGenes) {
        _ThicknessGenes = pThicknessGenes;
    }

    public BitSet getShapeGenes() {
        return _ShapeGenes;
    }

    public void setShapeGenes(BitSet pShapeGenes) {
        _ShapeGenes = pShapeGenes;
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
    
    public static void main(String[] args) {
        WeaponIndividual weaponTest = new WeaponIndividual();
        weaponTest.generateWeaponIndividual();
        System.out.println(weaponTest.getColorGenes().cardinality());
        System.out.println(weaponTest.getColorGenes().toString());
    }
}
