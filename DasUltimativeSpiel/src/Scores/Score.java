package Scores;

/*@author Christian Leunig */

public class Score implements Comparable<Score>{

	private String name;
	private int punkte;
	
	public Score(String name, int punkte){
		this.name = name;
		this.punkte = punkte;
	}
	
	public void setPunkte(int punkte){
		this.punkte = punkte;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getPunkte(){
		return punkte;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * @return umgekehrte Reihenfolge
	 */
	public int compareTo(Score other){
		return -Integer.compare(getPunkte(), other.getPunkte());
	}
	
	@Override
	public String toString()
	{
		return getName() + " " + getPunkte();
	}
	
}
