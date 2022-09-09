import java.util.Scanner;

public class Main {
	static Relogio relogio = new Relogio(12,12,12);
	static Cronometro cronometro = new Cronometro(false,0,0,0);
	static Alarme alarme = new Alarme(relogio,false);
	
	public static void main(String[] args) {
		new Thread(main).start();
		new Thread(relogio).start();
	}
	
	private static Runnable main = new Runnable() {
        public void run() {
        	System.out.println("thread main rodando...");
        	try{
                int opcao = 9;
                try (Scanner input = new Scanner(System.in)) {
					while(opcao != 0) {
						System.out.println("1 - Ajustar Horário\n"+
										   "2 - Exibir Horário\n"+
										   "3 - Iniciar cronômetro\n"+
										   "4 - Parar cronômetro\n"+
										   "5 - Zerar cronômetro\n"+
										   "6 - Definir alarme\n"+
										   "0 - Sair");
					
					opcao = Integer.valueOf(input.nextLine());
					switch(opcao) {
					case 1:
						System.out.println("\nDigite a hora (hh): ");
						relogio.setHora(Integer.valueOf(input.nextLine()));
						System.out.println("\nDigite os minutos (mm): ");
						relogio.setMin(Integer.valueOf(input.nextLine()));
						System.out.println("\nDigite os segundos (ss): ");
						relogio.setSeg(Integer.valueOf(input.nextLine()));
						System.out.println("\nHorário definido com sucesso!");
						break;
					case 2:
						relogio.mostraTempo();
						break;
					case 3:
						cronometro.iniciarCronometro();
						new Thread(cronometro).start();
						break;
					case 4:
						cronometro.pararCronometro();
						break;
					case 5:
						cronometro.zerarCronometro();
						break;
					case 6:
						System.out.println("Digite a hora do alarme: ");
						alarme.setHora(Integer.valueOf(input.nextLine()));
						System.out.println("Digite o minuto do alarme: ");
						alarme.setMin(Integer.valueOf(input.nextLine()));
						alarme.iniciarAlarme();
						new Thread(alarme).start();
						break;
					case 0:
						break;
						}
					}
				}
            } catch (Exception e){}
        }
    };    
    
    
	
	
    

}