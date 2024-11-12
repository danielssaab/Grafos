class GrafoOrientado extends Grafo {
	@Override
	public void adicionarAresta(String nomeOrigem, String nomeDestino) {
		Vertice origem = buscarVertice(nomeOrigem);
		Vertice destino = buscarVertice(nomeDestino);

		if (origem == null) {
			origem = new Vertice(nomeOrigem);
			vertices.add(origem);
		}
		if (destino == null) {
			destino = new Vertice(nomeDestino);
			vertices.add(destino);
		}

		Aresta aresta = new Aresta(origem, destino);
		origem.adicionarAresta(aresta);
	}

	public void calcularGrausOrientados() {
		for (Vertice vertice : vertices) {
			int grauEntrada = 0;
			int grauSaida = vertice.getArestas().size();

			for (Vertice v : vertices) {
				for (Aresta aresta : v.getArestas()) {
					if (aresta.getDestino().equals(vertice)) {
						grauEntrada++;
					}
				}
			}

			System.out.println("Vértice " + vertice.getNome() + " - Grau de entrada: " + grauEntrada + ", Grau de saída: " + grauSaida);
		}
	}
}