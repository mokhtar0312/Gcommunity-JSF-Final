package tn.esprit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;





import javax.faces.view.ViewScoped;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.staticdata.Champion;
import com.robrua.orianna.type.core.staticdata.ChampionSpell;


@ManagedBean
@SessionScoped
public class ChampsBean {
	private String lore;
	private String[] lores = new String[10];
	

	public String[] getLores() {
		return lores;
	}
	public void setLores(String[] lores) {
		this.lores = lores;
	}
	

	private String lol;
	private String loli;
	private String[] lolis = new String[10];
	public String[] getLolis() {
		return lolis;
	}
	public void setLolis(String[] lolis) {
		this.lolis = lolis;
	}
	//private int i;
	public String getLore() {
		return lore;
	}
		public void setLore(String lore) {
			this.lore = lore;
		}
		public String getLol() {
			return lol;
		}
		public void setLol(String lol) {
			this.lol = lol;
		}
		
	
	
	
		@PostConstruct
		public void getsLore(){
		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey("e42452b3-20e3-4401-87e6-d86926e5ffac");
		
		
		List<Champion> champions = RiotAPI.getChampions();
		
		for (int i = 0; i < 6; i++) {
			System.out.println(champions.get(i));
			lore = champions.get(i).getLore();
			lores[i] = champions.get(i).getLore();
			//lol = RiotAPI.getChampions().get(i).getSpells().get(i).getImage().getFull();
		loli = champions.get(i).getImage().getFull();
		lol ="http://ddragon.leagueoflegends.com/cdn/5.9.1/img/champion/"+loli;
		
		lolis[i]=lol;
			System.out.println(lores[i]);
			System.out.println(lolis[i]);

		}
			
		}
}