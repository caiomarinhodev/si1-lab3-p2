package com;

import java.util.ArrayList;
import java.util.List;

public class Antigo extends Strategy{

	public Episodio getProximoEp(Serie s) {
		int index = getTemp(s);
		if(index!=-1){
			return getProximoEpNaoAssistido(s, index);
		}
		return null;
	}
	

	public Episodio getProximoEpNaoAssistido(Serie s, int temporada){
		List<Episodio> eps = s.getEpisodios(temporada);
		int index = -1;

		for(int i=0; i<eps.size();i++){
			if(!(eps.get(i).isAssistido())){
				index=i;
				return eps.get(index);
			}
		}
		return null;
		
	}

	public int getTemp(Serie s){
		int index = -1;
		int totalTemp = s.getTemporadas().size();
		for(int i=1; i<=totalTemp; i++){
			if(s.isTemporadaNaoAssistida(i) || s.isTemporadaAssistidaIncompleta(i)){
				index = i;
				return index;
			}
		}
		System.out.println("INDEX:"+index);
		return index;
	}

}
