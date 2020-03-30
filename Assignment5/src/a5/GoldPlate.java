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


	public void setContents(Sushi s) throws PlatePriceException {
				if (s == null) {
			throw new IllegalArgumentException("contents is null");
		}
		if (s.getCost() >= price) {
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
				return price;
	}


	public Color getColor() {
				return Color.GOLD;
	}


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
