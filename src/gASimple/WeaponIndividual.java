package gASimple;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class WeaponIndividual {
    private final int DEFAULTGENELENGTH = 256;
    private byte _SpreadGenes;
    private byte _ColorGenes;
    private byte _ThicknessGenes;
    private byte _ShapeGenes;

    public byte getSpreadGenes() {
        return _SpreadGenes;
    }

    public void setSpreadGenes(byte _SpreadGenes) {
        this._SpreadGenes = _SpreadGenes;
    }

    public byte getColorGenes() {
        return _ColorGenes;
    }

    public void setColorGenes(byte _ColorGenes) {
        this._ColorGenes = _ColorGenes;
    }

    public byte getThicknessGenes() {
        return _ThicknessGenes;
    }

    public void setThicknessGenes(byte _ThicknessGenes) {
        this._ThicknessGenes = _ThicknessGenes;
    }

    public byte getShapeGenes() {
        return _ShapeGenes;
    }

    public void setShapeGenes(byte _ShapeGenes) {
        this._ShapeGenes = _ShapeGenes;
    }
    
    
    public int getSpreadInt() {
        return unsignedIntFromByte(_SpreadGenes);
    }

    public int getColorInt() {
        return unsignedIntFromByte(_ColorGenes);
    }

    public int getThicknessInt() {
        return unsignedIntFromByte(_ThicknessGenes);
    }

    public int getShapeInt() {
        return unsignedIntFromByte(_ShapeGenes);
    }
    
    private int unsignedIntFromByte(byte pByte) {
        return pByte & 0xFF;
    }
    
    /**
     * Generates a new random individual
     */
    
    public void generateWeaponIndividual() {
        _SpreadGenes = (byte) (DEFAULTGENELENGTH*Math.random());
        _ColorGenes = (byte) (DEFAULTGENELENGTH*Math.random());
        _ThicknessGenes = (byte) (DEFAULTGENELENGTH*Math.random());
        _ShapeGenes = (byte) (DEFAULTGENELENGTH*Math.random());
        
    }
    
    public int size() {
        return DEFAULTGENELENGTH;
    }
    
    public static void main(String[] args) {
        WeaponIndividual weaponTest = new WeaponIndividual();
        weaponTest.generateWeaponIndividual();
        System.out.println(weaponTest.getColorInt());
    }
}
