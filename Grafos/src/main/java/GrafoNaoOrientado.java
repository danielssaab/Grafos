class GrafoNaoOrientado extends Grafo {
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

		Aresta arestaOrigemDestino = new Aresta(origem, destino);
		Aresta arestaDestinoOrigem = new Aresta(destino, origem);

		origem.adicionarAresta(arestaOrigemDestino);
		destino.adicionarAresta(arestaDestinoOrigem);
	}
}