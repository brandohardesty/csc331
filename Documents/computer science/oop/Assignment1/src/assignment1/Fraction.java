package assignment1;

public class Fraction {
	//properties
	/**
	 * A Numerator
	 */
	private double num;
	/**
	 * A Denominator
	 */
	private double den;
	
	//constructor
	/**
	 * Constructs a fraction object from a numerator and a denominator.
	 * @param num numerator
	 * @param den denominator
	 */
	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
		
        double gcf = gcf(num,den);
		
        this.num = (int) (num / gcf);
		this.den = (int) (den / gcf);
		}
	/**
	 * Constructs a fraction from a decimal value.
	 * @param value decimal value
	 */
	public Fraction(double value) {
		double num = value * 100;
		double den = 100;
		
		double gcf = gcf(num,den);
		
		this.num = (int) (num / gcf);
		this.den = (int) (den / gcf);
		
			
		
		
	}
	
	//behaviors
	/**
	 * Determines the greatest common factor of the numerator and denominator
	 * @param num numerator
	 * @param den denominator
	 * @return the greatest common factor
	 */
	public double gcf(double num, double den) {
		if(den == 0) {
			
			return num;
			
		}
		return gcf(den,num % den);
	}
	/**
	 * Converts the Fraction type to a String type.
	 * @return A Fraction as a String.
	 */
	public String toString() {
		
		return  (int) this.num + "/" + (int) this.den;
		
	}
	/**
	 * Converts the Fraction to a double type.
	 * @return Fraction value as decimal
	 */
	public double toDecimal() {
		return this.num / this.den;
	}
	/**
	 * Adds this Fraction to another Fraction.
	 * @param other other Fraction
	 * @return The sum of the two Fractions
	 */
	public Fraction add(Fraction other) {
		Fraction result = new Fraction(0,1);
		if(this.den == other.den) {
			result.num = this.num + other.num;
			result.den = this.den;
		} else {
			result.num = (this.num * other.den) + (other.num * this.den);
			result.den = this.den * other.den;
		}
		double temp = result.num;
		
		result.num /=  gcf(result.num,result.den);
		result.den /=  gcf(temp,result.den);
		
		return result;
		
	}
	/**
	 * Subtracts another Fraction from this Fraction
	 * @param other other Fraction
	 * @return The difference of the two fractions
	 */
	public Fraction sub(Fraction other) {
		Fraction result = new Fraction(0,1);
		if(this.den == other.den) {
			result.num = this.num - other.num;
			result.den = this.den;
		} else {
			result.num = (this.num * other.den) - (other.num * this.den);
			result.den = this.den * other.den;
		}
		
		return result;
		
	}
	/**
	 * Multiplies this Fraction with another Fraction
	 * 
	 * @param other other Fraction
	 * @return The product of the two Fractions
	 */
	public Fraction mult(Fraction other) {
		Fraction result = new Fraction(0,1);
		result.num = this.num * other.num;
		result.den = this.den * other.den;
		double temp = result.num;
		
		result.num /=  gcf(result.num,result.den);
		result.den /=  gcf(temp,result.den);
		

		return result;
	}
	/**
	 * Divides this Fraction by another Fraction
	 * @param other other Fraction
	 * @return The quotient of the two Fractions
	 */
	public Fraction div(Fraction other) {
		Fraction result = new Fraction(0,1);
		result.num = this.num * other.den;
		result.den = this.den * other.num;
		
		double temp = result.num;
		
		result.num /=  gcf(result.num,result.den);
		result.den /=  gcf(temp,result.den);
		
		return result;
	}
	/**
	 * Compares this Fractions numerical value to another Fractions numerical value
	 * @param other other Fraction
	 * @return 1 if this Fraction is greater than the other, 0 if the Fractions are equivalent, or -1 if this Fraction is less than the other.
	 */
	public int compareTo(Fraction other) {
		if(toDecimal() > other.toDecimal()) {
			return 1;
		}
		else if(toDecimal() < other.toDecimal()) {
			return -1;
		}
		return 0;
	}
	
	

}
