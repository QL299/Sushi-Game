package a5;

public class GreenPlate implements Plate {

	private Sushi contents;

	public GreenPlate(Sushi contents) throws PlatePriceException {
		this.contents = contents;
	}

	
	public Sushi getContents() {
				Sushi get;
		if (contents == null) {
			get = null;
		} else {
			get = contents;
		}
		return get;
	}


	public Sushi removeContents() {
				Sushi remove;
		if (contents == null) {
			remove = null;
		} else {
			remove = contents;
			contents = null;
		}
		return remove;
	}
	
	@Override
	public void setContents(Sushi s) throws PlatePriceException {
				if (s == null) {
			throw new IllegalArgumentException("contents is null");
		}
		if (s.getCost() >= 2.0) {
			throw new PlatePriceException();
		}
		contents = s;

	}

	
	public boolean hasContents() {
				boolean has = true;
		if (contents == null) {
			has = false;
		}
		return has;
	}

	public double getPrice() {
				return 2.0;
	}

	public Color getColor() {
				return Color.GREEN;
	}

	public double getProfit() {
				double profit;
		if (contents == null) {
			profit = 0.0;
		} else {
			profit = 2.0 - contents.getCost();
		}
		return profit;
	}

}
