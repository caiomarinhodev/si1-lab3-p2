package com;

import java.util.ArrayList;
import java.util.List;

public class Normal extends Strategy{

	public Episodio getProximoEp(Serie s) {
		int t = getTemporadaIncompleta(s);
		if(t!=-1){
			List<Episodio> eps = s.getEpisodios(t);
			int i = 0;
			int index = -1;
			while (i < eps.size()) {
				if(eps.get(i).isAssistido()) {
					index = i;
				}
				i++;
			}
			if(index == i-1){
				return null;
			}
			if(index == -1) {
				return eps.get(0);
			}
			return eps.get(index+1);
		}
	}
	
	private int getTemporadaIncompleta(Serie s){
		int index = -1;
		int totalTemp = s.getTemporadas().size();
		for(int i=1; i<=totalTemp; i++){
			if(s.isTemporadaAssistidaIncompleta(i)){
				index = i;
				return index;
			}
		}
		System.out.println("INDEX:"+index);
		return index;
	}

}
