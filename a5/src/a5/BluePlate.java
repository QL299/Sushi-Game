package a5;

public class BluePlate implements Plate {

	private Sushi contents;

	public BluePlate(Sushi contents) throws PlatePriceException {
		this.contents = contents;
	}

	@Override
	public Sushi getContents() {
		Sushi get;
		if (contents == null) {
			get = null;
		} else {
			get = contents;
		}
		return get;
	}

	@Override
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
		if (s.getCost() >= 4.0) {
			throw new PlatePriceException();
		}
		contents = s;

	}

	@Override
	public boolean hasContents() {
				boolean has = true;
		if (contents == null) {
			has = false;
		}
		return has;
	}

	@Override
	public double getPrice() {
				return 4.0;
	}

	@Override
	public Color getColor() {
				return Color.BLUE;
	}

	@Override
	public double getProfit() {
				double profit;
		if (contents == null) {
			profit = 0.0;
		} else {
			profit = 4.0 - contents.getCost();
		}
		return profit;
	}

}
