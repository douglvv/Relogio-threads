
public class Relogio implements Runnable {
	private int hora;
	private int min;
	private int seg;
	
	public Relogio(int hora, int min, int seg) {
		this.hora = hora;
		this.min = min;
		this.seg = seg;
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
	
	public void mostraTempo(){
        String tempo ="\n" + "Horário: " + this.hora + ":" + this.min + ":" + this.seg + "\n";
        System.out.println(tempo);
    }

	@Override
	public void run() {
		System.out.println("thread 2 rodando...");
        while(true) {
    	try{
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
        	Thread.sleep(1000);;
        } catch (Exception e){}
    	
        }
        }; 
		
}
	

