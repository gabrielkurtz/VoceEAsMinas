import java.util.HashSet;

public class Linha {
		public boolean minada;
		public HashSet<Integer> posicaoMinas;
		
		public Linha() {
			posicaoMinas = new HashSet<Integer>();
		}
		
		public void addMina(int pos) {
			minada = true;
			posicaoMinas.add(pos);
		}
		
		public void removeMina(int pos) {
			for (Integer mina : posicaoMinas) {
				if(mina == pos) {
					posicaoMinas.remove(mina);
					if(posicaoMinas.isEmpty()){
						minada = false;
					}
				}
			}
		}
		
		public boolean temMina() {
			return minada;
		}
		
		public Linha copiar() {
			Linha copia = new Linha();
			for (Integer mina : this.posicaoMinas) {
				copia.addMina(mina);
			}
			return copia;
		}
		
		public String toString() {
			String ret =" Minada: " + minada;
			for(Integer mina : this.posicaoMinas) {
				ret += " Mina: " + mina;
			}
			return ret;
		}
		
	}