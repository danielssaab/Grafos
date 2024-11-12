import java.util.ArrayList;
import java.util.List;

abstract class Grafo {
	protected List<Vertice> vertices;

	public Grafo() {
		this.vertices = new ArrayList<>();
	}

	public void adicionarVertice(String nome) {
		Vertice vertice = new Vertice(nome);
		if (!vertices.contains(vertice)) {
			vertices.add(vertice);
		}
	}

	public Vertice buscarVertice(String nome) {
		for (Vertice v : vertices) {
			if (v.getNome().equals(nome)) {
				return v;
			}
		}
		return null;
	}

	public abstract void adicionarAresta(String nomeOrigem, String nomeDestino);

	public void exibirGrafo() {
		for (Vertice vertice : vertices) {
			System.out.print(vertice.getNome() + " -> ");
			for (Aresta aresta : vertice.getArestas()) {
				System.out.print(aresta.getDestino().getNome() + " ");
			}
			System.out.println();
		}
	}

	public int ordem() {
		return vertices.size();
	}

	public void calcularGraus() {
		for (Vertice vertice : vertices) {
			System.out.println("Vértice " + vertice.getNome() + " tem grau: " + vertice.getGrau());
		}
	}
}