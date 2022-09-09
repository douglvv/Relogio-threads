
public class Cronometro implements Runnable {
	private boolean estado;
	private int hora;
	private int min;
	private int seg;
		
	public Cronometro(boolean estado, int hora, int min, int seg) {
		this.estado = estado;
		this.hora = hora;
		this.min = min;
		this.seg = seg;
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

	public int getSeg() {
		return seg;
	}

	public void setSeg(int seg) {
		this.seg = seg;
	}
	
	public void iniciarCronometro() {
		this.estado = true;
		System.out.println("\nCronometro inciado!\n");
	}
	
	public void pararCronometro() {
		this.estado = false;
		System.out.println("\nCronometro parado!\n");
		String tempo ="\n" + "Tempo: " + this.hora + ":" + this.min + ":" + this.seg + "\n";
		System.out.println(tempo);
	}
	public void zerarCronometro() {
		this.hora = 0;
		this.min = 0;
		this.seg = 0;
		this.estado = false;
		System.out.println("\nCronometro zerado!\n");
	}

	@Override
	public void run() {
		System.out.println("thread 3 rodando...");
		try {
			while(this.isEstado() == true) {			
				
				if(this.seg < 60) {
					this.seg++;
				}
				if(this.seg == 60) {
					this.seg = 0;
					this.min++;
				}
				if(this.min == 60) {
					this.min = 0;
					this.hora++;
				}
				if(this.hora == 24) {
					this.hora = 0;
				}
				Thread.sleep(1000);
			}
			}
			catch (Exception e){}
		}
	}

