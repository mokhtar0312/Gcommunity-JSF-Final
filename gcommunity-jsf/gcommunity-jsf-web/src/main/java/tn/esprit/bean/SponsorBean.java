package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import entities.Sponsor;
import services.interfaces.SponsorServicesRemote;


@ManagedBean
@RequestScoped
public class SponsorBean {
	@EJB
	SponsorServicesRemote servicesRemote;

private List<Sponsor> sponsors;
private BarChartModel barModel;
private Sponsor m=new Sponsor();
private boolean showForm = false;
private Boolean dispTable = false;
private String name;
private int id;
private boolean edit;
private String searchh;
public List<Sponsor> getSponsors() {
	return sponsors;
}
public void setSponsors(List<Sponsor> sponsors) {
	this.sponsors = sponsors;
}
public Sponsor getM() {
	return m;
}
public void setM(Sponsor m) {
	this.m = m;
}
public boolean isShowForm() {
	return showForm;
}
public void setShowForm(boolean showForm) {
	this.showForm = showForm;
}
public Boolean getDispTable() {
	return dispTable;
}
public void setDispTable(Boolean dispTable) {
	this.dispTable = dispTable;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public boolean isEdit() {
	return edit;
}
public void setEdit(boolean edit) {
	this.edit = edit;
}
public String getSearchh() {
	return searchh;
}
public void setSearchh(String searchh) {
	this.searchh = searchh;
}

@PostConstruct
private void init() {
sponsors =servicesRemote.findAllSponsors();
createBarModels();
}

public void doDisplayTable() {
	dispTable = true;
}


public String doCreateSponsor() {
	
	
		
		servicesRemote.addSponsor(m);
	init();
	m=new Sponsor();
	dispTable = false;
	
	return "";
}

public void edit(Sponsor item) {
	
	
    this.m = item;
    edit = true;
}

public String doDeleteSponsor() {
	servicesRemote.deleteSponsor(m);
	init();
	m=new Sponsor();
	return "";
}
//public String doFindAgencyByName() {
//	m=model3dServicesRemote.findModel3DById(m.getId());
//	return "";
//}
public String doUpdateSponsor(){
	servicesRemote.updateSponsor(m);
	init();
	m=new Sponsor();
	dispTable = false;
	
	return "";

}
public String doFindSponsordById(){
	m= servicesRemote.findSponsorById(id);
	sponsors.add(m);
	System.out.println(m.getDescription());
	return"";
}
public String doFindSponsorByTyped() {
	sponsors= servicesRemote.FindbyTyped(searchh);
	return "";
}





public BarChartModel getBarModel() {
    return barModel;
}


private BarChartModel initBarModel() {
	int a=0;
	int b=0;
	int c = 0;
	int d=0;
	int e =0;
	
	for(Sponsor l:sponsors)
	{
		if(l.getLevel().equals("Diamond"))
			{a =a+1;
	}
		else if(l.getLevel().equals("Platinium"))
			b=b+1;
		else if(l.getLevel().equals("Gold"))
			{c =c+1;
		}
		else if(l.getLevel().equals("Silver"))
			d =d+1;
		else if (l.getLevel().equals("Bronze"))
			e =e+1;
		
	}
	
    BarChartModel model = new BarChartModel();

    ChartSeries dia = new ChartSeries();
    dia.setLabel("Diamond>5000$");
    dia.set("",a);
    

    ChartSeries plat = new ChartSeries();
    plat.setLabel("Platinum>1250$");
    plat.set("Platinium", b);
    
    ChartSeries Gold = new ChartSeries();
   Gold.setLabel("Gold>1000$");
    Gold.set("Gold", c);
    
    ChartSeries sil = new ChartSeries();
   sil.setLabel("Silver>750$");
    sil.set("Silver", d);
    
    ChartSeries br = new ChartSeries();
    br.setLabel("Bronze>500$");
    br.set("Bronze", e);
    

    model.addSeries(dia);
    model.addSeries(plat);
    model.addSeries(Gold);
    model.addSeries(sil);
    model.addSeries(br);
     
    return model;
}
 
private void createBarModels() {
    createBarModel();
    
}

private void createBarModel() {
    barModel = initBarModel();
     
    barModel.setTitle("Our sponsors distribution");
    barModel.setLegendPosition("ne");
     
    Axis xAxis = barModel.getAxis(AxisType.X);
    xAxis.setLabel("Distribution");
     
    Axis yAxis = barModel.getAxis(AxisType.Y);
    yAxis.setLabel("");
    yAxis.setMin(0);
    yAxis.setMax(4);
}
 
	

}
