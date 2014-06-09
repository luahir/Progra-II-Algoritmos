package lib;

public class Weapon {
	private ColorType _Color;
	private ShapeType _Shape;
	private SpreadType _Spread;
	private ThicknessType _Thick;
	
	public Weapon(int pColor, int pShape, int pSpread, int pThickness) {
		_Color = ColorType.getColorType(pColor);
		_Shape = ShapeType.getShapeType(pShape);
		_Spread = SpreadType.getSpreadType(pSpread);
		_Thick = ThicknessType.getThicknessType(pThickness);
	}
	
	public ColorType getColor() {
		return _Color;
	}

	public ShapeType getShape() {
		return _Shape;
	}

	public SpreadType getSpread() {
		return _Spread;
	}

	public ThicknessType getThick() {
		return _Thick;
	}
}
