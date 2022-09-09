public class Alarme implements Runnable {
	private int hora;
	private int min;
	boolean estado;
	private Relogio relogio;
	
	public Alarme(Relogio relogio, boolean estado) {
		this.relogio = relogio;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public Relogio getRelogio() {
		return relogio;
	}

	public void setRelogio(Relogio relogio) {
		this.relogio = relogio;
	}
	
	public void iniciarAlarme() {
		this.estado = true;
		System.out.println("\nAlarme definido para: "+ this.hora + " : "+ this.min + " !\n");
	}
	public void desligarAlarme() {
		this.estado = false;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("thread 4 rodando...\n");
			while(this.estado == true) {
				if(this.getHora() == relogio.getHora() && this.getMin() == relogio.getMin()) {
					String alarme = "\nALARME DISPARANDO ÁS: "+ this.getHora() + " : " + this.getMin()+ " !\n";
					System.out.println(alarme);
					this.desligarAlarme();
				}
				else {
					Thread.sleep(1000);
				}
			}
		}
		catch (Exception e){}
		
	}
	
	
	
}
