package pkg;

public class Empleado {
	
	public enum TipoEmpleado{Vendedor, Encargado};
	float salarioBase;
	float primas;
	float extras;

	public float calculoNominaBruta(TipoEmpleado tipo, float ventaMes, float horasExtra) {
		if(tipo == TipoEmpleado.Encargado)
		{
			salarioBase = 2500;
		}else if (tipo == TipoEmpleado.Vendedor) {
			salarioBase = 2000;
		}
		
		if (ventaMes >= 1500){
			primas = 200;
		}else if (ventaMes >= 1000) {
			primas = 100;
		}else {
			primas = 0;
		}
		
		extras = horasExtra * 30;
		
		return salarioBase + primas + extras;
				
	}
	
	public float calculoNominaNeta(float nominaBruta) {
		
		float retencion = 0;
		if (nominaBruta > 2500) {
			retencion = 0.18f;
		}else if (nominaBruta > 2000) {
			retencion = 0.15f;
		}
		
		return (nominaBruta * (1 - retencion));
	}
}
