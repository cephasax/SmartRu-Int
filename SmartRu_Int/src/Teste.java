import br.ufrn.imd.smartRu.modelo.FilaRu;
import br.ufrn.imd.smartRu.modelo.Raspberry;
import br.ufrn.imd.smartRu.modelo.Sensor;

public class Teste {

	
	
	public static void main(String[] args) {
		FilaRu appFila;
		int linha = 5;
		int coluna = 5;
		
		double VALOR_PADRAO = 30.0;
		appFila = new FilaRu(linha, coluna);
		int a = 20;
		for(int cont = 0; cont < 4; cont++ ){
			Raspberry rp = new Raspberry("rasp - " + cont);
			for(int c = 0; c < 3; c++){
				Sensor s = new Sensor(rp.getIdentificador() + " : sensor - " + c);
				s.setValor(a);
				a++;
				rp.getSensores().add(s);
			}
			appFila.incluirRasp(rp);
		}
		
		int[][] matriz = new int[linha][coluna];
		int numLinTemp = 0;
		int numColTemp = 0;
		double v = -1;
		
		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				
				v = -1;
				if((i < appFila.getRasps().size()) && 
						(j < appFila.getRasps().get(i).getSensores().size())){
					
					v = appFila.getRasps().get(i).getSensores().get(j).getValor();
				}
								
				//verificacao do valor do sensor e insercao na matriz de inteiros
				if( (v >= 0) && (v <= VALOR_PADRAO)){
					matriz[i][j] = 1;
				}
				else if(v > VALOR_PADRAO){
					matriz[i][j] = 0;
				}
				else if(v < 0){
					matriz[i][j] = -1;
				}
			}
		}
		
		for(int x = 0; x < linha; x++){
			for(int y = 0; y < coluna; y++){
				System.out.print(matriz[x][y] + "  ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int x = 0; x < linha; x++){
			for(int y = 0; y < coluna; y++){
				if(x < appFila.getRasps().size() && y < appFila.getRasps().get(x).getSensores().size())
				System.out.print(appFila.getRasps().get(x).getSensores().get(y).getValor() + "\t");
				else
					System.out.print("x\t");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		for(int x = 0; x < linha; x++){
			for(int y = 0; y < coluna; y++){
				if(x < appFila.getRasps().size() && y < appFila.getRasps().get(x).getSensores().size())
				System.out.print(appFila.getRasps().get(x).getSensores().get(y).getNome() + "\t");
			}
			System.out.println();
		}

	}

}
