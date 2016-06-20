import br.ufrn.imd.smartRu.inteligencia.*;

public class Teste2{
	
	private static InteligenceRu iu;
	private static Config conf;

	public static void main(String[] args) {
		
		int nRasps = 1;
		int numSensores = 6;
		
		iu = new InteligenceRu(nRasps, numSensores);
		conf = new Config(); 
		String dados = new String(conf.mock("Rasp1"));
		iu.adicionarRaspberryFromJason(dados);
		int[][] mat = new int[nRasps][numSensores];
		
		mat = iu.receberMatriz();
		
		for(int i = 0; i < nRasps; i++){
			for(int j = 0; j < numSensores; j++){
				System.out.print(mat[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("Porcentagem da fila: " + iu.percentFila(mat)*100);
	}
	
}