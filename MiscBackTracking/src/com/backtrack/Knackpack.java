package com.backtrack;

class Element {

	private int weight;
	private int benefit;
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getBenefit() {
		return benefit;
	}
	
	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}
	
	public Element() {
	}

	public Element(int weight, int benefit) {
		this.weight = weight;
		this.benefit = benefit;
	}

}

class Backpack {
	
	private int maxWeight;
	private Element[] elements;
	private int weight;
	private int benefit;
	
	public int getMaxWeight() {
		return maxWeight;
	}
	
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public Element[] getElements() {
		return elements;
	}
	
	public void setElements(Element[] elements) {
		this.elements = elements;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getBenefit() {
		return benefit;
	}
	
	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}

	public Backpack() {
	}

	public Backpack(int maxWeitgh, int numElements) {
		this.maxWeight = maxWeight;
		this.elements = new Element[numElements];
		this.benefit = 0;
		this.weight = 0;
	}
	
	public void addElement(Element e) {
	
		for (int i = 0; i < this.elements.length; i++) {
			if (this.elements[i] == null) {
				this.elements[i] = e;
				this.benefit += e.getBenefit();
				this.weight += e.getWeight();
				break;
			}
			
		}
	
	}
	
	public void removeElement(Element e) {
		
		for (int i = 0; i < this.elements.length; i++) {
			if (this.elements[i].equals(e)) {
				this.elements[i] = null;
				this.benefit -= e.getBenefit();
				this.weight -= e.getWeight();
				break;
			}
			
		}
	
	}
	
	public boolean existsElement(Element e) {
		
		for (int i = 0; i < this.elements.length; i++) {
			if (this.elements[i] != null && this.elements[i].equals(e)) {
				return true;
			}
		}
		return false;

	}

	public void clear() {
		
		this.weight = 0;
		this.benefit = 0;
		for (int i = 0; i < this.elements.length; i++) {
			this.elements[i] = null;
		}
		
	}

}

public class Knackpack {

	public static void main(String[] args) {

		Element[] elements = {
				new Element(1, 1),
				new Element(2, 2),
				new Element(4, 10),
				new Element(1, 2),
				new Element(12, 4)
		};
		
		Backpack base = new Backpack(15, elements.length);
		Backpack optimal = new Backpack(15, elements.length);
		
		fillBackpack(base, optimal, elements, false);
		
		System.out.println(optimal);
		
	}
	
	public static void fillBackpack(Backpack base, Backpack optimal, Element[] elements, boolean full) {
		
		if (full == true) {
			if (base.getBenefit() > optimal.getBenefit()) {
				Element[] baseElements = base.getElements();
				optimal.clear();
				for (Element element : baseElements) {
					if (element != null) {
						optimal.addElement(element);
					}
				}
			}
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (!base.existsElement(elements[i])) {
					if (base.getMaxWeight() > base.getWeight() + elements[i].getWeight()) {
						base.addElement(elements[i]);
						fillBackpack(base, optimal, elements, false);
						base.removeElement(elements[i]);
					} else {
						fillBackpack(base, optimal, elements, true);
					}
				}
			}
		}
	}
		
}

