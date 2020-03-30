package a5;

public class GoldPlate implements Plate {

	private Sushi contents;
	private double price;

	public GoldPlate(Sushi contents) throws PlatePriceException {
		this.contents = contents;
		if (price < 5.0) {
			throw new IllegalArgumentException("price must exceed 5.0");
		}
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
		if (s.getCost() >= price) {
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
				return price;
	}

	@Override
	public Color getColor() {
				return Color.GOLD;
	}

	@Override
	public double getProfit() {
				double profit;
		if (contents == null) {
			profit = 0.0;
		} else {
			profit = price - contents.getCost();
		}
		return profit;
	}

}
