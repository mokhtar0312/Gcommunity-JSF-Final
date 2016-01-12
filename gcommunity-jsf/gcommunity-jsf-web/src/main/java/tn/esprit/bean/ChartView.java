package tn.esprit.bean;
import javax.annotation.PostConstruct;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import entities.ActiveMember;
import entities.Vote;
import services.interfaces.ActiveMemberServicesLocal;
import services.interfaces.VoteServicesLocal;
 
@ManagedBean
@ViewScoped
public class ChartView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel;


 @EJB
	private ActiveMemberServicesLocal activeMemberServiceLocal;
 @EJB
	private VoteServicesLocal voteServicesLocal;
    
 List<Vote>listeDesVotes;
 List<ActiveMember>ListeCandidats;
 
 
 
    @PostConstruct
    public void init() {
    	ListeCandidats=activeMemberServiceLocal.findAllActiveMember();
    	listeDesVotes=voteServicesLocal.findAllVotes();
    	
        createPieModels();
        
   
		
    }
 
 
     
    private void createPieModels() {
        createPieMode();
    
    }
 

     
    private void createPieMode() {
    	pieModel = new PieChartModel();
        int nbrevote=0;
    	for(ActiveMember m:ListeCandidats){
    		for(Vote v:listeDesVotes){
    			
    			if(v.getActivemembervoter().getId()==m.getId()){nbrevote++;}
    			
    		}
    		if(nbrevote>0)
    			{
    			pieModel.set(m.getName(), nbrevote);
    			nbrevote=0;
    			}
    		
    	}
    	
    	
    	
       
         
        pieModel.setTitle("Votes For This Year");
        pieModel.setLegendPosition("e");
       
    }

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}
     
}