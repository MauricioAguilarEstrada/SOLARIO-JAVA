package solario;

//ES UNA CLASE HIJA DE CALCULOPANELES, HEREDA TODOS SUS ATRIBUTOS
public class CalculoAhorro extends CalculoPaneles{
	//SE DECLARAN LKAS VARIABLES ESTATICAS, LAS QUE NO CAMBIAN SU VALOR
	private static final double PRECIO_EXCEDENTE = 3.861;
	private double dAC = PRECIO_EXCEDENTE * 1.16;
	private static final int INSTALACION = 55200;
	private static final int PRECIO_PANEL_620 = 2640;
	private static final int PRECIO_PANEL_510 = 1875;
	
	//SE DECLARAN LAS VARIABLES QUE SE VAN A UTILIZAR
	private double generacionPromedioBimestral;
	private double generacionPromedioDiario;
	private double prctAhorro;
	private double ahorroD;
	private double ahorroB;
	private double ahorroA;
	private int cotizacion;
	
	//SE DECLARA EL CONSTRUCTOR CON LAS VARIABLES NECESARIAS PARA LOS CALCULOS
	public CalculoAhorro(double consumoAnual, double consumoBimestralPromedio, double panelesCalculados, double generacionPromedioBimestral, 
			double generacionPromedioDiario, double prctAhorro, double ahorroD,double ahorroB, double ahorroA,int cotizacion) {
		super(consumoAnual, consumoBimestralPromedio, panelesCalculados);
		this.generacionPromedioBimestral = generacionPromedioBimestral;
		this.generacionPromedioDiario = generacionPromedioBimestral;
		this.prctAhorro = prctAhorro;
		this.ahorroD = ahorroD;
		this.ahorroB = ahorroB;
		this.ahorroA = ahorroA;
		this.cotizacion = cotizacion;
	}

	//SE DECLARAN LOS GETTERS
	public double getGeneracionPromedioBimestral() {
		return generacionPromedioBimestral;
	}
	public double getGeneracionPromedioDiario() {
		return generacionPromedioDiario;
	}
	public double getPrctAhorro() {
		return prctAhorro;
	}
	public double getPrecioExcedente() {
		return PRECIO_EXCEDENTE;
	}
	public double getdAC() {
		return dAC;
	}
	public double getAhorroD() {
		return ahorroD;
	}
	public double getAhorroB() {
		return ahorroB;
	}
	public double getAhorroA() {
		return ahorroA;
	}
	public int getInstalacion() {
		return INSTALACION;
	}
	public int getPrecioPanel620() {
		return PRECIO_PANEL_620;
	}
	public int getPrecioPanel510() {
		return PRECIO_PANEL_510;
	}
	public int getCotizacion() {
		return cotizacion;
	}
	
	//SE OBTIENE LA POTENCIA DE TODOS LOS PANELES EN CONJUNTO
	public double pT() {
		 double pT = getPanelesCalculados() * getPotenciaPanel();
		 return pT;
	}
	//SE OBTIENE LA GENERACION BIMESTRAL QUE TENDRIAN LOS PANELES
	public double gBP() {
		//FORMULA PARA LA OBTENCION DE LA GENERACION BIMESTRAL
		double gBP =  pT()*240;
		return gBP;
	}
	//SE OBTIENE LA GENERACION DIARIA QUE TENDRIAN LOS PANELES
	public double gDP() {
		//SE OBTIENE A PARTIR DE LA GENERACION BIMESTRAL
		double gDP = gBP();
		gDP = gDP/60;
		return gDP;
	}
	//SE OBTIENE EL PORCETNJE DE AHORRO DE LOS PANELES RESPECTO AL CONSUMO BIMESTRAL
	public double pA() {
		double pA = (gBP()/ cBP()) *100;
		//ES IRRELEVANTE SI EL AHORRO ES MAYOR AL 100 POR CIERTO, ENTONCES EL MAXIMO QUE PUEDE GUARDARSE ES 100
		if (pA > 100) {
			pA = 100;
		}
		return pA;
	}
	//SE OBTIENE EL VALOR DEL AHORRO DIARIO EN PESOS
	public double aD() {
		double aD = dAC * gDP();
		return aD;
	}
	//SE OBTIENE EL VALOR DEL BIMESTRAL DIARIO EN PESOS A PARTIR DEL AHORRO DIARIO
	public double aB() {
		double aB = aD()*60;
		return aB;
	}
	//SE OBTIENE EL VALOR DEL BIMESTRAL ANUAL EN PESOS A PARTIR DEL AHORRO DIARIO
	public double aA() {
		double aA = aD() * 365;
		return aA;
	}
	//SE OBTIENE EL PRECIO DEL TOTAL DE LO PANELES
	public int precioPaneles() {
		return (int) (getPanelesCalculados() * PRECIO_PANEL_620);
	}
	//SE OBTIENE EL TOTAL DE LA COTIZACION
	public int cotizacion() {
		//ES LA SUMA DEL VALOR DE LA INSTALACION MAS EL TOTAL DE LOS PANELES
		return (int) (INSTALACION + precioPaneles());
	}
	
	
	
	//SE REPITEN LOS METODOS CON LOS VALORES DEL SEGUNDO TIPO DE PANEL
	
	public double pT2() {
		 double pT = getPanelesCalculados() * getPotenciaPanel2();
		 return pT;
	}
	public double gBP2() {
		double gBP =  pT2()*240;
		return gBP;
	}
	public double gDP2() {
		double gDP = gBP2();
		gDP = gDP/60;
		return gDP;
	}
	public double pA2() {
		double pA = (gBP2()/ cBP()) *100;
		if (pA > 100) {
			pA = 100;
		}
		return pA;
	}
	public double aD2() {
		double aD = dAC * gDP2();
		return aD;
	}
	public double aB2() {
		double aB = aD2()*60;
		return aB;
	}
	public double aA2() {
		double aA = aD2() * 365;
		return aA;
	}
	public int precioPaneles2() {
		return (int) (getPanelesCalculados() * PRECIO_PANEL_510);
	}
	public int cotizacion2() {
		return (int) (INSTALACION + precioPaneles2());
	}
}
