import br.ufrn.imd.smartRu.inteligencia.InteligenceRu;

public class Teste2{
	
	private static InteligenceRu iu;
	
	public static void main(String[] args) {
		
		int nRasps = 1;
		int numSensores = 6;
		
		iu = new InteligenceRu(nRasps, numSensores);
		String dados = new String(iu.mock());
		iu.adicionarRaspberryFromJason(dados);
		int[][] mat = new int[nRasps][numSensores];
		
		mat = iu.receberMatriz();
		
		for(int i = 0; i < nRasps; i++){
			for(int j = 0; j < numSensores; j++){
				System.out.print(mat[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("Porcentagem da fila: " + iu.percentFila(mat));
	}
	
}