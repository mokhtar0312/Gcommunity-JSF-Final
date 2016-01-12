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

import services.interfaces.PacksServicesRemote;
import entities.Packs;

@ManagedBean(name = "packs")
@RequestScoped
public class PacksBean {

	@EJB
	private PacksServicesRemote servicesRemote;

	private List<Packs> packss;
	private BarChartModel barModel;
	private Packs p = new Packs();
	private boolean showForm = false;
	private Boolean dispTable = false;
	private String name;
	private int id;
	private boolean edit;
	private String searchh;

	public PacksBean() {
	}

	public List<Packs> getPackss() {
		return packss;
	}

	public void setPackss(List<Packs> packss) {
		this.packss = packss;
	}

	public Packs getP() {
		return p;
	}

	public void setP(Packs p) {
		this.p = p;
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
		setPackss(servicesRemote.findAllPacks());
		createBarModels();

	}

	public void doDisplayTable() {
		dispTable = true;
	}

	public String doCreatePacks() {

		servicesRemote.addPacks(p);
		init();
		p = new Packs();
		dispTable = false;

		return "";
	}

	public void edit(Packs item) {

		this.p = item;
		edit = true;
	}

	public String doDeletePacks() {
		servicesRemote.deletePacks(p);
		init();
		p = new Packs();
		return "";
	}

	public String doFindPaksByName() {
		packss = (List<Packs>) servicesRemote.findPacksByName(searchh);
		return "";
	}

	public String doUpdatePacks() {
		servicesRemote.updatePacks(p);
		init();
		p = new Packs();
		return "";
	}

	public String doFindPacksById(int id) {
		servicesRemote.findPacksById(id);
		return "";
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	private BarChartModel initBarModel() {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;

		for (Packs l : packss) {
			if (l.getPrice() < 50) {
				a = a + 1;
			} else if ((l.getPrice() < 100) && (l.getPrice() > 50))
				b = b + 1;
			else if ((l.getPrice() > 100) && (l.getPrice() < 200)) {
				c = c + 1;
			} else if (l.getPrice() > 200)
				d = d + 1;

		}

		BarChartModel model = new BarChartModel();

		ChartSeries dia = new ChartSeries();
		dia.setLabel("Bronze Packs");
		dia.set("", a);

		ChartSeries plat = new ChartSeries();
		plat.setLabel("Silver Packs");
		plat.set("Silver", b);

		ChartSeries Gold = new ChartSeries();
		Gold.setLabel("Gold Packs");
		Gold.set("Gold", c);

		ChartSeries sil = new ChartSeries();
		sil.setLabel("Diamond Packs");
		sil.set("Diamond", d);

		model.addSeries(dia);
		model.addSeries(plat);
		model.addSeries(Gold);
		model.addSeries(sil);

		return model;
	}

	private void createBarModels() {
		createBarModel();

	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Our Packs Distribution");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Packs");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("");
		yAxis.setMin(0);
		yAxis.setMax(4);
	}

}
