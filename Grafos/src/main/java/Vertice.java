import java.util.ArrayList;
import java.util.List;

public class Vertice {
	private String nome;
	private List<Aresta> arestas;

	public Vertice(String nome) {
		this.nome = nome;
		this.arestas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void adicionarAresta(Aresta aresta) {
		arestas.add(aresta);
	}

	public int getGrau() {
		return arestas.size(); // Grau do vértice (apenas em grafos não orientados)
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Vertice vertice = (Vertice) obj;
		return nome.equals(vertice.nome);
	}

	@Override
	public int hashCode() {
		return nome.hashCode();
	}

	@Override
	public String toString() {
		return nome;
	}
}