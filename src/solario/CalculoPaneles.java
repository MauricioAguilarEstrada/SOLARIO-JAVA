package solario;

public class CalculoPaneles {
	//SE DECLARAN LKAS VARIABLES ESTATICAS, LAS QUE NO CAMBIAN SU VALOR
	private static final double w = 620, w2 = 520;
	private static final int horasPico = 4; 
	//SE DECLARAN LAS VARIABLES QUE SE VAN A UTILIZAR
	private double consumoAnual;
	private double consumoBimestralPromedio;
	private double potenciaPanel = w/1000;
	private double potenciaPanel2 = w2/1000;
	private double panelesCalculados; 
	
	//SE DECLARA EL CONSTRUCTOR CON LAS VARIABLES NECESARIAS PARA LOS CALCULOS
	public CalculoPaneles(double consumoAnual, double consumoBimestralPromedio, double panelesCalculados)  {
		this.consumoAnual = consumoAnual;
		this.consumoBimestralPromedio = consumoBimestralPromedio;
		this.panelesCalculados = panelesCalculados;
				
	}

	//SE DECLARAN LOS GETTES
	public double getConsumoAnual() {
		return consumoAnual;
	}
	public double getConsumoBimestralPromedio() {
		return consumoBimestralPromedio;
	}
	public double getPotenciaPanel() {
		return potenciaPanel;
	}
	public double getPotenciaPanel2() {
		return potenciaPanel2;
	}
	public double getPanelesCalculados() {
		return panelesCalculados;
	}

	//ESTE METODO HACE EL CALCULO DEL CONSUMO BIMESTRAL PROMEDIO A PARTIR DEL CONSUMO ANUAL
	public double cBP() {
		//OBTIENE EL VALOR DEL CONSUMO ANUAL
		double cBP = getConsumoAnual()/6;
		return cBP;
	}
	//CALCULA EL NUMERO DE PANELES A PARTIR DEL PANEL NUMERO 1
	public double nP() {
		//LA FORMULA QUE HACE EL CALCULO DEL NUMERO DE PANELES NECESARIOS
		double nP = (((cBP()/60)/horasPico)/potenciaPanel);
		return nP;
	}
	//CALCULA EL NUMERO DE PANELES A PARTIR DEL PANEL NUMERO 1

	public double nP2() {
		//LA FORMULA QUE HACE EL CALCULO DEL NUMERO DE PANELES NECESARIOS
		double nP = (((cBP()/60)/horasPico)/potenciaPanel2);
		return nP;
	}
	

}
