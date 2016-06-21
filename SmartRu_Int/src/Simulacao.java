import br.ufrn.imd.smartRu.inteligencia.Config;
import br.ufrn.imd.smartRu.inteligencia.InteligenceRu;
import br.ufrn.imd.smartRu.inteligencia.MockDados;

public class Simulacao{
	
	private static InteligenceRu iRu;
	private static Config config;
	private static MockDados mock;
	private static String nomeDispositivo1 = "R1";
	private static String nomeDispositivo2 = "R2";
	
	public static void main(String[] args) {
		
		config = new Config();
		iRu = new InteligenceRu(config);
		mock = new MockDados();
		
		//Registrar Dispositivos
		iRu.registrarDispositivo(nomeDispositivo1);
		iRu.registrarDispositivo(nomeDispositivo2);
		
		int qtdMatrizes = 0;
		while(qtdMatrizes < 20){
			
			//Carregar dados dos dispositivos registrados
			String dadoR1 = mock.geraDadosDispositivo(nomeDispositivo1);
			String dadoR2 = mock.geraDadosDispositivo(nomeDispositivo2);
			
			iRu.salvarLeiturasDispositivo(dadoR1);
			iRu.salvarLeiturasDispositivo(dadoR2);
			
			//iRu.getAppFila().imprimirDadosFila();
			iRu.montarMatriz();
			
			qtdMatrizes++;
		}
		
		
		double resultado = iRu.percentFila();
		
		System.out.println(resultado);
		
	}
	
}