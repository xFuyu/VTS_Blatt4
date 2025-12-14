public class MeineFigur extends Figur {

  @Override
  public void setPosition(char x, int y) {
    this.x = x;
    MachMal.eineZehntelSekundeLangGarNichts();
    this.y = y;
  }

  @Override
  public String getPosition() {
    char a = this.x;
	MachMal.eineZehntelSekundeLangGarNichts();
	return a +" , " + this.y;
  }
}

